package rps;
import java.util.*;
public class IPKizunaAI4 {
	final int totalGames = 1000;
	int numGames = 0;
	int numBots = 6;
	int[] history = {totalGames / 50, totalGames / 30, totalGames / 20, totalGames / 10, totalGames / 5, totalGames / 4, totalGames / 3, totalGames / 2, totalGames};
	char[] opp = new char[totalGames];
	char[] self = new char[totalGames];
	double[] results = new double[totalGames];
	int[] predictions = {0, 0, 0};
	double[] strengthAI = {0, 0, 0};
	int[][][] predAI = {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}},{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}};
	double[][][] statAI = {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}},{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}};
	double[][][] decAI = {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}},{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}};
	double[][][] dropAI = {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}},{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}};
	double[][][] randAI = {{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}},{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}}};
	public char play(){
		if(numGames != 0) {
			predict();
			int num = calc();
			if(num == 0)
				return 'r';
			if(num == 1)
				return 'p';
			return 's';
			}
		return 's';
	}
	/*
	 * Gets the result of a match with another bot, so you can adapt.
	 */
	public void predict() {
		int a0 = mAI();
		int b0 = AIm();
		int c0 = yAI();
		int d0 = AIy();
		int e0 = kAI();
		int f0 = AIk();
		int a1 = mAI1();
		int b1 = AIm1();
		int c1 = yAI1();
		int d1 = AIy1();
		int e1 = kAI1();
		int f1 = AIk1();
		int a2 = mAI2();
		int b2 = AIm2();
		int c2 = yAI2();
		int d2 = AIy2();
		int e2 = kAI2();
		int f2 = AIk2();
		int a3 = mAI3();
		int b3 = AIm3();
		int c3 = yAI3();
		int d3 = AIy3();
		int e3 = kAI3();
		int f3 = AIk3();
		int a4 = mAI4();
		int b4 = AIm4();
		int c4 = yAI4();
		int d4 = AIy4();
		int e4 = kAI4();
		int f4 = AIk4();
		int a5 = mAI5();
		int b5 = AIm5();
		int c5 = yAI5();
		int d5 = AIy5();
		int e5 = kAI5();
		int f5 = AIk5();
		int a6 = mAI6();
		int b6 = AIm6();
		int c6 = yAI6();
		int d6 = AIy6();
		int e6 = kAI6();
		int f6 = AIk6();
		int a7 = mAI7();
		int b7 = AIm7();
		int c7 = yAI7();
		int d7 = AIy7();
		int e7 = kAI7();
		int f7 = AIk7();
		int a8 = mAI8();
		int b8 = AIm8();
		int c8 = yAI8();
		int d8 = AIy8();
		int e8 = kAI8();
		int f8 = AIk8();
		//int n = randAI();
		for(int i = 0; i < 3; i++)
			predAI[0][0][i] = (a0 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[1][0][i] = (b0 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[2][0][i] = (c0 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[3][0][i] = (d0 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[4][0][i] = (e0 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[5][0][i] = (f0 - i + 3) % 3;
		
		for(int i = 0; i < 3; i++)
			predAI[0][1][i] = (a1 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[1][1][i] = (b1 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[2][1][i] = (c1 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[3][1][i] = (d1 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[4][1][i] = (e1 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[5][1][i] = (f1 - i + 3) % 3;

		for(int i = 0; i < 3; i++)
			predAI[0][2][i] = (a2 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[1][2][i] = (b2 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[2][2][i] = (c2 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[3][2][i] = (d2 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[4][2][i] = (e2 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[5][2][i] = (f2 - i + 3) % 3;
		
		for(int i = 0; i < 3; i++)
			predAI[0][3][i] = (a3 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[1][3][i] = (b3 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[2][3][i] = (c3 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[3][3][i] = (d3 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[4][3][i] = (e3 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[5][3][i] = (f3 - i + 3) % 3;
		
		for(int i = 0; i < 3; i++)
			predAI[0][4][i] = (a4 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[1][4][i] = (b4 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[2][4][i] = (c4 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[3][4][i] = (d4 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[4][4][i] = (e4 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[5][4][i] = (f4 - i + 3) % 3;
		
		for(int i = 0; i < 3; i++)
			predAI[0][5][i] = (a5 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[1][5][i] = (b5 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[2][5][i] = (c5 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[3][5][i] = (d5 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[4][5][i] = (e5 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[5][5][i] = (f5 - i + 3) % 3;

		for(int i = 0; i < 3; i++)
			predAI[0][6][i] = (a6 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[1][6][i] = (b6 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[2][6][i] = (c6 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[3][6][i] = (d6 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[4][6][i] = (e6 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[5][6][i] = (f6 - i + 3) % 3;
		
		for(int i = 0; i < 3; i++)
			predAI[0][7][i] = (a7 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[1][7][i] = (b7 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[2][7][i] = (c7 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[3][7][i] = (d7 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[4][7][i] = (e7 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[5][7][i] = (f7 - i + 3) % 3;
		
		for(int i = 0; i < 3; i++)
			predAI[0][8][i] = (a8 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[1][8][i] = (b8 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[2][8][i] = (c8 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[3][8][i] = (d8 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[4][8][i] = (e8 - i + 3) % 3;
		for(int i = 0; i < 3; i++)
			predAI[5][8][i] = (f8 - i + 3) % 3;
		//predAI[numBots][0][0] = n;
	}
	public void getResult(char yourMove, char theirMove){
		if(theirMove != 'r' && theirMove != 'p' && theirMove != 's')
			System.out.println("KizunaAI has detected that it's opponent is cheating.");
		updateStats(yourMove, theirMove);
	}
	public int randAI() {
		Random rand = new Random();
		return 'r';
	}
	public int kAI() {
		return maxRPS(pattCount(self, opp, 's', 0), pattCount(self, opp, 'r', 0), pattCount(self, opp, 'p', 0));
	}
	public int AIk() {
		return maxRPS(pattCount(opp, self, 'p', 0), pattCount(opp, self, 's', 0), pattCount(opp, self, 'r', 0));
	}
	public int yAI() {
		return maxRPS(charCount(opp, 's', 0), charCount(opp, 'r', 0), charCount(opp, 'p', 0));
	}
	public int AIy() {
		return maxRPS(charCount(self, 'p', 0), charCount(self, 's', 0), charCount(opp, 'r', 0));
	}
	public int mAI() {
		return maxRPS(markovChain(opp, self, 's', 0), markovChain(opp, self, 'r', 0), markovChain(opp, self, 'p', 0));
	}
	public int AIm() {
		return maxRPS(markovChain(self, opp, 'p', 0), markovChain(self, opp, 's', 0), markovChain(self, opp, 'r', 0));
	}
	public int kAI1() {
		return maxRPS(pattCount(self, opp, 's', 1), pattCount(self, opp, 'r', 1), pattCount(self, opp, 'p', 1));
	}
	public int AIk1() {
		return maxRPS(pattCount(opp, self, 'p', 1), pattCount(opp, self, 's', 1), pattCount(opp, self, 'r', 1));
	}
	public int yAI1() {
		return maxRPS(charCount(opp, 's', 1), charCount(opp, 'r', 1), charCount(opp, 'p', 1));
	}
	public int AIy1() {
		return maxRPS(charCount(self, 'p', 1), charCount(self, 's', 1), charCount(opp, 'r', 1));
	}
	public int mAI1() {
		return maxRPS(markovChain(opp, self, 's', 1), markovChain(opp, self, 'r', 1), markovChain(opp, self, 'p', 1));
	}
	public int AIm1() {
		return maxRPS(markovChain(self, opp, 'p', 1), markovChain(self, opp, 's', 1), markovChain(self, opp, 'r', 1));
	}
	public int kAI2() {
		return maxRPS(pattCount(self, opp, 's', 2), pattCount(self, opp, 'r', 2), pattCount(self, opp, 'p', 2));
	}
	public int AIk2() {
		return maxRPS(pattCount(opp, self, 'p', 2), pattCount(opp, self, 's', 2), pattCount(opp, self, 'r', 2));
	}
	public int yAI2() {
		return maxRPS(charCount(opp, 's', 2), charCount(opp, 'r', 2), charCount(opp, 'p', 2));
	}
	public int AIy2() {
		return maxRPS(charCount(self, 'p', 2), charCount(self, 's', 2), charCount(opp, 'r', 2));
	}
	public int mAI2() {
		return maxRPS(markovChain(opp, self, 's', 2), markovChain(opp, self, 'r', 2), markovChain(opp, self, 'p', 2));
	}
	public int AIm2() {
		return maxRPS(markovChain(self, opp, 'p', 2), markovChain(self, opp, 's', 2), markovChain(self, opp, 'r', 2));
	}
	public int kAI3() {
		return maxRPS(pattCount(self, opp, 's', 3), pattCount(self, opp, 'r', 3), pattCount(self, opp, 'p', 3));
	}
	public int AIk3() {
		return maxRPS(pattCount(opp, self, 'p', 3), pattCount(opp, self, 's', 3), pattCount(opp, self, 'r', 3));
	}
	public int yAI3() {
		return maxRPS(charCount(opp, 's', 3), charCount(opp, 'r', 3), charCount(opp, 'p', 3));
	}
	public int AIy3() {
		return maxRPS(charCount(self, 'p', 3), charCount(self, 's', 3), charCount(opp, 'r', 3));
	}
	public int mAI3() {
		return maxRPS(markovChain(opp, self, 's', 3), markovChain(opp, self, 'r', 3), markovChain(opp, self, 'p', 3));
	}
	public int AIm3() {
		return maxRPS(markovChain(self, opp, 'p', 3), markovChain(self, opp, 's', 3), markovChain(self, opp, 'r', 3));
	}
	public int kAI4() {
		return maxRPS(pattCount(self, opp, 's', 4), pattCount(self, opp, 'r', 4), pattCount(self, opp, 'p', 4));
	}
	public int AIk4() {
		return maxRPS(pattCount(opp, self, 'p', 4), pattCount(opp, self, 's', 4), pattCount(opp, self, 'r', 4));
	}
	public int yAI4() {
		return maxRPS(charCount(opp, 's', 4), charCount(opp, 'r', 4), charCount(opp, 'p', 4));
	}
	public int AIy4() {
		return maxRPS(charCount(self, 'p', 4), charCount(self, 's', 4), charCount(opp, 'r', 4));
	}
	public int mAI4() {
		return maxRPS(markovChain(opp, self, 's', 4), markovChain(opp, self, 'r', 4), markovChain(opp, self, 'p', 4));
	}
	public int AIm4() {
		return maxRPS(markovChain(self, opp, 'p', 4), markovChain(self, opp, 's', 4), markovChain(self, opp, 'r', 4));
	}
	public int kAI5() {
		return maxRPS(pattCount(self, opp, 's', 5), pattCount(self, opp, 'r', 5), pattCount(self, opp, 'p', 5));
	}
	public int AIk5() {
		return maxRPS(pattCount(opp, self, 'p', 5), pattCount(opp, self, 's', 5), pattCount(opp, self, 'r', 5));
	}
	public int yAI5() {
		return maxRPS(charCount(opp, 's', 5), charCount(opp, 'r', 5), charCount(opp, 'p', 5));
	}
	public int AIy5() {
		return maxRPS(charCount(self, 'p', 5), charCount(self, 's', 5), charCount(opp, 'r', 5));
	}
	public int mAI5() {
		return maxRPS(markovChain(opp, self, 's', 5), markovChain(opp, self, 'r', 5), markovChain(opp, self, 'p', 5));
	}
	public int AIm5() {
		return maxRPS(markovChain(self, opp, 'p', 5), markovChain(self, opp, 's', 5), markovChain(self, opp, 'r', 5));
	}
	public int kAI6() {
		return maxRPS(pattCount(self, opp, 's', 6), pattCount(self, opp, 'r', 6), pattCount(self, opp, 'p', 6));
	}
	public int AIk6() {
		return maxRPS(pattCount(opp, self, 'p', 6), pattCount(opp, self, 's', 6), pattCount(opp, self, 'r', 6));
	}
	public int yAI6() {
		return maxRPS(charCount(opp, 's', 6), charCount(opp, 'r', 6), charCount(opp, 'p', 6));
	}
	public int AIy6() {
		return maxRPS(charCount(self, 'p', 6), charCount(self, 's', 6), charCount(opp, 'r', 6));
	}
	public int mAI6() {
		return maxRPS(markovChain(opp, self, 's', 6), markovChain(opp, self, 'r', 6), markovChain(opp, self, 'p', 6));
	}
	public int AIm6() {
		return maxRPS(markovChain(self, opp, 'p', 6), markovChain(self, opp, 's', 6), markovChain(self, opp, 'r', 6));
	}
	public int kAI7() {
		return maxRPS(pattCount(self, opp, 's', 7), pattCount(self, opp, 'r', 7), pattCount(self, opp, 'p', 7));
	}
	public int AIk7() {
		return maxRPS(pattCount(opp, self, 'p', 7), pattCount(opp, self, 's', 7), pattCount(opp, self, 'r', 7));
	}
	public int yAI7() {
		return maxRPS(charCount(opp, 's', 7), charCount(opp, 'r', 7), charCount(opp, 'p', 7));
	}
	public int AIy7() {
		return maxRPS(charCount(self, 'p', 7), charCount(self, 's', 7), charCount(opp, 'r', 7));
	}
	public int mAI7() {
		return maxRPS(markovChain(opp, self, 's', 7), markovChain(opp, self, 'r', 7), markovChain(opp, self, 'p', 7));
	}
	public int AIm7() {
		return maxRPS(markovChain(self, opp, 'p', 7), markovChain(self, opp, 's', 7), markovChain(self, opp, 'r', 7));
	}
	public int kAI8() {
		return maxRPS(pattCount(self, opp, 's', 8), pattCount(self, opp, 'r', 8), pattCount(self, opp, 'p', 8));
	}
	public int AIk8() {
		return maxRPS(pattCount(opp, self, 'p', 8), pattCount(opp, self, 's', 8), pattCount(opp, self, 'r', 8));
	}
	public int yAI8() {
		return maxRPS(charCount(opp, 's', 8), charCount(opp, 'r', 8), charCount(opp, 'p', 8));
	}
	public int AIy8() {
		return maxRPS(charCount(self, 'p', 8), charCount(self, 's', 8), charCount(opp, 'r', 8));
	}
	public int mAI8() {
		return maxRPS(markovChain(opp, self, 's', 8), markovChain(opp, self, 'r', 8), markovChain(opp, self, 'p', 8));
	}
	public int AIm8() {
		return maxRPS(markovChain(self, opp, 'p', 8), markovChain(self, opp, 's', 8), markovChain(self, opp, 'r', 8));
	}
	public int markovChain(char[] a, char[] b,  char e, int longer) {
		int r = 0;
		
			for(int i = a.length - 2; i > a.length - history[longer] - 1 && i >= 0; i--) {
				if(a[i] == a[numGames - 1]) {
					if(a[i+1] == e) {
						int k = 0;
						while (k <= i && a[i - k] == a[numGames - k - 1]) {
							r++;
							k++;
						}
					}
				}
			}
		return r;
	}
	public int maxRPS(int r, int p, int s) {
		double a = r - s;
		double b = p - r;
		double c = s - p;
		if(a > b && a > c)
			return 0;
		if(b > a && b > c)
			return 1;
		return 2;
	}
	public int compareFour(double a, double b, double c) {
		if(a > b && a > c)
			return 0;
		if(b > a && b > c)
			return 1;
		return 2;
	}
	public int calc() {
		int num =  compareFour(strengthAI[0], strengthAI[1], strengthAI[2]);
			double max = statAI[0][0][0];
			int bot = 0;
			int self = 0;
			int iteration = 0;
			for(int i = 0; i < numBots; i++) {
				for(int k = 0; k < 9; k++) {
					for(int j = 0; j < 3; j++) {
						if(max < statAI[i][k][j]) {
							max = statAI[i][k][j];
							bot = i;
							self = k;
							iteration = j;
						}
					}
				}
			}
		predictions[0] = predAI[bot][self][iteration];
		if(num == 0) {
			return predAI[bot][self][iteration];
		}
		
			max = decAI[0][0][0];
			bot = 0;
			self = 0;
			iteration = 0;
			for(int i = 0; i < numBots; i++) {
				for(int k = 0; k < 9; k++) {
					for(int j = 0; j < 3; j++) {
						if(max < decAI[i][k][j]) {
							max = decAI[i][k][j];
							bot = i;
							self = k;
							iteration = j;
						}
					}
				}
			}
		predictions[1] = predAI[bot][self][iteration];
		if(num == 1) {
			return predAI[bot][self][iteration];
		}
		
			max = dropAI[0][0][0];
			bot = 0;
			self = 0;
			iteration = 0;
			for(int i = 0; i < numBots; i++) {
				for(int k = 0; k < 9; k++) {
					for(int j = 0; j < 3; j++) {
						if(max < dropAI[i][k][j]) {
							max = dropAI[i][k][j];
							bot = i;
							self = k;
							iteration = j;
						}
					}
				}
			}

		predictions[2] = predAI[bot][self][iteration];
			return predAI[bot][self][iteration];
	}
	public int pattCount(char[] a, char[] b, char e, int longer) {
		int r = 0;
		
			for(int i = a.length - 2; i > a.length - history[longer] - 1 && i >= 0; i--) {
				if(a[i] == a[numGames - 1] && b[i] == b[numGames - 1]) {
					if(b[i+1] == e) {
						int k = 0;
						while (k <= i && a[i - k] == a[numGames - k - 1] && b[i - k] == b[numGames - k - 1]) {
							r++;
							k++;
						}
					}
				}
			}
		return r;
	}
	public int charCount(char[] a, char b, int longer) {
		int num = 0;
			for(int i = a.length - 1; i > a.length - history[longer] && i >= 0; i--) {
				if(a[i]==b)
					num++;
			}
		return num;
	}
	public int result(int a, int b) {
		if(a!=b) {
			if((a == 0 && b == 2) ||(a == 1 && b == 0) ||(a == 2 && b == 1))
				return 1;
			else
				return -1;
		}
		return 0;
	}
	public int convert(char a) {
		if(a == 'r')
			return 0;
		if(a == 'p')
			return 1;
		return 2;
	}
	public void updateStats(char a, char b){
		numGames++;
		opp[numGames-1] = b;
		self[numGames-1] = a;
		int c = convert(a), d = convert(b);
		results[numGames-1] = result(c, d);
		int i = 0, k = 0, j = 0;
		for(i = 0; i < numBots; i++) {
			for(k = 0; k < 9; k++) {
				for(j = 0; j < 3; j++) {
					statAI[i][k][j] += result(predAI[i][k][j], d);
				}
			}
		}
		for(i = 0; i < numBots; i++) {
			for(k = 0; k < 9; k++) {
				for(j = 0; j < 3; j++) {
					decAI[i][k][j] += result(predAI[i][k][j], d);
					decAI[i][k][j] *= 0.9;
				}
			}
		}
		for(i = 0; i < numBots; i++) {
			for(k = 0; k < 9; k++) {
				for(j = 0; j < 3; j++) {
					if(result(predAI[i][k][j], d) == -1) {
						dropAI[i][k][j] = 0;
					} else {
						dropAI[i][k][j] += result(predAI[i][k][j], d);
					}
				}
			}
		}
		Random rand = new Random();
		for(i = 0; i < numBots; i++) {
			for(k = 0; k < 9; k++) {
				for(j = 0; j < 3; j++) {
					if(result(predAI[i][k][j], d) == -1 && rand.nextInt(1) == 0) {
						randAI[i][k][j] = 0;
					} else {
						randAI[i][k][j] += result(predAI[i][k][j], d);
					}
				}
			}
		}
		for(i = 0; i < 3; i++) {
			strengthAI[i] += result(predictions[i], d);
			strengthAI[i] *= 0.9;
		}
	}
}
