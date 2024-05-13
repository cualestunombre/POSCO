package networks;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

        public static void main(String[] args) {
            try(Socket socket = new Socket()){

                socket.connect(new InetSocketAddress("localhost",12345));
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr  );

                PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

                Scanner scanner = new Scanner(System.in);
                String input = null;
                while(!(input = scanner.nextLine()).equals("exit")){

                    pw.println(input);
                    String s =br.readLine();
                    System.out.println(s);

                }


            }catch(IOException e){

            }



        }

}

