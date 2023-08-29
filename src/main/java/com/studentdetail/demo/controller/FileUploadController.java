package com.studentdetail.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.studentdetail.demo.helper.FileUploadHelper;

@RestController
public class FileUploadController 
{
	@Autowired
	private FileUploadHelper fileuploadHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		
		try
		{
			if (file.isEmpty()) 
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must contain File...");
			}
			
			boolean b = fileuploadHelper.uploadFile(file);
			
			if (b) 
			{
				return ResponseEntity.ok("File uploaded.....");
			}
		
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong..Try again.");
	}

}
