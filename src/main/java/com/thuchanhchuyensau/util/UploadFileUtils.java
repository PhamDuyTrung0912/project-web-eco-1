package com.thuchanhchuyensau.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UploadFileUtils {

		//private static String root="d:\\Spring MVC\\btl\\src\\main\\webapp\\assets\\image";
	
	private static String root="/image";
	
		public static void writeOrupdate(byte[] bs,String path) throws IOException {
			
			
			
			File file= new File(StringUtils.substringBeforeLast(root+path, "/"));
			if(!file.exists()) {
				file.mkdir();
				
			}
			FileOutputStream fileOutputStream=null;
			try {
			 fileOutputStream= new FileOutputStream(new File(root+path));
			fileOutputStream.write(bs);
			}catch(FileNotFoundException e) {
				e.printStackTrace();			
			}
			finally {
				try {
					if(fileOutputStream!=null) {
				fileOutputStream.close();
				}
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			
			
		}
}
