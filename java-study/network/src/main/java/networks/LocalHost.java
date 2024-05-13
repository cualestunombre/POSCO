package networks;

import java.io.IOException;
import java.net.InetAddress;

public class LocalHost {
	
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			
			System.out.println(hostName);
			System.out.println(hostAddress);
		
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
