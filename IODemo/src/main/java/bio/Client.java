package bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException

    {
        Socket socket = null;
        PrintWriter writer = null;
        BufferedReader br = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 8000));
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("hello !!");
            writer.flush();
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("receiver from server : " + br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流、socket
            if (writer != null)
                writer.close();
            if (br != null)
                br.close();
            if (socket != null)
                socket.close();

        }
    }
}