package com.pactera.spring.boot.learn.common;

import com.pactera.spring.boot.learn.exception.ServiceException;
import io.minio.*;
import io.minio.errors.MinioException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Slf4j
@Component
public class MinioTemplate {

    @Resource
    MinioClient minioClient;

    @Value("${minio.bucket}")
    String bucket;

    public String putObject(InputStream inputStream, String contentType) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            // Make 'pactera' bucket if not exist.
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
            if (!found) {
                // Make a new bucket called 'pactera'.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
            } else {
                log.error("Bucket '{}' already exists.", bucket);
            }

            // uploading
            ObjectWriteResponse pacteraResponse = minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucket)
                            .object(UUID.randomUUID().toString())
                            .stream(inputStream, -1, 10485760)
                            .contentType(contentType).build()
            );
            return pacteraResponse.object();
        } catch (MinioException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Boolean removeObject(String objectName) throws MinioException, IOException, NoSuchAlgorithmException, InvalidKeyException {
        // Remove object.
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucket).object(objectName).build());
        return true;
    }

}