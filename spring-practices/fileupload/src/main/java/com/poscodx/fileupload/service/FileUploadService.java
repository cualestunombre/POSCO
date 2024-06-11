package com.poscodx.fileupload.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/Users/woo/upload";
	private static String URL_PATH = "/upload-images";
	
	public String restore(MultipartFile file) {
		String url = null;
		
		File uploadDirectory = new File(SAVE_PATH);
		if(!uploadDirectory.exists()) {
			uploadDirectory.mkdirs();
		}
		
		if(file.isEmpty()) {
			return url;
		}
		
		String originFilename = file.getOriginalFilename();
		Long fileSize = file.getSize();
		String extName = originFilename.substring(originFilename.lastIndexOf(".")+1);
		String saveFilename = generateSaveFilename(extName);
		
		try {
			byte[] data = file.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
			os.write(data);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("파일 전송 중 예외 발생");
		}
		
		
		
		
		return URL_PATH + "/" + saveFilename;
	}

	private String generateSaveFilename(String extName) {
		String filename = "";
		
		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);
		return filename;
	}

}