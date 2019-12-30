package connect4.contestants;

import connect4.connectFour.Grid;

public interface Player {
    /**
     * Gets the column index for the player's chosen move in the given grid.  Does not actually move.
     * 
     * Precondition: g represents a valid game in progress, so player has at least one valid move.
     *
     * Postcondition: The state of g is unchanged.  You inspect the entire grid with the
     * getPlayerAt method of g, and make a copy of that data to help "look ahead" when choosing your move.
     * 
     * You can figure out your own player number just by counting the number of nonempty cells in g.
     * If even, you are player 1.
     * 
     * @param g  the game grid
     * @return   the column index for this player's chosen move
     */
    public int getMoveColumn(Grid g);
    
    /**
     * Returns the name of the player.
     * 
     * @return  player's name
     */
    public String getPlayerName();
}
