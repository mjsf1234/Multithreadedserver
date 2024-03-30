import Server.Server;
import Threading.ExtendThreadClass;
import Threading.ImplRunnableClass;
import thread.Processor;
import thread.RyanAndMonicaJob;

import thread.TestSync;
import threadpool.ThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Processor p = new Processor();
        p.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("press enter to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        p.shutdown();
    }
}