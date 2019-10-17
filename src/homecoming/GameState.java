package homecoming;

import java.awt.Point;
import java.util.ArrayList;

public class GameState {
	static final int FALLING_HEART_SIZE = 50;
	
	static final int SPEED = 5;
	static final int SPACING = 10;

	private ArrayList<Heart> hearts;
	private int counter;

	public GameState() {
		hearts = new ArrayList<>();
	}

	/*
	 * Update the game state
	 */
	public void update() {
		counter++;
		
		/*
		 * Every 25 ticks, create a new heart
		 */
		if(counter % 25 == 0) {			
			Point position = new Point((int) (500 * Math.random()), 0);
			int speed = (int) (4 * Math.random()) + 2;
			hearts.add(new Heart(position, speed));
		}

		for (Heart heart : hearts) {
			heart.pos.y += heart.speed;
		}

	}

	public ArrayList<Heart> getHearts() {
		return hearts;
	}

}
