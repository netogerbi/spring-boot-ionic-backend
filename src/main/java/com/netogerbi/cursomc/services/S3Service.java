package com.netogerbi.cursomc.services;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3Service {

	private Logger LOG = LoggerFactory.getLogger(AmazonS3.class);
	
	@Autowired
	private AmazonS3 s3client;
	
	@Value("${s3.bucket}")
	private String bucketName;
	
	
	public void uploadFile(String filePath) {
		try {
			File file = new File(filePath);
			LOG.info("Upload starting.");
			s3client.putObject(new PutObjectRequest(bucketName, "teste.png",file));
			LOG.info("Upload finished.");
		}catch(AmazonServiceException e) {
			LOG.info("AmazonServiceException: "+e.getErrorMessage());
			LOG.info("Status Code: "+e.getErrorCode());
		}catch(AmazonClientException e) {
			LOG.info("AmazonClientException: "+e.getMessage());
		}
		
	}
	
	
}
