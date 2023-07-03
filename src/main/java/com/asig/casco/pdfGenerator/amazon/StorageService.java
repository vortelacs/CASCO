package com.asig.casco.pdfGenerator.amazon;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class StorageService {

    @Value("${application.bucket.name}")
    private String bucketName;

    private final AmazonS3 s3Client;

    public String uploadFile(byte[] fileContent) {
        String fileName = System.currentTimeMillis() + "_file.pdf";
        String subfolder = "pdfinsurance/";

        String key = subfolder + fileName;
        try (InputStream inputStream = new ByteArrayInputStream(fileContent)) {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(fileContent.length);
            s3Client.putObject(bucketName, key, inputStream, metadata);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file to S3", e);
        }
        return fileName;
    }


    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " removed ...";
    }

}