package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;

public class ClientChatSender implements Runnable {
	private Socket clientSocket;

    public ClientChatSender(Socket socket) {
        this.clientSocket = socket;
    }
    
    public static String encode(String msg) {
    	byte[] encodedBytes = Base64.getEncoder().encode(msg.getBytes());
    	return new String(encodedBytes);
    	
    }

    public void run() {
        try (
               InputStream is = clientSocket.getInputStream();
        	   BufferedReader br = new BufferedReader(new InputStreamReader(is));
        	   OutputStream os = clientSocket.getOutputStream();
         	   PrintWriter pw = new PrintWriter(os,true);
        ) {
        	
        	Scanner scanner = new Scanner(System.in);
        	String input = null;
            while(true) {
            	input = scanner.nextLine();
            	if (input == null || input.trim().equals("")) {
            		continue;
            	}
            	
            	pw.println("message:" +encode(input));
       
            }      
        } catch (IOException e) {
        	e.printStackTrace();
        	return;
        
        }
    }
}
