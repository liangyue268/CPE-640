package com.S3conn;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3CheckFile {
	private static final String bucketName="my-first-s3-bucket-a09ec3b2-e594-4667-8e18-3e19d5369470";
	public List<String> listKeysInDirectory(String bucketName, String prefix,AmazonS3 s3) {
	    String delimiter = "/";
	    if (!prefix.endsWith(delimiter)) {
	        prefix += delimiter;
	    }
	    ObjectListing objects = s3.listObjects(new ListObjectsRequest()
        .withBucketName(bucketName)
        .withPrefix("public/"));
	    /*ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
	            .withBucketName(bucketName).withPrefix("public/");
	           	.withDelimiter(delimiter);
	    ObjectListing objects = s3.listObjects(listObjectsRequest);*/
	    return objects.getCommonPrefixes();
	}
public boolean checkFile(String fname){
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
    ObjectListing objectListing = s3.listObjects(new ListObjectsRequest()
    .withBucketName(bucketName));
for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
	//System.out.println(objectSummary.getKey());
if(objectSummary.getKey().equals(fname))
		return true;
}
return false;
}
public List<String> listFile(){
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
    List<String> flist=listKeysInDirectory(bucketName,"public/",s3);
    return flist;
}
public List<String> listprivateFile(int num){
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
    List<String> flist=listKeysInDirectory(bucketName,num+"/",s3);
    List<String> result=new ArrayList<String>();
    for(int i=0;i<flist.size();i++){
    	String tmp=flist.get(i);
    	if(tmp.endsWith("/"))
    		continue;
    	result.add(tmp.substring(tmp.lastIndexOf("/")));
    }
    return flist;
}
public List<String> list(int num){
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
    System.out.println("Listing objects");
    ObjectListing  objectListing;
    if(num==0){
    objectListing = s3.listObjects(new ListObjectsRequest()
            .withBucketName(bucketName)
            .withPrefix("public/"));
    }
    else{
    	objectListing = s3.listObjects(new ListObjectsRequest()
        .withBucketName(bucketName)
        .withPrefix(num+"/"));
    }
    List<String> result=new ArrayList<String>();
    for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
        //System.out.println(" - " + objectSummary.getKey() + "  " +"(size = " + objectSummary.getSize() + ")");
        String now=objectSummary.getKey();
        if(!now.endsWith("/")){
        	result.add(now.substring(now.lastIndexOf('/')+1));
        }
    }
   return result;
}
}
