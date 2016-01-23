package com.S3conn;

import java.util.List;

public class tests3 {
public static void main(String args[]){
	S3CheckFile scheck=new S3CheckFile();
	//System.out.println(scheck.checkFile("public/"));
	//System.out.println(scheck.checkFile("public/myf/"));
	//System.out.println(scheck.checkFile("Infamous.docx"));
	//List<String> list=scheck.listFile();
	//System.out.println(list.get(0));
	//list=scheck.listprivateFile(1);
	//System.out.println(list.get(0));
	//System.out.println(list.get(1));
	/*List<String> result=scheck.list(1);
	for(int i=0;i<result.size();i++){
		System.out.println(result.get(i));
	}
	if(result.size()==0){
		System.out.println("No file founded.");
	}*/
	S3delete s3d=new S3delete();
	s3d.delete("abcf/", 1);
}
}
