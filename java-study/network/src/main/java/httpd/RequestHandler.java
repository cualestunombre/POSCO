package httpd;

import java.io.IOException;
import java.io.*;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;


public class RequestHandler extends Thread {
    private Socket socket;
    private final String DOCUMENT_ROOT = "/Users/woo/Desktop/code/bit/java-study/chapters/src/main/java/httpd/webapp";

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // get IOStream
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
            String request = null;
          
            while(true) {
            	// 블록킹 방식으로 동작한다
				String line = br.readLine();
				
				// 클라이언트와 연결이 끊어졌을 때
				if(line == null) { // byte 스트림 기준 -1이 나온다
					break;
				}
				
				// SimpleHttpServer는 HTTP Header만 처리
				if("".equals(line)) {
					break;
				}
				
				if(request == null) {
					request = line;
					break;
				}
			}
            
            String[] tokens = request.split(" ");
         
        	if ("GET".equals(tokens[0])) {
        		responseStaticResource(outputStream,tokens[1],tokens[2]);
        	}else {
        		System.out.println("aaaa");
        		response400BadRequesst(outputStream,tokens[2]);
        	}

            // logging Remote Host IP Address & Port
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort());

            

        } catch (Exception ex) {
            consoleLog("error:" + ex);
        } finally {
            // clean-up
            try {
                if (socket != null && socket.isClosed() == false) {
                    socket.close();
                }

            } catch (IOException ex) {
                consoleLog("error:" + ex);
            }
        }
    }
    
    
    private void response400BadRequesst(OutputStream outputStream, String protocol) throws IOException {
    	File file = new File(DOCUMENT_ROOT + "/error/400.html");
    	String contentType = Files.probeContentType(file.toPath());

    	
    	
    	byte[] body = Files.readAllBytes(file.toPath());
    
    	outputStream.write(  (protocol + "400 BAD Request\r\n").getBytes( "UTF-8" ) );
		outputStream.write( ("Content-Type:" + contentType + "; Content-Length:"+ body.length + "; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\r\n".getBytes() );
    	outputStream.write(body);
		
		
	}

	private void responseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException {
    	// welcome file
    	if(url.equals("/")) {
    		url = "/index.html";
    	
    	}
    	File file = new File(DOCUMENT_ROOT + url);
    	String contentType = Files.probeContentType(file.toPath());

    	if(!file.exists()) {
    		response404Error(outputStream,protocol);
    		return;
    	}
    	
    	byte[] body = Files.readAllBytes(file.toPath());
    
    	outputStream.write(  (protocol + "200 OK\r\n").getBytes( "UTF-8" ) );
		outputStream.write( ("Content-Type:" + contentType + "; Content-Length:"+ body.length + "; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\r\n".getBytes() );
    	outputStream.write(body);
    	
    
    }

    private void response404Error(OutputStream outputStream,String protocol) throws IOException {
    	File file = new File(DOCUMENT_ROOT + "/error/404.html");
    	String contentType = Files.probeContentType(file.toPath());

    	
    	
    	byte[] body = Files.readAllBytes(file.toPath());
    
    	outputStream.write(  (protocol + "404 NOT FOUND\r\n").getBytes( "UTF-8" ) );
		outputStream.write( ("Content-Type:" + contentType + "; Content-Length:"+ body.length + "; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		outputStream.write( "\r\n".getBytes() );
    	outputStream.write(body);
		
	}

	public void consoleLog(String message) {
        System.out.println("[RequestHandler#" + getId() + "] " + message);
    }
}
