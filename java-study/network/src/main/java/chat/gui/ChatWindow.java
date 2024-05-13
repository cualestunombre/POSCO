package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Base64;

import chat.ClientChatReceiver;
import chat.ClientChatSender;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;
	private String name;
	
	public static String encode(String msg) {
		 byte[] encodedBytes = Base64.getEncoder().encode(msg.getBytes());
	     return new String(encodedBytes);
	  
	}
	

	

	public ChatWindow(String name,Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
		this.name = name;
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
		
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (		e.getKeyCode() == 10) {
					sendMessage();
				}
			
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}

		});
		frame.setVisible(true);
		frame.pack();
		
		// IOStream 받아오기
		// ChatClientThread생성
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(socket.getOutputStream(),true);
			
			
	         Thread chatReceiver = new GuiReceiver();
	         chatReceiver.start();
	       

	         pw.println("join:"+encode(name));
	         
	         
	         
	         chatReceiver.join();
	      
	         
	         
		} catch (IOException | InterruptedException e) {
		
			e.printStackTrace();
		}
		
		
		
		
	}
	
	private void finish() {
		// quit 프로토콜 구현
		
		System.exit(0);
	}
	
	private void sendMessage() {
		String message = textField.getText();
		if (message.trim().equals("")) return;
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			pw.println("message:"+encode(message));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		
		textField.setText("");
		textField.requestFocus();
		
		
		
	
	}
	
	private class GuiReceiver extends Thread {
		

		
		@Override
		public void run() {
			String message = null;
	        try ( 
	               InputStream is = socket.getInputStream();
	        	   BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        	   OutputStream os = socket.getOutputStream();
	         	   PrintWriter pw = new PrintWriter(os,true);
	        ) {
	        	
	        
	        	while(true) {
	        		message = br.readLine();
//	        		if (message == null) {
//	        			System.exit(1);
//	        			return;
//	        		}
	        		updateTextArea(message);
	       
	        	}
	    
	          
	        } catch (IOException e) {
	        	e.printStackTrace();
	        	System.exit(1);
	        	return; 
	        }
	    }
		
		
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	
}
