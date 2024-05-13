package chat;



import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;

public class ChatClient {
	
	 public static String encode(String msg) {
	    	byte[] encodedBytes = Base64.getEncoder().encode(msg.getBytes());
	    	return new String(encodedBytes);
	    	
	    }

        public static void main(String[] args) {
        	int portNumber = 8090 ; // 포트 번호 설정
        
            try(Socket socket = new Socket();
            	){

            	socket.connect(new InetSocketAddress("localhost",portNumber));
            	// 소켓 연결
            	
               
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
            	PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
              
            
                String ret = null;
                // 연결 여부를 확인하고 닉네임 입력
                ret = br.readLine();
                if (ret.equals("ok")) {
                	System.out.print("닉네임을 입력해주세요:");
                }else {
                	System.out.println("연결실패");
                	return ; 
                }
                
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                
                
               
                
                Thread chatReceiver = new Thread(new ClientChatReceiver(socket));
                Thread chatSender = new Thread(new ClientChatSender(socket));
                
                chatReceiver.start();
                pw.println("join:"+encode(input));
                chatSender.start();
                
               
                try {
                    chatReceiver.join();
                    chatSender.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                  
                }



            }catch(IOException e){
            	e.printStackTrace();
            }



        }

}





