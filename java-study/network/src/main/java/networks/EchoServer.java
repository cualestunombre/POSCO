package networks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) {


        int portNumber = 12345; // 포트 번호 설정

        try (ServerSocket serverSocket = new ServerSocket()) {
            // 10은 대기열 크기!!
            // 0.0.0.0은 모든 인터페이스로 받음
            serverSocket.bind(new InetSocketAddress("0.0.0.0",portNumber),10);
            System.out.println("서버가 " + portNumber + " 포트에서 시작되었습니다.");


            while (true) {
                // 클라이언트의 연결 요청을 받기 위해 대기
                Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트가 연결되었습니다.");

                // 클라이언트와 통신할 스레드 생성
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("포트 " + portNumber + "에서 서버를 시작하는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try (
               InputStream is = clientSocket.getInputStream();
        	   OutputStream os = clientSocket.getOutputStream();
        	   PrintWriter pw = new PrintWriter(os,true); // 자동 플러싱 옵션(하지 않으면 버퍼가 차야 내보낸다)
        	   BufferedReader br = new BufferedReader(new InputStreamReader(is));
        ) {
            while(true) {
            	String data = br.readLine();
            	System.out.println(data);
            	// 정상 종료 루틴	
            	if(data == null || data.equals("") ) {
            		System.out.println("클라이언트 종료");
            		break;
            	}
  
            	pw.println("[echo]"+data);

            
            }
            
          
        } catch (IOException e) {
        	// 비정상 종료
            System.err.println("클라이언트와의 통신 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
