package sockets;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChallengeClient {
    static final String USERNAME = System.getProperty("user.name");
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.print("Give me an ip to connect to: ");

        Socket s = new Socket(in.next(), Challenge.PORT);

        System.out.println("Connected to " + s.getRemoteSocketAddress());
        System.out.println();

        Scanner sin = new Scanner(s.getInputStream());
        PrintStream sout = new PrintStream(s.getOutputStream());

        // Your code below

        sout.println("TEST " + USERNAME);

        // Your code above

        while(sin.hasNextLine()) {
            String line = sin.nextLine();

            System.out.println("Server> " + line);
        }
    }
}
