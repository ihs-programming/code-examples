package connect4.graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import connect4.connectFour.Grid;

public class GamePanel extends JPanel {
    private static final int cellSize = 30;
    private static final int spacingSize = 10;
    private static final long serialVersionUID = -7797149062100634188L;
    private int rows;
    private int cols;
    private JFrame frame;
    private int[][] cells;
    
    /*
     * so that it's easier to tweak the colors
     * 
     * color[0]: medium accent color
     * color[1]: extremely dark accent color
     * color[2]: extremely light accent color
     * color[3]: player 1 color
     * color[4]: player 2 color
     * */
    private Color[] theme = {Color.decode("#f0f285"), Color.decode("#3f4023"), Color.decode("#feffe0"), Color.decode("#ff8080"), Color.decode("#402020")};
    public GamePanel(int rowsP, int colsP) {
        rows = rowsP;
        cols = colsP;
        Dimension dimension = new Dimension(
            cols * cellSize + (cols + 1) * spacingSize,
            (rows + 1) * (cellSize) + (cols + 2) * spacingSize
            );
        cells = new int[rows][cols];
        setPreferredSize(dimension);
        frame = new JFrame("Connect4");
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(false);
        
        
    }
    
    public void drawGrid(Grid grid) {
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                cells[row][col] = grid.getPlayerAt(row, col);
        repaint();
    }
    
    private void paintCell(Graphics2D g, int row, int col, int player) {
        Color fill = Color.WHITE;
        Color border = theme[2];
        if (player == 1) {
                fill = theme[3];
                border = theme[3];
        } else if (player == 2) {
                fill = theme[4];
                border = theme[4];
        }
        int baseX = col * (cellSize + spacingSize) + spacingSize;
        int baseY = (rows - 1 - row) * (cellSize + spacingSize) + spacingSize;
        g.setColor(fill);
        g.fillOval(baseX, baseY, cellSize, cellSize);
        g.setColor(border);
        g.drawOval(baseX, baseY, cellSize, cellSize);
        //paintText(g, "" + player, row, col, theme[2]);
    }

    private void paintText(Graphics2D g, String text, int row, int col, Color color) {
        int baseX = col * (cellSize + spacingSize) + spacingSize;
        int baseY = (rows - 1 - row) * (cellSize + spacingSize) + spacingSize;
        g.setFont(g.getFont().deriveFont(Font.PLAIN, 18));
        FontMetrics metrics = g.getFontMetrics();
        int offsetX = (cellSize - metrics.stringWidth(text)) / 2;
        int offsetY = (cellSize - metrics.getHeight()) / 2 + metrics.getAscent();
        g.setColor(color);
        g.drawString(text, baseX + offsetX, baseY + offsetY);
    }
    
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(theme[0]);
        g2d.clearRect(0, 0, cols * (cellSize + spacingSize) + spacingSize, rows * (cellSize + spacingSize) + spacingSize);
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                paintCell(g2d, row, col, cells[row][col]);
        for (int col = 0; col < cols; col++)
            paintText(g2d, "" + col, -1, col, theme[1]); // column numbers at the bottom
    }
    
    public int getCellSize() {
    	return cellSize;
    }
    
    public int getSpacingSize() {
    	return spacingSize;
    }
    
    public void setVisibility(boolean v) {
    	frame.setVisible(v);
    }
}
