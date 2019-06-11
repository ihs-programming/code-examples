package gameloops2;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	static GameState state = new GameState();

	public static void main(String args[]) throws InterruptedException {
		JFrame frame = new JFrame("Frame Title");

		GamePanel game = new GamePanel();
		frame.add(game);

		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.setVisible(true);

		while (true) {
			/*
			 * Get the time at the start of the current game iteration in milliseconds.
			 */
			long startTime = System.currentTimeMillis();

			Main.state.update();
			frame.repaint();

			/*
			 * Calculate the elapsed time after updating the game and rendering.
			 */
			long elapsedTime = System.currentTimeMillis() - startTime;

			/*
			 * Subtract the elapsed time from the ideal time to keep a steady frame rate.
			 */
			Thread.sleep(Math.max(0, 1000 / 30 - elapsedTime));
		}
	}
}
