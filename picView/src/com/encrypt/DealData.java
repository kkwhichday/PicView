package com.encrypt;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class DealData {
	
	

	
	//工作路径
	private String workPath="";
	//工作路径下的图片源路径
	private String workSrcPath="";
	//工作路径下的加密后图片路径
	private String workDestPath="";
    
	private String keyParamter="";
	
	
	public String getKeyParamter() {
		return keyParamter;
	}


	public void setKeyParamter(String keyParamter) {
		this.keyParamter = keyParamter;
	}


	public  void encryptData() throws IOException {
		try {
             String curpath = System.getProperty("user.dir");
		     //Process pro = Runtime.getRuntime().exec("resource/exe/executable/J-UNIWARD.exe -v -I resource/exe/images_cover -O resource/exe/images_stego -a 0.2");
			 Process pro = Runtime.getRuntime().exec(curpath
					+ "/J-UNIWARD.exe -v -I "
					+ workSrcPath
					+ " -O "
		            +workDestPath+" -a 0.2");
		     BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream(),"GBK"));
		     String msg = null;
		     StringBuilder sout= new StringBuilder();
		     while ((msg = br.readLine()) != null) {
		    	System.out.println(msg);
		    	sout.append(msg);
		     }
		    //JOptionPane.showMessageDialog(null, sout);
		}catch (IOException exception) {
			
		}
	}
	
	
	public  String create(String workPath){
		
		 File dir = new File(workPath);
	        if (dir.exists()) {	        	
	            System.out.println("目标目录"+workPath+"已经存在");  
				return workPath;  
	        }  

	        //创建目录  
	        if (dir.mkdirs()) {          	
	            System.out.println("创建目录" + workPath + "成功！");  	            
	            return workPath;  
	        } else {  
	            System.out.println("创建目录" + workPath + "失败！");  
	            return null;  
	        }   
	       
	}
	
	public DealData(String destDirName){
				
		this.workPath = create(destDirName);
	    if(workPath!=null){
			this.workSrcPath = create(destDirName+"/原图片");
			this.workDestPath = create(destDirName+"/加密后图片");
		}
	}


	public String getWorkPath() {
		return workPath;
	}


	public void setWorkPath(String workPath) {
		this.workPath = workPath;
	}


	public String getWorkSrcPath() {
		return workSrcPath;
	}


	public void setWorkSrcPath(String workSrcPath) {
		this.workSrcPath = workSrcPath;
	}


	public String getWorkDestPath() {
		return workDestPath;
	}


	public void setWorkDestPath(String workDestPath) {
		this.workDestPath = workDestPath;
	}



	
}