package com.test;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.DAO.DAO;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.bean.User;
import com.bean.addUserBean;

public class Main {
	private static final String bucketName="my-first-s3-bucket-a09ec3b2-e594-4667-8e18-3e19d5369470";
	public static void upload(File file,String key,int type){
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
	                "location (C:\\Users\\Xuefan\\.aws\\credentials), and is in valid format.",
	                e);
	    }

	    AmazonS3 s3 = new AmazonS3Client(credentials);
	    Region usWest2 = Region.getRegion(Regions.US_WEST_2);
	    s3.setRegion(usWest2);
	    System.out.println("===========================================");
	    System.out.println("Getting Started with Amazon S3");
	    System.out.println("===========================================\n");
	    if(type==0)
	    s3.putObject(new PutObjectRequest(bucketName+"/public", key, file));
	    //else if(type==-1)
	    //s3.putObject(new PutObjectRequest(bucketName+"/new_folder", key, file));
	    else
	    s3.putObject(new PutObjectRequest(bucketName+"/"+type,key,file));
	    //System.out.println("Downloading an object");
	    //S3Object object = s3.getObject(new GetObjectRequest(bucketName, key));
	}
	public static void main(String args[]){
		File file = new File("C:/Users/Xuefan/Desktop/red.jpg");
		upload(file,"red.jpg",0);
}
}
