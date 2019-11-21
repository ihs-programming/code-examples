package physics;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameState extends KeyAdapter {
	static final int FLOOR = 400;
	static final int JUMP = 10;

	private Point player;

	public GameState() {
		player = new Point(0, 0);
	}

	public void update() {
		player.y++;

		if (player.y > FLOOR) {
			player.y = FLOOR;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();

		switch (c) {
		case 'w':
			player.y -= JUMP;
			break;
		case 'a':
			player.x--;
			break;
		case 's':
			player.y++;
			break;
		case 'd':
			player.x++;
			break;
		}
	}

	Point getPlayer() {
		return player;
	}

}
