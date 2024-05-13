package networks;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
	private static final int PORT = 8040;
	private static final int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		
		try(DatagramSocket socket = new DatagramSocket(PORT)){
			
			// 데이터 수신
			while(true) {
				DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
				socket.receive(rcvPacket); // blocking 된다
				
				byte[] rcvData = rcvPacket.getData();
				int offset = rcvPacket.getLength();
				String message = new String(rcvData,0,offset,"UTF-8");
		
				
				System.out.println("[UDP Echo Server] received:"+message);
				
				// 데이터 송신
				byte[] sndData = message.getBytes("UTF-8");
				DatagramPacket sndPacket = new DatagramPacket(sndData,sndData.length,rcvPacket.getAddress(),rcvPacket.getPort());
				socket.send(sndPacket);
			}
			
			
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
