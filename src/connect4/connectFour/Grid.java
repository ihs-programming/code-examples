package connect4.connectFour;

/**
 * Represents the grid of a Connect Four game.
 * Note: The first position in a column has row index 0.
 * For example, consider a game that starts with these four moves:
 * Player 1 moves in column 2, which drops to row 0
 * Player 2 moves in column 3, which drops to row 0
 * Player 1 moves in column 3, which drops to row 1
 * Player 2 moves in column 3, which drops to row 2
 * The grid would look like this:
 * |   |   |   |   |   |   |   |
 * |   |   |   |   |   |   |   |
 * |   |   |   |   |   |   |   |
 * |   |   |   | 2 |   |   |   |
 * |   |   |   | 1 |   |   |   |
 * |   |   | 1 | 2 |   |   |   |
 *  --- --- --- --- --- --- ---
 *   0   1   2   3   4   5   6 
 *   
 */
public interface Grid
{
    public static final int PLAYEREMPTY = 0; // player number for empty cell
    public static final int PLAYER1 = 1; // player number for first player
    public static final int PLAYER2 = 2; // player number for second player
    public static final int DRAW = -1; // returned by getWinningPlayer() if the
                                       // game ended in a draw

    // Directions, used in getLengthAndSpaces
    public static final int RIGHT = 0;
    public static final int UP = 1;
    public static final int UPLEFT = 2;
    public static final int UPRIGHT = 3;

    /**
     * Gets the player number (1 or 2) at the given row and column, or 0 if that
     * cell is empty.
     * 
     * @param row
     *            the row index (0 is bottom)
     * @param col
     *            the column index (0 is left)
     * @return the player number (1 or 2) at the given row and column, or 0 if
     *         empty
     */
    public int getPlayerAt(int row, int col);

    /**
     * Checks whether the given column is full.
     * 
     * @param col
     *            the column index
     * @return true if the column is full, otherwise false
     */
    public boolean isColumnFull(int col);

    /**
     * These return the number of rows & columns on the board
     */
    public int getRows();
    public int getCols();

    /**
     * Returns the player number whose move is next
     */
    public int getNextPlayer();

    /**
     * If this Grid is a finished game, this returns the winner (PLAYER1,
     * PLAYER2, or DRAW)
     * 
     * If this Grid is not yet a finished game, this returns PLAYEREMPTY
     */
    public int getWinningPlayer();

    public void undo();
    
    public Grid clone();
}
