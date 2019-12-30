/**
 * Basically HumanPlayer but without graphics
 */
package connect4.contestants;

import java.util.Scanner;

import connect4.connectFour.Grid;

public class InteractivePlayer implements Player
{
    private Scanner console;
    private String playerName;
    
    public InteractivePlayer()
    {
        console = new Scanner(System.in);
        System.out.println("What's your name? (or not) ");
        playerName = console.nextLine();
    }
    
    @Override
    public int getMoveColumn(Grid g)
    {
        int col = -1;
        while (col == -1)
        {
            System.out.println(playerName + ": Which column would you like to play?");
            String colStr = console.nextLine();
            try
            {
                col = Integer.parseInt(colStr);
            }
            catch (NumberFormatException e)
            {
                System.out.println(playerName + ", vat is a \"" + colStr + "\"?");
                continue;
            }
            
            if (col < 0 || col >= g.getCols())
            {
                System.out.println(playerName + ": Please enter a column number between 0 and " + (g.getCols() - 1));
                col = -1;
            }
            else if (g.isColumnFull(col))
            {
                System.out.println(playerName + ", that column is full. -_-");
                col = -1;
            }
        }
        
        return col;
    }

    @Override
    public String getPlayerName()
    {
        return playerName;
    }

}
