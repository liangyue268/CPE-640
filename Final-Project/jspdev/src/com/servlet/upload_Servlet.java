package com.servlet;
import javax.servlet.*;  
import javax.servlet.http.*;  

import java.io.*;  
import java.util.*;  

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;  
import org.apache.commons.fileupload.disk.*;

import com.DAO.DAO;
import com.S3conn.S3upload;
public class upload_Servlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String filePath;    // 文件存放目录  
    private String tempPath;    // 临时文件目录  
 
    // 初始化  
    public void init(ServletConfig config) throws ServletException  
    {  
        super.init(config);  
        // 从配置文件中获得初始化参数  
        //filePath = config.getInitParameter("filepath");  
        //tempPath = config.getInitParameter("temppath");  
        filePath="/Files";
        tempPath="/tmpFiles";
        ServletContext context = getServletContext();  
        System.out.println(filePath+"\n"+tempPath);
        filePath = context.getRealPath(filePath);  
        tempPath = context.getRealPath(tempPath);  
        //如果路径不存在，则创建路径
        File pathFile = new File(filePath);
        File pathTemp = new File(tempPath);
        if(!pathFile.exists()){
        	pathFile.mkdirs();
        }
        if(!pathTemp.exists()){
        	pathTemp.mkdirs();
        }
        System.out.println("文件存放目录、临时文件目录准备完毕 ...");  
        System.out.println("存放目录:"+pathFile.getAbsolutePath());
        System.out.println("临时目录:"+pathTemp.getAbsolutePath());
    }  
      
    // doPost  
    public void doPost(HttpServletRequest req, HttpServletResponse res)  
        throws IOException, ServletException  
    {  
        res.setContentType("text/plain;charset=gbk");  
        PrintWriter pw = res.getWriter();  
        try{  
            DiskFileItemFactory diskFactory = new DiskFileItemFactory();  
            // threshold 极限、临界值，即硬盘缓存 1G 
            diskFactory.setSizeThreshold(1000 * 1024 * 1024);  
            // repository 贮藏室，即临时文件目录  
            diskFactory.setRepository(new File(tempPath));  
          
            ServletFileUpload upload = new ServletFileUpload(diskFactory);  
            // 设置允许上传的最大文件大小 1G 
            upload.setSizeMax(1000 * 1024 * 1024);  
            // 解析HTTP请求消息头  
            List<FileItem> fileItems = upload.parseRequest(new ServletRequestContext(req));  
            Iterator<FileItem> iter = fileItems.iterator();  
            int num=Integer.parseInt(req.getParameter("priv"));
            while(iter.hasNext())  
            {  
                FileItem item = (FileItem)iter.next();  
                if(item.isFormField())  
                {  
                    System.out.println("处理表单内容 ...");  
                    processFormField(item, pw);  
                }else{  
                    System.out.println("处理上传的文件 ...");  
                    processUploadFile(item, pw,num);  
                }  
            }// end while()  
 
            pw.close();  
        }catch(Exception e){  
            System.out.println("使用 fileupload 包时发生异常 ...");  
            e.printStackTrace();  
        }// end try ... catch ...  
    }// end doPost()  
 
 
    // 处理表单内容  
    private void processFormField(FileItem item, PrintWriter pw)  
        throws Exception  
    {  
        String name = item.getFieldName();  
        String value = item.getString();          
        pw.println(name + " : " + value + "\r\n");  
    }  
      
    // 处理上传的文件  
    private void processUploadFile(FileItem item, PrintWriter pw,int mynum)  
        throws Exception  
    {  
        // 此时的文件名包含了完整的路径，得注意加工一下
        String filename = item.getName();         
        System.out.println("完整的文件名：" + filename);  
        int index = filename.lastIndexOf("\\");  
        filename = filename.substring(index + 1, filename.length());  
 
        long fileSize = item.getSize();  
 
        if("".equals(filename) && fileSize == 0)  
        {             
            System.out.println("文件名为空 ...");  
            return;  
        }  
 
        File uploadFile = new File(filePath + "/" + filename);  
        if(!uploadFile.exists()){
        	uploadFile.createNewFile();
        }
        item.write(uploadFile);  
        S3upload s3bean=new S3upload();
        s3bean.upload(uploadFile, filename,mynum);
        if(mynum!=0){
        	uploadFile.delete();
        }
        else{
        DAO d=new DAO();
        d.addFiletodb(filename);
        }
        pw.println(filename + " File Saved ...");  
        pw.println("File Size:" + fileSize + "\r\n");  
    }  
      
    public void doGet(HttpServletRequest req, HttpServletResponse res)  
        throws IOException, ServletException  
    {  
        doPost(req, res);  
    }  
}
/*
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class upload_Servlet  extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{
		String tempFileName=new String("tempFileName");
		File tempFile=new File("D:/"+tempFileName);
		FileOutputStream outputStream=new FileOutputStream(tempFile);
		InputStream fileSource1=request.getInputStream();
		byte b[]=new byte[1000];
		int n;
		while((n=fileSource1.read(b))!=-1){
			outputStream.write(b,0,n);
		}
		outputStream.close();
		fileSource1.close();
		RandomAccessFile randomFile=new RandomAccessFile(tempFile,"r");
		randomFile.readLine();
		String filePath=randomFile.readLine();
		int position=filePath.lastIndexOf('\\');
		String filename=filePath.substring(position,filePath.length()-1);
		randomFile.seek(0);
		long forthEnterPosition=0;
		int forth=1;
		while((n=randomFile.readByte())!=-1&&(forth<=4)){
			if(n=='\n'){
				forthEnterPosition=randomFile.getFilePointer();
				forth++;
			}
		}
		File fileupLoad=new File("D/wkspc","upload");
		fileupLoad.mkdir();
		File saveFile=new File("D:/wkspc/upload",filename);
		RandomAccessFile randomAccessFile=new RandomAccessFile(saveFile,"rw");
		randomFile.seek(randomFile.length());
		long endPosition=randomFile.getFilePointer();
		int j=1;
		while((endPosition>=0)&&(j<=4)){
			endPosition--;
			randomFile.seek(endPosition);
			if(randomFile.readByte()=='\n'){
				j++;
			}
		}
		randomFile.seek(forthEnterPosition);
		long startPoint=randomFile.getFilePointer();
		while(startPoint<endPosition){
			randomAccessFile.write(randomFile.readByte());
			startPoint=randomFile.getFilePointer();
		}
		randomAccessFile.close();
		randomFile.close();
		tempFile.delete();
			}

}*/
