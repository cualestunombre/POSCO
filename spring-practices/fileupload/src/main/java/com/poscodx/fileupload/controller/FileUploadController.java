package com.poscodx.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.fileupload.service.FileUploadService;

@Controller
@RequestMapping({"/file"})
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;
	
	@GetMapping( {"/form","","/"} )
	public String form(){
		return "form";
	}
	
	@RequestMapping( "/upload" )
	public String upload( @RequestParam String email, @RequestParam( "file1" ) MultipartFile file1, Model model ){
		String saveFileName = fileUploadService.restore( file1 );
       	model.addAttribute( "urlImage", saveFileName );
        
		return "result";
	}	
}

