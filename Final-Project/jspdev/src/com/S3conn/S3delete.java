package com.S3conn;

import java.io.FileInputStream;
import java.io.IOException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;

public class S3delete {
	private static final String bucketName="my-first-s3-bucket-a09ec3b2-e594-4667-8e18-3e19d5369470";
	public void delete(String key,int num){
		AWSCredentials credentials = null;
		String awsAccessKey = "AKIAJQ2WHP3LNTSESI5Q";
		String awsSecreyKey = "rJE1skiC9ZMs20juLSG/gEGvjaJG3r1Z4hwGMHJb";
	    try {
	    	credentials=new BasicAWSCredentials(awsAccessKey, awsSecreyKey);
	        //credentials = new ProfileCredentialsProvider("default").getCredentials();
	    } catch (Exception e) {
	        throw new AmazonClientException(
	                "Cannot load the credentials from the credential profiles file. " +
	                "Please make sure that your credentials file is at the correct " +
	                "location (C:\\Users\\Shiyu\\.aws\\credentials), and is in valid format.",
	                e);
	    }
	    AmazonS3 s3 = new AmazonS3Client(credentials);
	    Region usWest2 = Region.getRegion(Regions.US_WEST_2);
	    s3.setRegion(usWest2);
	    System.out.println("===========================================");
	    System.out.println("Getting Started with Amazon S3");
	    System.out.println("===========================================\n");
		s3.deleteObject(bucketName+"/"+num, key);
	}
}
