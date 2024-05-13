package networks;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

public class NSLookup {
	public static void main(String[] args)  {

		
		Scanner scanner = new Scanner(System.in);
		
		String input = null;
		
		
		while(!(input = scanner.nextLine()).equals("exit")) {
			
			try {
				Arrays.stream(InetAddress.getAllByName(input))
				.forEach(s->System.out.println(s.getHostName() +" : " + s.getHostAddress()));
			}catch(IOException e) {
				e.printStackTrace();
			}
		
			
		}
	}
	
	
}
