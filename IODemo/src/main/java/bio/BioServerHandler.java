package bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 */
public class BioServerHandler implements Runnable {

    private Socket socket;
    public BioServerHandler(Socket socket) {
        this.socket = socket;
    }
    public void run(){
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(),true);
            String body = null;
            while(true){
                //通过BufferedReader读取一行,如果已经读到了输入流的尾部,则返回値为null
                body = in.readLine();
                if(body == null){
                    break;
                }
                System.out.print("The bio server receive :"+body);
                //通过PrintWriter的println函数发送数据给客户端
                out.println(new Date());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(in!=null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(out != null){
                out.close();
                out=null;
            }
           if(this.socket != null){
               try {
                   this.socket.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
               this.socket = null;
           }
        }
    }
}
