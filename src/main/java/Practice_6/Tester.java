package Practice_6;

import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Game game=new Game(in.nextInt());
		game.fillArray();
		game.printArray();
		System.out.println("\nThe answer is "+game.bot());
	}
}
