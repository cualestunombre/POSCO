package networks;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultiplexingServer {

    public static void main(String[] args) {
        int portNumber = 12346;

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress("0.0.0.0", portNumber));
            serverSocketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("서버가 " + portNumber + " 포트에서 시작되었습니다.");

            while (true) {
                selector.select(); // 이벤트 발생 대기

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectedKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isAcceptable()) {
                        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                        SocketChannel clientChannel = serverChannel.accept();
                        clientChannel.configureBlocking(false);
                        clientChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("클라이언트가 연결되었습니다.");
                    } else if (key.isReadable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        int readBytes = clientChannel.read(buffer);

                        if (readBytes == -1) {
                            System.out.println("클라이언트가 종료되었습니다.");
                            clientChannel.close();
                            continue;
                        }

                        buffer.flip();
                        byte[] data = new byte[buffer.remaining()];
                        buffer.get(data);
                        String receivedData = new String(data, "UTF-8");
                        System.out.println("[Server] Received: " + receivedData);

                        // 클라이언트에게 다시 전송
                        clientChannel.register(selector, SelectionKey.OP_WRITE, receivedData);
                    } else if (key.isWritable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        String sendData = (String) key.attachment();

                        ByteBuffer buffer = ByteBuffer.wrap(sendData.getBytes("UTF-8"));
                        clientChannel.write(buffer);

                        System.out.println("[Server] Sent: " + sendData);

                        key.interestOps(SelectionKey.OP_READ);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("포트 " + portNumber + "에서 서버를 시작하는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
