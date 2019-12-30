package connect4.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class HomePanel extends JPanel
{
	private JFrame frame;
	private JCheckBox isFirst;
	private JButton startButton;
	
	public HomePanel(GamePanel gamePanel, boolean prompt) {
		if(!prompt){
			gamePanel.setVisibility(true);
			frame = null;
			return;
		}
		
		startButton = new JButton("START");
		isFirst = new JCheckBox("go first");
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				gamePanel.setVisibility(true);				
				frame.setVisible(false);
				frame = null;
			}
		});
		
		frame = new JFrame("Connect4");
        
		this.add(isFirst);
		this.add(startButton);
		
		frame.add(this);
        
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}

	public HomePanel(GamePanel g){
		this(g, true);
	}
	
	public boolean isDead() {
		return frame==null;
	}
	
	public boolean getIsFirst() {
		return isFirst.isSelected();
	}
}
