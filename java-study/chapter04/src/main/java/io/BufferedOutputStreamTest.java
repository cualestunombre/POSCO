package io;

import java.io.*;

public class BufferedOutputStreamTest {
	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			// 기반 스트림
			fos = new FileOutputStream("hello.txt");
		
			// 보조 스트림
			bos = new BufferedOutputStream(fos);
			
			for(int i = 'a' ; i <= 'z' ; i ++) {
				bos.write(i);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
