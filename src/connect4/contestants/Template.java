package connect4.contestants;

import connect4.connectFour.Grid;

public class Template implements Player {

    /**
     * You should write your logic here
     *
     * @param g  the game grid
     * @return a 0-indexed to drop a piece in
     */
    public int getMoveColumn(Grid g) {
        while(true){
            int i = (int) (g.getCols() * Math.random());

            if(!g.isColumnFull(i)) return i;
        }
    }


    /**
     * @return Your bot's (or your) name
     */
    public String getPlayerName() {
        return "Template";
    }
}