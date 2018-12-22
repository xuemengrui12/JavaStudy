package bio2;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 */
public class Bio2Server {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if(args != null && args.length >0 ){
            try{
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }

        ServerSocket server = null;
        try{
            server = new ServerSocket(port);
            System.out.println("the bio2 server is start in port :"+port);
            Socket socket = null;
            Bio2ServerHandlerExcuterPool pool = new Bio2ServerHandlerExcuterPool(10,10);
            while (true){
                socket = server.accept();
                pool.execute(new Bio2ServerHandler(socket));
            }
        }finally {
            if(server!=null){
                System.out.println("the bio2 server close");
                server.close();
                server = null;
            }
        }
    }
}
