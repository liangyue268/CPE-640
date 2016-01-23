package com.servlet;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.S3conn.S3download;

public class download_Servlet extends HttpServlet {
	private boolean checkfile(String fname){
    	File localfiles=new File("C:/Users/Xuefan/Desktop/640 HW4/jspdev2/jspdev/WebRoot/Files");
    	String filelist[];
    	filelist=localfiles.list();
    	for(String a:filelist){
    		if(a.equals(fname))
    			return true;
    	}
    	return false;
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException
			{
		   doPost(request,response);
			}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		//获取要下载的文件名
		int dstloca=Integer.parseInt(request.getParameter("req"));
        String filename = request.getParameter("name");
        boolean islocal=checkfile(filename);
        if(islocal){
    		//String filename="vcb_360p.mp4";
            //得到想客服端输出的输出流
            OutputStream outputStream = response.getOutputStream();
            //输出文件用的字节数组，每次向输出流发送600个字节
            byte b[] = new byte[600];
            //要下载的文件
            String ipaddr=request.getLocalAddr();
            File fileload = new File("C:/Users/Xuefan/Desktop/640 HW4/jspdev2/jspdev/WebRoot/Files",filename);   
            //File fileload=new File("http://"+ipaddr+":8080/jspDev/Files",filename);
            //客服端使用保存文件的对话框
            response.setHeader("Content-disposition", "attachment;filename="+filename);
            //通知客服文件的MIME类型
            response.setContentType("application/msword");
            //通知客服文件的长度
            long fileLength = fileload.length();
            String length = String.valueOf(fileLength);
            response.setHeader("Content_length", length);
            //读取文件，并发送给客服端下载
            FileInputStream inputStream = new FileInputStream(fileload);
            int n = 0;
            while((n=inputStream.read(b))!=-1){
                outputStream.write(b,0,n);
            }
        }
        else{
        	BufferedOutputStream stream=null;
        	File file=null;
    		S3download sd=new S3download();
    		byte[] r=sd.download(filename, dstloca);
        	if(dstloca==0){
        		try{
        			file=new File("C:/Users/Xuefan/Desktop/640 HW4/jspdev2/jspdev/WebRoot/Files/"+filename);
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
                OutputStream outputStream = response.getOutputStream();
                byte b[] = new byte[600];
                String ipaddr=request.getLocalAddr();
                File fileload = new File("C:/Users/Xuefan/Desktop/640 HW4/jspdev2/jspdev/WebRoot/Files",filename);   
                response.setHeader("Content-disposition", "attachment;filename="+filename);
                response.setContentType("application/msword");
                long fileLength = fileload.length();
                String length = String.valueOf(fileLength);
                response.setHeader("Content_length", length);
                FileInputStream inputStream = new FileInputStream(fileload);
                int n = 0;
                while((n=inputStream.read(b))!=-1){
                    outputStream.write(b,0,n);
                }
        	}
        	else{
        		response.setHeader("Content-disposition", "attachment;filename="+filename);
                response.setContentType("application/msword");
                response.setHeader("Content_length", String.valueOf(r.length));
        		OutputStream outputStream = response.getOutputStream();
        		outputStream.write(r,0,r.length);
        	}
        }

			}
	}
