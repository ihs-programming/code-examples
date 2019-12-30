package connect4.connectFour;

import java.util.ArrayList;

public class Board implements Grid
{
    private int rows;
    private int cols;
    private int nextPlayer;
    private int[][] playerAtPosition;
    private ArrayList<Integer> undoList;

    public Board(int rowsP, int colsP)
    {
        undoList = new ArrayList<Integer>();
        rows = rowsP;
        cols = colsP;
        nextPlayer = PLAYER1;
        playerAtPosition = new int[getRows()][getCols()];
    }

    public int getRows()
    {
        return rows;
    }

    public int getCols()
    {
        return cols;
    }


    @Override
    public int getPlayerAt(int row, int col)
    {
        return playerAtPosition[row][col];
    }

    @Override
    public boolean isColumnFull(int col)
    {
        return (playerAtPosition[playerAtPosition.length - 1][col] != PLAYEREMPTY);
    }

    public boolean makeMove(int col)
    {
        if (col < 0 || col >= getCols() || isColumnFull(col))
        {
            // Illegal column!
            return false;
        }
        
        for (int iRow = 0; iRow < playerAtPosition.length; iRow++)
        {
            if (playerAtPosition[iRow][col] == 0)
            {
                undoList.add(col);
                playerAtPosition[iRow][col] = nextPlayer;
                nextPlayer = 3 - nextPlayer;
                return true;
            }
        }

        // Column is full
        return false;
    }
    
    public void undo()
    {
        if (undoList.size() == 0)
            return;

        // Get most recently-played column
        int col = undoList.remove(undoList.size() - 1);
        
        // Get highest row played in that column, so we know which checker to remove
        for (int row = getRows() - 1; row >= 0; row--)
        {
            if (playerAtPosition[row][col] != PLAYEREMPTY)
            {
                playerAtPosition[row][col] = PLAYEREMPTY;
                nextPlayer = 3 - nextPlayer;
                return;
            }
        }
    }

    public int getNextPlayer()
    {
        return nextPlayer;
    }

    public int getWinningPlayer()
    {
    	GridUtilities utilities = new GridUtilities(this);
    	
        for (int iRow = 0; iRow < getRows(); iRow++)
        {
            for (int iCol = 0; iCol < getCols(); iCol++)
            {
                int player = playerAtPosition[iRow][iCol];
                if (player != 0)
                {
                    if (utilities.doesHorizontal4StartHere(iRow, iCol) ||
                    		utilities.doesVertical4StartHere(iRow, iCol) ||
                    		utilities.doesDiagonalLeft4StartHere(iRow, iCol) ||
                    		utilities.doesDiagonalRight4StartHere(iRow, iCol))
                    {
                        return player;
                    }
                }
            }
        }

        boolean allColumnsFull = true;
        for (int iCol = 0; iCol < getCols(); iCol++)
        {
            if (!isColumnFull(iCol))
            {
                allColumnsFull = false;
            }
        }
        if (allColumnsFull)
        {
            return Grid.DRAW;
        }

        return Grid.PLAYEREMPTY;
    }  
}
