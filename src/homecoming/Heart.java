package homecoming;

import java.awt.Point;

/*
 * Wrapper for heart objects. We need to store both position and speed.
 */
public class Heart {
	public final Point pos;
	public final int speed;

	public Heart(Point p, int speed) {
		pos = p;
		this.speed = speed;
	}
}
