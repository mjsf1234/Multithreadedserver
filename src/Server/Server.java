package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket  serverSocket;

    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    public void startServer(){
        int count=0;

        try{
            while (!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                count++;
                System.out.println("client is connected!!");

                ClientHandler  clientHandler = new ClientHandler(socket,count);
                Thread thread = new Thread(clientHandler);
                thread.start();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeServerSocket(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


