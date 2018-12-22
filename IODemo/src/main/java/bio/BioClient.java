package bio;

import java.io.*;
import java.net.Socket;

/**
 */
public class BioClient {
    public static void main(String[] args){
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try{
//            socket.connect(new InetSocketAddress("localhost", 8000));
            socket = new Socket("127.0.0.1",8080);
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("hello server !!");
            out.flush();
            System.out.println(" send msg to server succeed");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String resp = in.readLine();
            System.out.println("receiver from server : " +resp);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
            if(out != null){
                out.close();
                out = null;
            }
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
        }
    }
}
