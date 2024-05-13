package io;

import java.io.*;


public class BufferedReaderTest {
	
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		
		
		try {
			// 기반 스트림
			fr = new FileReader("hello.txt");
		
			// 보조 스트림
			br = new BufferedReader(fr);
			
			String s;
			
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
				
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
