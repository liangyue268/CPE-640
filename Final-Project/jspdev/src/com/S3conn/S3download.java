package com.S3conn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;

public class S3download {
	private static final String bucketName="my-first-s3-bucket-a09ec3b2-e594-4667-8e18-3e19d5369470";
	public byte[] download(String key,int num){
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
	    S3Object object;
	    if(num==0)
	    	object= s3.getObject(new GetObjectRequest(bucketName+"/public", key));
	    else
	    	object= s3.getObject(new GetObjectRequest(bucketName+"/"+num, key));
	    byte[] byteArray = null;
	    try {
			byteArray = IOUtils.toByteArray(object.getObjectContent());
			FileInputStream fis;
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return byteArray;
	    /*BufferedReader reader = new BufferedReader(new InputStreamReader(object.getObjectContent()));
	    String result="";
	    FileInputStream fis = null;
	    try {
	    	while (true) {
	    		String line;
	    		line = reader.readLine();		
				if (line == null) break;
				result+=line;	
	    	}
        fis=new FileInputStream(result);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    return fis;*/
	}
}
