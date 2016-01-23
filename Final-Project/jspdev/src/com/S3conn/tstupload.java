package com.S3conn;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class tstupload {
public static void main (String args[]){
	/*File file=new File("D:/newfile/Course/CPE_640/jspdev/WebRoot/Files");
	String test[];
	test=file.list();
	for(int i=0;i<test.length;i++)
		System.out.println(test[i]);*/
S3download sd=new S3download();
byte[] r=sd.download("Cosmos.A.SpaceTime.Odyssey.S01E01.1080p.BluRay.x264.DTS-WiKi.Sample.mkv", 0);
BufferedOutputStream stream=null;
File file=null;
try{
	file=new File("D:/newfile/Course/CPE_640/jspdev/WebRoot/Files/"+"Cosmos.A.SpaceTime.Odyssey.S01E01.1080p.BluRay.x264.DTS-WiKi.Sample.mkv");
	FileOutputStream fstream=new FileOutputStream(file);
	stream=new BufferedOutputStream(fstream);
	stream.write(r);
}
catch (Exception e){
	e.printStackTrace();
}
finally{
	if(stream!=null){
		try{
			stream.close();
		}
		catch (IOException e1){
			e1.printStackTrace();
		}
	}
	
	
}
}
}
