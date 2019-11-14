package input;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameState extends KeyAdapter {
	static final int BALL_COUNT = 50;
	static final int CEILING = 500;
	static final int SPACING = 10;
	static final int SPEED = 5;

	private ArrayList<Point> balls;

	public GameState() {
		balls = new ArrayList<>();
		for (int i = 0; i < BALL_COUNT; i++) {
			balls.add(new Point(SPACING * i, SPACING * i));
		}

	}

	public void update() {
		for (Point ball : balls) {
			ball.y += SPEED;

			if (ball.y >= CEILING) {
				ball.y -= CEILING;
			}
		}

	}

	public ArrayList<Point> getBalls() {
		return balls;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();

		System.out.println("You pressed " + c);
	}

}
