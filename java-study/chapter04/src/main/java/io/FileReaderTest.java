package io;

import java.io.*;

public class FileReaderTest {

	/*
	 * 한 글자 씩바이트를 읽는 IO방식 -> IO를 한번에 처리하지 못하기 때문에 오버헤드가 크다
	 */
	public static void main(String[] args) {
		
		Reader in = null;
		Writer out = null;
		
		try {
			
			in = new FileReader("/Users/woo/무제.txt");
			out = new FileWriter("info.txt");
			
			int data = -1;
			int count = 0;
			
			while((data = in.read()) != -1) {
				System.out.print((char) data);
				count++;
				out.append((char) data);
			}
			
			System.out.println("count:"+ count);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				if(in != null) {
					in.close();
				}
				if(out != null) {
					out.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
