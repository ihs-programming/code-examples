/**
 * Basically InteractivePlayer but with graphics
 * somewhat breaks when you move or resize the window though
 */
package connect4.contestants;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import connect4.connectFour.Grid;
import connect4.graphics.GamePanel;

public class HumanPlayer implements Player
{
	private String name;
	private int col = -1;
	
	public HumanPlayer(GamePanel panel) {
		this.name = "bob";
		panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	Point p = MouseInfo.getPointerInfo().getLocation();
            	col = (p.x-panel.getSpacingSize()/2)/(panel.getCellSize() + panel.getSpacingSize());
            }

			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				
			}

			@Override
			public void mouseExited(MouseEvent arg0)
			{
			}

			@Override
			public void mousePressed(MouseEvent arg0)
			{
			}

			@Override
			public void mouseReleased(MouseEvent arg0)
			{
			}
        });
	}

	@Override
	public int getMoveColumn(Grid g)
	{
		return col;
	}

	@Override
	public String getPlayerName()
	{
		return name;
	}
	
	public void setCol(int c) {
		col = c;
	}
}
