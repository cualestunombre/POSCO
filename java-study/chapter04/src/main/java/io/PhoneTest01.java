package io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneTest01 {

	public static void main(String[] args) {
		
		File file = new File("./name.txt");
		FileInputStream fis = null;
		
		try {
			if (!file.exists()) {
				System.out.println("file not found");
				return;
			}
			
			System.out.println("=== 파일 정보 ===");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "Bytes");
			Date d = new Date(file.lastModified());
			String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(d);
			System.out.println(date);
			System.out.println("=== 전화번호 ===");
			
			// 1. 기반 스트림
			fis = new FileInputStream(file);
			
			// 2.보조 스트림(byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			
			// 3.보조 스트림 (char|char|char|\n -> "charcharchar")
			BufferedReader br = new BufferedReader(isr);
			
			// 4.처리
			String line = null;
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line,"\t ");
				int index = 0;
				
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					if (index == 0) {
						System.out.print(token + ":");
					}else if(index == 1 || index == 2) {
						System.out.print(token + "-");
					}else {
						System.out.println(token);
					}
					index ++;
				}
			}
			
			
		} catch (IOException e) {
			//catch안에서 로직을 구현하지 마라!!! -> catch문안에서는 로직 - 사과 - 종료
			e.printStackTrace();
			System.out.println("error:" + e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}                                                 
}
