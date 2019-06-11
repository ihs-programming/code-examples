package gameloops2;

import java.awt.Point;
import java.util.ArrayList;

public class GameState {
	static final int BALL_COUNT = 50;

	/*
	 * The "ceiling" of the simulation in pixels
	 */
	static final int CEILING = 500;

	/*
	 * Spacing in px for the balls
	 */
	static final int SPACING = 10;

	/*
	 * Speed in px for the balls
	 */
	static final int SPEED = 5;

	/*
	 * Represent each ball as a Point (x, y).
	 */
	private ArrayList<Point> balls;

	public GameState() {
		/*
		 * Initialize the GameState here.
		 */

		balls = new ArrayList<>();
		for (int i = 0; i < BALL_COUNT; i++) {
			balls.add(new Point(SPACING * i, SPACING * i));
		}

	}

	public void update() {
		for (Point ball : balls) {
			/*
			 * For each ball, increment the y position by one
			 */
			ball.y += SPEED;

			/*
			 * If the ball reaches the ceiling, reset the ball to the top
			 */
			if (ball.y >= CEILING) {
				ball.y -= CEILING;
			}
		}

	}

	/*
	 * Define any remaining helper methods you need below.
	 */

	public ArrayList<Point> getBalls() {
		return balls;
	}

}
