package tictactoe;

/**
 * The functions will be called in alternating order. First play() and then getResult(). 
 *
 */
public class Template {
	/**
	 * Returns one char representing rock, paper, or scissors
	 * @return 'r', 'p', or 's'
	 */
	public char play() {
		return 'r';
	}
	
	/**
	 * Gets the result of a match with another bot, so you can adapt.
	 */
	public void getResult(char yourMove, char theirMove) {
		
	}
}
