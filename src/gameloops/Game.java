package gameloops;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Game extends JPanel {

	/*
	 * The offset for the image that we're drawing.
	 */
	int offset = 0;

	void update() {
		/*
		 * On update, increment offset by one
		 */
		offset++;
	}

	@Override
	public void paintComponent(Graphics g) {
		Color[] colors = new Color[] { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK };

		final int SIZE = 10;
		for (int i = 0; i < colors.length; i++) {
			g.setColor(colors[i]);

			/*
			 * The one thing that changed is we draw the shape with an x offset of <offset>
			 */
			g.fillRect(SIZE * i + offset, SIZE * i, 2 * SIZE * colors.length - 2 * SIZE * i,
					2 * SIZE * colors.length - 2 * SIZE * i);
		}
	}
}
