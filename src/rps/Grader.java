package rps;

import java.lang.reflect.InvocationTargetException;

public class Grader {
	static final String NAME1 = "RegularTrifecto";
	static final String NAME2 = "IPKizunaAI4";

	public static void main(String args[])
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		Class<?> bot1 = Class.forName("rps." + NAME1);
		Class<?> bot2 = Class.forName("rps." + NAME2);

		Object a = bot1.getConstructor().newInstance();
		Object b = bot2.getConstructor().newInstance();

		int aWins = 0;
		int ties = 0;
		int bWins = 0;
		for (int i = 0; i < 1000; i++) {
			char aMove = (char) bot1.getMethod("play").invoke(a);
			char bMove = (char) bot2.getMethod("play").invoke(b);
			
			if("rpsRPS".indexOf(aMove) == -1) {
				System.out.println(NAME1 + " played invalid move " + aMove);
				return;
			}
			if("rpsRPS".indexOf(bMove) == -1) {
				System.out.println(NAME2 + " played invalid move " + bMove);
				return;
			}
			

			switch (score(aMove, bMove)) {
			case 1:
				aWins++;
				break;
			case 0:
				ties++;
				break;
			case -1:
				bWins++;
				break;
			}

			bot1.getMethod("getResult", char.class, char.class).invoke(a, aMove, bMove);
			bot2.getMethod("getResult", char.class, char.class).invoke(b, bMove, aMove);
		}

		if (aWins > bWins) System.out.println(NAME1 + " won!");
		else if (aWins == bWins) System.out.println("It was a tie O:");
		else System.out.println(NAME2 + " won!");

		System.out.println();

		System.out.printf("%s won %d times and ", NAME1, aWins);
		System.out.printf("%s won %d times", NAME2, bWins);
		System.out.println();

		System.out.printf("There were %d ties", ties);
	}

	public static int score(char a, char b) {
		if (a == 'r') {
			if (b == 'r') return 0;
			if (b == 's') return 1;
			return -1;
		} else if (a == 's') {
			if (b == 's') return 0;
			if (b == 'p') return 1;
			return -1;
		}

		if (b == 'p') return 0;
		if (b == 'r') return 1;
		return -1;
	}
}
