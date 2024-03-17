package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private int clientNumber;

    public ClientHandler(Socket socket, int count) {
        this.socket = socket;
        this.clientNumber = count;
    }

    @Override
    public void run() {
        try {
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            System.out.println(" Socket " + socket + " client" + clientNumber);
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            outStream.writeBytes("HTTP/1.1 200 OK\r\n\r\n Hi from server to client\r\n");
            outStream.flush();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException
        }

    }

}
