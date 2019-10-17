package homecoming;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	/*
	 * This known as a static constructor
	 */
	static {
		BufferedImage img = null;
		BufferedImage jumpScare = null;
		BufferedImage background = null;
		try {
			img = ImageIO.read(new File("download.png"));
			jumpScare = ImageIO.read(new File("jumpscare.png"));
			background = ImageIO.read(new File("download.jpg"));
		} catch (IOException ioe) {
			System.err.println("Fatal error: Failed to load images");
			System.exit(1);
		}
		backgroundImg = background;
		jumpScareImg = jumpScare;
		heartImg = makeColorTransparent(img, Color.WHITE);
	}

	static final Image heartImg;
	static final Image jumpScareImg;
	static final Image backgroundImg;
	static final Font font = new Font("Courier", Font.BOLD, 30);

	@Override
	public void paintComponent(Graphics g) {
		/*
		 * The getWidth() and getHeight() methods are inherited from JFrame
		 */
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.drawImage(Main.jumpScare? jumpScareImg: backgroundImg, 0, 0, getWidth(), getHeight(), null);

		/*
		 * Draw the greeting in the center of the screen
		 */
		g.setColor(Color.WHITE);
		g.setFont(font);
		drawCenteredString(g, String.format(Main.GREETING, Main.NAME), new Rectangle(0, 0, getWidth(), getHeight()),
				font);

		/*
		 * Draw all of the hearts. Note that because it is drawn later, these will show
		 * up on top of the text and background.
		 */
		for (Heart heart : Main.gameState.getHearts()) {
			g.drawImage(heartImg, heart.pos.x, heart.pos.y, GameState.FALLING_HEART_SIZE, GameState.FALLING_HEART_SIZE,
					null);
		}
	}

	// Copied from
	// https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
		// Get the FontMetrics
		FontMetrics metrics = g.getFontMetrics(font);
		// Determine the X coordinate for the text
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
		// Determine the Y coordinate for the text (note we add the ascent, as in java
		// 2d 0 is top of the screen)
		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
		// Set the font
		g.setFont(font);
		// Draw the String
		g.drawString(text, x, y);
	}

	// Copied from
	// https://www.javaworld.com/article/2074105/making-white-image-backgrounds-transparent-with-java-2d-groovy.html
	public static Image makeColorTransparent(final BufferedImage im, final Color color) {
		final ImageFilter filter = new RGBImageFilter() {
			// the color we are looking for (white)... Alpha bits are set to opaque
			public int markerRGB = color.getRGB() | 0xFFFFFFFF;

			public final int filterRGB(final int x, final int y, final int rgb) {
				if ((rgb | 0xFF000000) == markerRGB) {
					// Mark the alpha bits as zero - transparent
					return 0x00FFFFFF & rgb;
				} else {
					// nothing to do
					return rgb;
				}
			}
		};

		final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
		return Toolkit.getDefaultToolkit().createImage(ip);
	}
}
