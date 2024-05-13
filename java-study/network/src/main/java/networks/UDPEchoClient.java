package networks;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPEchoClient {
	private static final String SERVERIP = "127.0.0.1";
	private static final int SERVERPORT = 8040;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {

		
	
		
		
		
		// 2. 소켓 생성
		try(DatagramSocket socket = new DatagramSocket();
			Scanner scanner = new Scanner(System.in)){
			
			while(true) {
				System.out.println(">");
				String message = scanner.nextLine();
				
				if ("quit".equals(message)) {
					break;
				}
				
				// 3. 보내기
				byte[] sndData = message.getBytes("UTF-8");
				DatagramPacket sndPacket = new DatagramPacket(
						sndData,sndData.length,new InetSocketAddress(SERVERIP,SERVERPORT));
				
				socket.send(sndPacket);
				
				DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
				socket.receive(rcvPacket); // blocking 된다
				
				byte[] rcvData = rcvPacket.getData();
				int offset = rcvPacket.getLength();
				message = new String(rcvData,0,offset,"UTF-8");
		
				
				System.out.println("[UDP Echo Server] received:"+message);
				
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
