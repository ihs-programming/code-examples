package jframe;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	public static void main(String args[]) {
		/*
		 * JFrame is the actual window that popups.
		 */
		JFrame frame = new JFrame("Frame Title");

		/*
		 * The content that is actually displayed is represented through JPanels. In
		 * order to create our own animations, we'll need to have a custom JPanel. We
		 * use frame.add() to add a JPanel to the window.
		 */
		JPanel game = new Game();
		frame.add(game);

		/*
		 * Use frame.setPreferredSize to set the size of the window.
		 */
		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();

		/*
		 * Exits the program when we click the red exit button.
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * Don't allow users to change the size (ensures our graphics will always
		 * display properly).
		 */
		frame.setResizable(false);

		/*
		 * Makes the frame visible (it's invisible by default).
		 */
		frame.setVisible(true);
	}
}
