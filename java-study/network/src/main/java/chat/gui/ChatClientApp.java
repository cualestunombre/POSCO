package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ClientChatReceiver;
import chat.ClientChatSender;



public class ChatClientApp {
	


	public static void main(String[] args) {
		
		String name = null;
		int portNumber = 8090;
		
		try(Scanner scanner = new Scanner(System.in);){
			while( true ) {
				
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();
				
				if (!name.trim().equals("")) {
					break;
				}
				
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		// 소켓 연결
		try(	Socket socket = new Socket();
            	){

            	socket.connect(new InetSocketAddress("localhost",portNumber));
            	
            	
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
            
              
            
                String ret = null;
                // 연결 여부를 확인하고 닉네임 입력
                ret = br.readLine();
                		
                // 연결 성공 여부 확인
                if (!ret.equals("ok")) {
                	System.out.println("연결실패");
                	return;
                }
                
           
               
                
            	new ChatWindow(name,socket).show();
                
             
            



            }catch(IOException e){
            	e.printStackTrace();
            }



        

		



	}

}
