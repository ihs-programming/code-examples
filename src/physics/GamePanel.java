package physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	static final int PLAYER_SIZE = 20;
	/*
	 * Moved the update method into GameState.java
	 */

	@Override
	public void paintComponent(Graphics g) {
		/*
		 * Clear the screen
		 */
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		GameState currState = Main.state;

		/*
		 * Draw the player
		 */
		g.setColor(Color.BLUE);
		Point player = currState.getPlayer();
		g.fillOval(player.x, player.y - PLAYER_SIZE, PLAYER_SIZE, PLAYER_SIZE);

		/*
		 * Draw the floor
		 */
		g.setColor(Color.BLACK);
		g.fillRect(0, currState.FLOOR, 500, 500);
	}
}
