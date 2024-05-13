package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {
	
		public static void main(String[] args) {
			
			FileInputStream fis = null;
			
			try {
				
				fis = new FileInputStream("hello.txt");
				
			}catch(FileNotFoundException  e) {
				
				e.printStackTrace();
				
			}finally {
				try {
					if(fis != null) {
						fis.close();
					}
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
			

		}
}
