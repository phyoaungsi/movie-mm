package com.mmdrama.core.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileWriter {

	
	public boolean writeFile(File f,String path)
	{

	
		FileOutputStream fop = null;
		
		File file = new File(path);
		         
 
		try {
 
			
			
			fop = new FileOutputStream(file);
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			
			
			FileReader fr=new FileReader();
			
			fop.write(fr.readByte(f));
			fop.flush();
			fop.close();
 
			System.out.println("Done"+file.getAbsolutePath());
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
		
	
	
}
