package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Challenge {
    static final int PORT = 8080;
    static Random rand = new Random();
    static final int superSecureSecret = getSecureSecret(18);

    public static void main(String[] args) throws Exception{
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("Started a new server on "+ inetAddress.getHostAddress());
        ServerSocket ss = new ServerSocket(PORT);

        while(true){
            Socket s = ss.accept();

            new Thread(() -> process(s)).start();
        }
    }

    public static void process(Socket s) {
        try{
            Scanner sin = new Scanner(s.getInputStream());
            PrintStream sout = new PrintStream(s.getOutputStream());

            String input = sin.nextLine();
            String status = input.split(" ")[0];
            String name = input.split(" ")[1];

            switch (status) {
                case "TEST":
                    sout.println("PONG");
                    break;
                case "LOG":
                    String debug = sin.nextLine();

                    System.out.println("(" + s.getRemoteSocketAddress() + ") " + name + " > " + debug);

                    sout.println("Success");
                    break;
                case "CMD":
                    int code = Integer.parseInt(sin.nextLine());
                    String cmd = sin.nextLine();

                    if (code == superSecureSecret) {
                        System.out.println("(" + s.getRemoteSocketAddress() + ") " + name + " executing " + cmd);

                        Process proc = Runtime.getRuntime().exec(cmd);
                        BufferedReader stdInput = new BufferedReader(new
                                InputStreamReader(proc.getInputStream()));

                        String str = null;
                        while ((str = stdInput.readLine()) != null) {
                            System.out.println("Cmd > " + str);
                        }

                        stdInput.close();
                    }
                case "RAND":
                    int len = Integer.parseInt(sin.nextLine());
                    byte[] data = new byte[len];

                    rand.nextBytes(data);

                    sout.println(new String(data));

                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            s.close();
        }catch(IOException ioe){
            System.err.println("Failed to close socket");
        }
    }

    public static short getSecureSecret(int quantumBitLength){
        if(quantumBitLength == 0) return (short) rand.nextInt();
        return (short) (getSecureSecret(quantumBitLength - 1) * getSecureSecret(quantumBitLength - 1));
    }
}
