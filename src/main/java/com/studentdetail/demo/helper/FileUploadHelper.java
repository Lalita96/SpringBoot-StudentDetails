package com.studentdetail.demo.helper;

import java.io.FileOutputStream;
import java.io.InputStream;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper 
{
	
	public final String UPLOAD_DIR="C:\\Users\\dell\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\SpringBootStudentDetailProject\\src\\main\\resources\\static\\image";

	public boolean uploadFile(MultipartFile multipartFile)
	{
		boolean b = false;
		
		try
		{
			
			//get data from multipartfile in the form of inputStream
			InputStream inputstream = multipartFile.getInputStream();
			
			//create that total data in the form of byte
			byte data[] = new byte[inputstream.available()];
			
			//read the total total
			inputstream.read(data);
			
			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
			fos.write(data);
			fos.close();
			
		// Files.copy(multipartFile.getInputStream() , Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			b=true;
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return b;
	}
}
