package gameloops;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	/*
	 * Throw appropriate exceptions (from Thread.sleep)
	 */
	public static void main(String args[]) throws InterruptedException {
		JFrame frame = new JFrame("Frame Title");

		/*
		 * Changed variable type to Game so we can access game.update().
		 */
		Game game = new Game();
		frame.add(game);

		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.setVisible(true);

		while (true) {
			/*
			 * Update the game by calling our update method.
			 */
			game.update();
			/*
			 * After we've updated the game, we'll need to repaint the frame. We do this by
			 * calling frame.repaint().
			 */
			frame.repaint();

			/*
			 * Thread.sleep takes in the amount of time to wait (in milliseconds). We write
			 * it in 1000 / <fps> to make our code more readable.
			 */
			Thread.sleep(1000 / 30);
		}
	}
}
