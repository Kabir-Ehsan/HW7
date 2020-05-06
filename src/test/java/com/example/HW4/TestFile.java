package com.example.HW4;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.util.List;

public class TestFile {
    public static void main(String[] args){
        System.out.println("Works");
        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIAURKDI4MHKKHSMX62",
                "mi9Uin4hvuZn86SsgsqejzSjOnbkr2+pe2Gdy37e"
        );

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.DEFAULT_REGION)
                .build();

        List<Bucket> buckets = s3client.listBuckets();
        for(Bucket bucket : buckets) {
            System.out.println(bucket.getName());
        }

        s3client.putObject(
                "javabackened",
                "testtest.txt",
                new File("C:/Users/kabir/Desktop/javabackend/homework6/testtest.txt")
        );

        ObjectListing objectListing = s3client.listObjects("javabackened");
        for(S3ObjectSummary os : objectListing.getObjectSummaries()) {
            //LOG.info(os.getKey());
            System.out.println(os.getKey());
        }

        /*S3Object s3object = s3client.getObject("javabackened", "testtest.txt");
        S3ObjectInputStream inputStream = s3object.getObjectContent();
        FileUtils.copyInputStreamToFile(inputStream, new File("/Users/user/Desktop/hello.txt"));*/

        s3client.deleteObject("javabackened","testtest.txt");
        //String bucketName = "baeldung-bucket";

        /*if(s3client.doesBucketExist(bucketName)) {
            LOG.info("Bucket name is not available."
                    + " Try again with a different Bucket name.");
            return;
        }*/

        //s3client.createBucket(bucketName);
        //AKIAURKDI4MHKKHSMX62
        //mi9Uin4hvuZn86SsgsqejzSjOnbkr2+pe2Gdy37e
        //javabackened
    }
}
