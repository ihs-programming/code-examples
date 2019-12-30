package connect4.contestants;

import connect4.connectFour.Grid;

public class Template implements Player {

    // hard-coded to start in the middle, and only go through the decision tree if it can't put it in the middle
    public int getMoveColumn(Grid g) {
        while(true){
            int i = (int) (g.getCols() * Math.random());

            if(!g.isColumnFull(i)) return i;
        }
    }


    public String getPlayerName() {
        return "Template";
    }
}