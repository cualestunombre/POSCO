package io;


import java.io.*;

public class KeyboardTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			//1. 기반 스트림(std in, System.in)
			//2. 보조 스트림(byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(System.in,"utf-8");
			
			//3. 보조스트림02(char|char|char|\n -> "char|char|char")
			br = new BufferedReader(isr);
			
			
			//4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				if (line.equals("quit")) break;
				System.out.println(line);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
}
