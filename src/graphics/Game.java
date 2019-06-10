package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*
 * This class is responsible for all of our game's graphics.
 */
public class Game extends JPanel {
	/*
	 * The paintComponent method of the JPanel class is responsible for rendering
	 * it. We can override it to have our own custom rendering.
	 */
	@Override
	public void paintComponent(Graphics g) {
		Color[] colors = new Color[] { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK };

		/*
		 * The size of the rectangles
		 */
		final int SIZE = 10;
		for (int i = 0; i < colors.length; i++) {
			/*
			 * Set the color of the pen
			 */
			g.setColor(colors[i]);
			/*
			 * Fill a rectangle. The arguments go (x, y, width, height)
			 * 
			 * The top left corner is at (SIZE * i, SIZE * i). The width and height are both
			 * 100 - 2 * SIZE * i.
			 */
			g.fillRect(SIZE * i, SIZE * i, 2 * SIZE * colors.length - 2 * SIZE * i,
					2 * SIZE * colors.length - 2 * SIZE * i);
		}
		/*
		 * More documentation for the Graphics class can be found at
		 * https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html.
		 */
	}
}
