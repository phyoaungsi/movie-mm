package com.mmdrama.core.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.google.gxp.com.google.common.io.Files;
public class FileReader {
	
	
	public ByteArrayInputStream read(String aInputFileName){
	
	    File file = new File(aInputFileName);
	    ByteArrayInputStream input = null;
	    
	    try {
	  
	      try {
	       
	        input = new ByteArrayInputStream(Files.toByteArray(file));	      
	      }
	      finally {
	       
	        input.close();
	      }
	    }
	    catch (FileNotFoundException ex) {
	 
	    }
	    catch (IOException ex) {
	     
	    }
       return input;
	  }
	  
	
	public byte[] readByte(String aInputFileName){
		
	    File file = new File(aInputFileName);
	    InputStream ios=null;
	    ByteArrayOutputStream ous = null;
	    try {
	        byte[] buffer = new byte[4096];
	        ous = new ByteArrayOutputStream();
	         ios = new FileInputStream(file);
	        int read = 0;
	        while ( (read = ios.read(buffer)) != -1 ) {
	            ous.write(buffer, 0, read);
	        }
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
	        try {
	             if ( ous != null ) 
	                 ous.close();
	        } catch ( IOException e) {
	        }

	        try {
	             if ( ios != null ) 
	                  ios.close();
	        } catch ( IOException e) {
	        }
	    }
	    return ous.toByteArray();
	    }
	
	
public byte[] readByte(File inFile){
		
	    File file = inFile;
	    InputStream ios=null;
	    ByteArrayOutputStream ous = null;
	    try {
	        byte[] buffer = new byte[4096];
	        ous = new ByteArrayOutputStream();
	         ios = new FileInputStream(file);
	        int read = 0;
	        while ( (read = ios.read(buffer)) != -1 ) {
	            ous.write(buffer, 0, read);
	        }
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
	        try {
	             if ( ous != null ) 
	                 ous.close();
	        } catch ( IOException e) {
	        }

	        try {
	             if ( ios != null ) 
	                  ios.close();
	        } catch ( IOException e) {
	        }
	    }
	    return ous.toByteArray();
	    }
	


	public static void main(String[] args)
	{
		
		FileReader f=new FileReader();
		f.readByte("c:\\images\\test.jpg");
	}
	

}
