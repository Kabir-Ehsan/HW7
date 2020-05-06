package com.example.HW4.Service;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageServ {

    @Value("${awsKey}")
    private String awsKey;

    @Value("${awsSecretKey}")
    private String awsSecretKey;


    public void uploadFile(MultipartFile multipartFile) throws IOException {
    {
        ObjectMetadata data = new ObjectMetadata();
        data.setContentType(multipartFile.getContentType());
        data.setContentLength(multipartFile.getSize());
        BasicAWSCredentials credentials = new BasicAWSCredentials(
                awsKey,
                awsSecretKey
        );

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.DEFAULT_REGION)
                .build();
        PutObjectResult objectResult = s3client.putObject("javabackened", "images/"+multipartFile.getOriginalFilename(), multipartFile.getInputStream(), data);

    }

}

    public S3Object getFile(String key) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(
                awsKey,
                awsSecretKey
        );
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.DEFAULT_REGION)
                .build();
        return s3client.getObject("javabackened", key);
    }

    public void deleteFile(String key) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(
                awsKey,
                awsSecretKey
        );
        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.DEFAULT_REGION)
                .build();
        s3client.deleteObject("javabackened", key);
    }
}


