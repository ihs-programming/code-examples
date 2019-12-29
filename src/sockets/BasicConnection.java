package sockets;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BasicConnection {
    static final int PORT = 8080;
    public static void main(String[] args) throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("IP Address: " + inetAddress.getHostAddress());
        System.out.println("Host Name: " + inetAddress.getHostName());

        System.out.println("What do you want to do");
        System.out.println("1. Host a server");
        System.out.println("2. Connect to a server");

        Scanner in = new Scanner(System.in);

        switch(in.nextInt()){
            case 1:
                hostServer();
                break;
            case 2:
                System.out.println("Give me an ip to connect to: ");
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
    }

    public static void connect(String ip) throws Exception{
        Socket s = new Socket(ip, PORT);

        System.out.println("Connected to " + s.getRemoteSocketAddress());
    }
}
