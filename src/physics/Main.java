package physics;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	static GameState state = new GameState();

	public static void main(String args[]) throws InterruptedException {
		JFrame frame = new JFrame("Frame Title");
		frame.addKeyListener(state);

		GamePanel game = new GamePanel();
		frame.add(game);

		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.setVisible(true);

		while (true) {
			long startTime = System.currentTimeMillis();

			Main.state.update();
			frame.repaint();

			long elapsedTime = System.currentTimeMillis() - startTime;

			Thread.sleep(Math.max(0, 1000 / 30 - elapsedTime));
		}
	}
}
