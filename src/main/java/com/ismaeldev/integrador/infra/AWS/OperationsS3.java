package com.ismaeldev.integrador.infra.AWS;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Component
public class OperationsS3 {
    private AmazonS3 clientS3;

    @Value("${aws.s3.accessKey}")
    protected String accessKey;

    @Value("${aws.s3.secretKey}")
    protected String secretKey;


    protected void clientSetup(String accessKey, String secretKey) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        clientS3 = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.SA_EAST_1)
                .build();
    }

    public void saveFile(String objectKey, MultipartFile file) throws Exception {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());
            this.clientSetup(accessKey, secretKey);
            this.clientS3.putObject(new PutObjectRequest("sigveiculos", objectKey, file.getInputStream(), metadata));

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
