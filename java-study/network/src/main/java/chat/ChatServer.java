package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import java.util.concurrent.ConcurrentHashMap;


public class ChatServer {
	
	
	
	public static ConcurrentHashMap<String,PrintWriter> hashMap = new ConcurrentHashMap<>();
	
	public static void main(String[] args) {
		

        int portNumber = 8090 ; // 포트 번호 설정

        try (ServerSocket serverSocket = new ServerSocket();) {
        	
            // 10은 대기열 크기!!
            // 0.0.0.0은 모든 인터페이스로 받음
            serverSocket.bind(new InetSocketAddress("0.0.0.0",portNumber),10);
            System.out.println("서버가 " + portNumber + " 포트에서 시작되었습니다.");


            while (true) {
                // 클라이언트의 연결 요청을 받기 위해 대기
            	
                Socket clientSocket = serverSocket.accept();
                // 소켓 타임아웃 시간 설정
//                clientSocket.setSoTimeout(1000);
                System.out.println("클라이언트가 연결되었습니다.");
                
                // 클라이언트와 통신할 스레드 생성
                Thread clientThread = new Thread(new ClientChatHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("포트 " + portNumber + "에서 서버를 시작하는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}

class ClientChatHandler implements Runnable {
	
	public static String decode(String msg) {
		byte[] decodedBytes = Base64.getDecoder().decode(msg);
        return new String(decodedBytes);
	}
	
	public static String encode(String msg) {
		byte[] encodedBytes = Base64.getEncoder().encode(msg.getBytes());
        return new String(encodedBytes);
	}
	
    private Socket clientSocket;
    private String nickName = "";

    public ClientChatHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
    	String nickName = null;
        try (
        	   BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         	   PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(),true);
        ) {

        	pw.println("ok");
        	
        	while(true) {
            	String data = br.readLine();
            	if(data == null || data.equals("message:"+encode("quit")) ) {
            		closeChat(clientSocket);
            		return ; 
            	}
            	
            	String[] tokens = data.split(":");
            	
            	if ("join".equals(tokens[0])) {
            		// 등록 성공 여부 -> 기존 닉네임과 겹치면 안됨, 공백 안됨
            		
            		
            		boolean retVal = doJoin(decode(tokens[1]),pw);
            		System.out.println(retVal);
            		if (!retVal) {
            			doPrivateMessage(pw,"기존에 이미 있는 닉네임 또는 부적절한 닉네임입니다");
            			return;
            		}
            	
            	}else if("message".equals(tokens[0])) {
            		doBroadCastMessage(decode(tokens[1]));
            	}else {
            		System.out.println("에러: 알 수 없는 요청("+data+")");
            		doPrivateMessage(pw,"알 수 없는 요청입니다");
            	}
  

        	
            
            
            }
        	
        	
        } catch (IOException e) {
        	// 비정상 종료
        	closeChat(clientSocket);
        	e.printStackTrace();
        }
    }
    
    private void doBroadCastMessage(String message) {
    	ChatServer.hashMap.values().stream()
    	.forEach(s->{
    		s.println(nickName+":"+message);
    	});
		
	}
    
    private void doPrivateMessage(PrintWriter pw, String message) {
    	pw.println(message);
    }

	// 채팅방에 입장하는 로직
    private boolean doJoin(String name, PrintWriter pw) {
    	if (name == null || name.equals("")) return false;
    	
    	
    	if (ChatServer.hashMap.containsKey(name)) {
    		System.out.println(ChatServer.hashMap.size());
    		return false;
    	}
    	ChatServer.hashMap.values().stream()
    	.forEach(s->{
    		s.println(name+"님이 입장하셨습니다");
    	});
    	this.nickName = name;
    	
    	ChatServer.hashMap.put(name, pw);
    	return true;
		
	}

	// 채팅을 닫는 함수
	private void closeChat(Socket clientSocket)  {
		
		if (clientSocket != null && clientSocket.isConnected())
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		if (nickName == null || nickName.equals("")) return;
		
        ChatServer.hashMap.remove(nickName);
        ChatServer.hashMap.values().stream()
    	.forEach(s->{
    		s.println(nickName+"님이 퇴장하셨습니다");
    	});
		
	}
}