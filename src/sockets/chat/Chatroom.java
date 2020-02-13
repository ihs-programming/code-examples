package sockets.chat;

import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * README
 *
 * How to use:
 * 	Make sure you and your friend are on the same network, e.g. BSDSecure
 * 	Have one person host the server, another person connect to the server
 *
 * Ctrl + f for "Task" in both Chatroom.java and ProcessInput.java to make the chatroom actually work.
 * 	If you complete all 6 tasks (0 - 5), you get candy after break O:
 */
public class Chatroom {
	static final int PORT = 8080;
	static Scanner in;

	public static void main(String[] args) throws Exception {
		// See
		// https://docs.oracle.com/javase/7/docs/api/java/net/InetAddress.html
		// for more information about InetAddress
		InetAddress inetAddress = InetAddress.getLocalHost();
		System.out.println("IP Address: " + inetAddress.getHostAddress());
		System.out.println("Host Name: " + inetAddress.getHostName());

		System.out.println("What do you want to do");
		System.out.println("1. Host a server");
		System.out.println("2. Connect to a server");

		in = new Scanner(System.in);

		switch (in.nextInt()) {
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
		System.out.println("Started a new server on " + inetAddress.getHostAddress());
		ServerSocket ss = new ServerSocket(PORT);

		Socket s = ss.accept();

		// Task 4: Try making it so you can accept multiple clients
		process(s);

		/*
		 * while(true) { Socket s = ss.accept();
		 *
		 * // The "() -> process(s)" is a lambda expression new Thread(() ->
		 * process(s)).start(); }
		 */
	}

	public static void connect(String ip) throws Exception {
		Socket s = new Socket(ip, PORT);

		process(s);
	}

	public static void process(Socket s) throws Exception {
		System.out.println("Connected to " + s.getRemoteSocketAddress());
		System.out.println();

		Scanner sin = new Scanner(s.getInputStream());
		PrintStream sout = new PrintStream(s.getOutputStream());

		// Task 3: Prompt the user for a username to use
		// Send a header establishing who we are
		sout.println("I am " + System.getProperty("user.name"));

		// Multithreading magic allows us to both read and write at the same
		// time!
		new Thread(new ProcessInput(sin)).start();

		Scanner in = new Scanner(System.in);
		while (true) {
			String line = in.nextLine();
			sout.println(line);
		}
	}
}
