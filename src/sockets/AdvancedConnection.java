package sockets;

import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AdvancedConnection {
    static final int PORT = 8080;
    static Scanner in;
    public static void main(String[] args) throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP Address: " + inetAddress.getHostAddress());
        System.out.println("Host Name: " + inetAddress.getHostName());

        System.out.println("What do you want to do");
        System.out.println("1. Host a server");
        System.out.println("2. Connect to a server");

        in = new Scanner(System.in);

        switch(in.nextInt()){
            case 1:
                hostServer();
                break;
            case 2:
                System.out.print("Give me an ip to connect to: ");
                connect(in.next());
                break;
            default:
                System.out.println("Not an option :/");
                break;
        }
    }

    public static void hostServer() throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("Started a new server on "+ inetAddress.getHostAddress());
        ServerSocket ss = new ServerSocket(PORT);

        Socket s = ss.accept();

        System.out.println("Connection from " + s.getRemoteSocketAddress());
        System.out.println();

        PrintStream sout = new PrintStream(s.getOutputStream());

        // Clear the newline from the previous call to in.nextInt();
        in.nextLine();
        while(true){
            System.out.print("> ");
            String line = in.nextLine();

            sout.println(line);
        }

    }

    public static void connect(String ip) throws Exception{
        Socket s = new Socket(ip, PORT);

        System.out.println("Connected to " + s.getRemoteSocketAddress());
        System.out.println();

        Scanner sin = new Scanner(s.getInputStream());
        while(true){

            String line = sin.nextLine();

            System.out.println("Server > " + line);
        }
    }
}
