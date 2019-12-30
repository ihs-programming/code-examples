package connect4.connectFour;

import connect4.contestants.*;
import connect4.graphics.*;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    
    private static Board board;
    private static GamePanel gamePanel = new GamePanel(ROWS, COLS);
    private static HomePanel homePanel = new HomePanel(gamePanel);
    private static PrintStream out;

    public static void main(String[] args) throws InterruptedException, FileNotFoundException
    {
    	while(!homePanel.isDead()) {
    		Thread.sleep(50);
    	}
    	boolean isFirst = homePanel.getIsFirst();
    	
        board = new Board(ROWS, COLS);
        gamePanel.drawGrid(board);
        out = System.out;
        
        if(isFirst) {
        	playGame(new HumanPlayer(gamePanel), new Template());
        } else {
        	playGame(new Template(), new HumanPlayer(gamePanel));
        }
    }
    
    public static void playGame(Player player1, Player player2) throws InterruptedException
    {
        int winningPlayer = 0;
        while (winningPlayer == 0)
        {
        	int move = getMove(player1);
            out.println(player1.getPlayerName() + " dropped in " + move);
            
            board.makeMove(move);
            gamePanel.drawGrid(board);
            winningPlayer = board.getWinningPlayer();
            if (winningPlayer == 0) {
            	move = getMove(player2);
                board.makeMove(move);
                out.println(player2.getPlayerName() + " dropped in " + move);
                gamePanel.drawGrid(board);
                winningPlayer = board.getWinningPlayer();
            }
        }

        if (winningPlayer == -1)
        {
            System.out.println("Game over. It was a draw.");
            out.println("Game over. It was a draw.");
            return;
        }
        String winningPlayerName = 
                (winningPlayer == 1) ? player1.getPlayerName() : player2.getPlayerName();
        System.out.println("Game over.  Player " + winningPlayer + ": " + winningPlayerName + " won.");
        out.println("Game over.  Player " + winningPlayer + ": " + winningPlayerName + " won.");
        out.close();
    }
    
    public static int getMove(Player player) throws InterruptedException {
    	int move;
    	if(player instanceof HumanPlayer) {
        	move = player.getMoveColumn(board);
        	while(move == -1) {
        		move = player.getMoveColumn(board);
        		Thread.sleep(20);
        	}
            ((HumanPlayer) player).setCol(-1);
    	} else {
    		move = player.getMoveColumn(board);
    	}
    	return move;
    }

    public static GamePanel getGamePanel()
    {
        return gamePanel;
    }
}
