package Server;

import threadpool.ThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server {



    private ServerSocket  serverSocket;
    private ThreadPool threadPool;

    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
        this.threadPool = new ThreadPool(2,10);
    }
    public void startServer(){
        int count=0;

        try{
            while (!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                count++;
                System.out.println("client is connected!!");
                threadPool.execute(new ClientHandler(socket, count));
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


