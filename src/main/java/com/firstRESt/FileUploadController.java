
package com.firstRESt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {
	@Autowired
	private FileUploadHelper filehelper;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("meri") MultipartFile img) {
//		System.out.println(img.getOriginalFilename());
//		System.out.println(img.getContentType());
//		System.out.println(img.getName());
//		System.out.println(img.getSize());
		try {
			
			if (img.isEmpty()) {
                  
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request please insert the file");
			}
			if (!img.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("the file type is must be jpg");

			}
			
			boolean a= filehelper.uploadFile(img);
			if (a) {
			
			//	return  ResponseEntity.ok("successfully");
				//***** C:\Users\HP\eclipse-workspace\BuildRestAPI\target\classes\static\image( main jaa rahi hai jo directory main jaker dikhegi image****
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(img.getOriginalFilename()).toUriString());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong ! try again");
		
		}
}
