package io;

import java.io.*;

public class FileCopy {

	/*
	 * 한 글자 씩바이트를 읽는 IO방식 -> IO를 한번에 처리하지 못하기 때문에 오버헤드가 크다
	 */
	public static void main(String[] args) {
		
		InputStream is = null;
		OutputStream os = null;
		
		try {
			
			is = new FileInputStream("/Users/woo/Desktop/code/bit/java-study/chapters/src/main/resources/seokwoo.jpg");
			os = new FileOutputStream("/Users/woo/Desktop/code/bit/java-study/chapters/src/main/resources/seokwoo.copy.jpg");
			
			int data = is.read();
			
			while((data = is.read()) != -1) {
				os.write(data);
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				if(is != null) {
					is.close();
				}
				if(os != null) {
					os.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
