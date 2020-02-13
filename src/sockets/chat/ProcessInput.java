package sockets.chat;

import java.util.Scanner;

// Implementing runnable allows us to run it in a separate thread
public class ProcessInput implements Runnable {
	Scanner sin;

	// Takes in a scanner from socket
	public ProcessInput(Scanner sin) {
		this.sin = sin;
	}

	@Override
	public void run() {
		try {
			// Task 2: Parse the custom header. ("I am s-chenrob")
			// String name = sin.nextLine(); ...

			String name = sin.nextLine();
			System.out.println(name);
			while (true) {
				// EDIT CODE BELOW THIS LINE

				String line = sin.nextLine();

				// Task 0: Print the line to the console.
				System.out.println(line);
				// Task 1: Print it with some styling, e.g. "> hello"

				// EDIT CODE ABOVE THIS LINE
			}
		} catch (Exception e) {
			// Task 5: Better error handling?
			e.printStackTrace();
		}

	}

}
