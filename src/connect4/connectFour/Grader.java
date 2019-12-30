package connect4.connectFour;

import connect4.contestants.HumanPlayer;
import connect4.contestants.Player;
import connect4.graphics.GamePanel;
import connect4.graphics.HomePanel;

import java.io.PrintStream;

public class Grader {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    
    private static Board board;
    private static GamePanel gamePanel = new GamePanel(ROWS, COLS);
    private static HomePanel homePanel = new HomePanel(gamePanel, false);
    private static PrintStream debugger = System.out;

    static final String NAME1 = "Template";
    static final String NAME2 = "Template";

    public static void main(String[] args) throws Exception
    {
        Class<?> bot1 = Class.forName("connect4.contestants." + NAME1);
        Class<?> bot2 = Class.forName("connect4.contestants." + NAME2);

        Object a = bot1.getConstructor().newInstance();
        Object b = bot2.getConstructor().newInstance();

        board = new Board(ROWS, COLS);
        gamePanel.drawGrid(board);

        Thread.sleep(1000);

        playGame((Player) a, (Player) b);
    }
    
    public static void playGame(Player player1, Player player2) throws InterruptedException
    {
        String name1 = player1.getPlayerName();
        String name2 = player2.getPlayerName();

        if(name1.equals(name2)) name2 += "2";

        int winningPlayer = 0;
        while (winningPlayer == 0)
        {
            Thread.sleep(500);
        	int move = getMove(player1);
            debugger.println(name1 + " dropped in " + move);
            
            if(!board.makeMove(move)){
                System.err.println(name1 + " made an illegal move");
                return;
            }
            gamePanel.drawGrid(board);
            winningPlayer = board.getWinningPlayer();
            if (winningPlayer == 0) {
                Thread.sleep(500);
            	move = getMove(player2);
                if(!board.makeMove(move)){
                    System.err.println(name2 + " made an illegal move");
                    return;
                }
                debugger.println(name2 + " dropped in " + move);
                gamePanel.drawGrid(board);
                winningPlayer = board.getWinningPlayer();
            }
        }

        if (winningPlayer == -1)
        {
            System.out.println("Game over. It was a draw.");
            debugger.println("Game over. It was a draw.");
            return;
        }
        String winningPlayerName = 
                (winningPlayer == 1) ? name1: name2;

        debugger.println("Game over.  Player " + winningPlayer + ": " + winningPlayerName + " won.");
        debugger.close();
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
