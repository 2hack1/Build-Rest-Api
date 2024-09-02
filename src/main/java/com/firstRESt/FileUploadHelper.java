package com.firstRESt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	//public final String upload="C:\\Users\\HP\\eclipse-workspace\\BuildRestAPI\\src\\main\\resources\\static\\image";
	public final String upload=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException{
		
	}
	public boolean uploadFile(MultipartFile imFile) {
		boolean f = false;
		try {
			
		//	InputStream is=imFile.getInputStream();
//			byte data[]=new byte[is.available()];
//			is.read(data);
//			FileOutputStream fos=new FileOutputStream(upload+"\\"+imFile.getOriginalFilename());
//			fos.write(data);
//			fos.close();
			Files.copy(imFile.getInputStream(),Paths.get(upload+File.separator+imFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			f=true;
			
			return f;
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println("this is fileHelper main problem");
			e.printStackTrace();
		}
		return f;
	}
}
