package io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScannerTest01 {

	public static void main(String[] args) {
		
		File file = new File("./name.txt");
		Scanner scanner = null;
		
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
		
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) { 
				
				String name = scanner.next(); // tab, space, 개행으로 분리한다
				String phone01 = scanner.next();
				String phone02 = scanner.next();
				String phone03 = scanner.next();
				
				System.out.println(name+":"+phone01+"-"+phone02+"-"+phone03);
	
			}
			
			
			
		} catch (IOException e) {
			//catch안에서 로직을 구현하지 마라!!! -> catch문안에서는 로직 - 사과 - 종료
			e.printStackTrace();
			System.out.println("error:" + e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}                                                 
}
