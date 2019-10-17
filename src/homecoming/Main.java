package homecoming;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	static final String NAME = "Alex";
	
	/*
	 * This is a format string, passed to String.format(GREETING, NAME);
	 */
	static final String GREETING = "Homecoming %s?";
	
	static final GameState gameState = new GameState();
	public static void main(String args[]) throws InterruptedException {
		JFrame frame = new JFrame("Homecoming?");

		GamePanel game = new GamePanel();
		frame.add(game);

		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.setVisible(true);

		while (true) {
			long startTime = System.currentTimeMillis();

			/*
			 * Update the game state
			 */
			gameState.update();
			/*
			 * Repaint the frame. 
			 */
			frame.repaint();

			long elapsedTime = System.currentTimeMillis() - startTime;
			Thread.sleep(Math.max(0, 1000 / 30 - elapsedTime));
		}
	}
}
