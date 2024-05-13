package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientChatReceiver implements Runnable {
    private Socket clientSocket;

    public ClientChatReceiver(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
    	String message = null;
        try ( 
               InputStream is = clientSocket.getInputStream();
        	   BufferedReader br = new BufferedReader(new InputStreamReader(is));
        	   OutputStream os = clientSocket.getOutputStream();
         	   PrintWriter pw = new PrintWriter(os,true);
        ) {
    
        	while(true) {
        		message = br.readLine();
        		if (message == null) {
        			System.exit(1);
        			return;
        		}
        		System.out.println(message);
       
        	}
    
          
        } catch (IOException e) {
        	e.printStackTrace();
        	System.exit(1);
        	return; 
        }
    }

}