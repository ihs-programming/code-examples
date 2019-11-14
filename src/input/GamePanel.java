package input;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
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

		/*
		 * Get the current GameState. We'll be responsible for rendering the
		 * GameState in the rest of the method.
		 */
		GameState currState = Main.state;

		/*
		 * Make the color blue
		 */
		g.setColor(Color.BLUE);
		ArrayList<Point> balls = currState.getBalls();
		for (Point ball : balls) {
			/*
			 * Fill an oval at each ball. Recall that we represent each ball as
			 * a point. Note that the ball will be centered around (x + 5, y +
			 * 5) actually because the first two arguments are the coordinates
			 * for the top left corner.
			 */
			g.fillOval(ball.x, ball.y, 10, 10);
		}

	}
}
