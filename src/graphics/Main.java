package graphics;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Main looks exactly the same as in jframe. All of the changes are in Game.java
 */
public class Main {
	public static void main(String args[]) {
		JFrame frame = new JFrame("Frame Title");

		JPanel game = new Game();
		frame.add(game);

		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		frame.setVisible(true);
	}
}
