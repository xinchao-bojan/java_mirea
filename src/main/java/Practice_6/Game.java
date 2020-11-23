package Practice_6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Game {
	private int array[][];
	private int answer[][];
	private int size;

	public Game(int size) {
		this.size = size;
		array = new int[size][size];
		answer = new int[size][size];
	}

	public void fillArray() {
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				array[i][j] = -100 + (int) (Math.random() * 1000);
			}
		answer[0][0] = array[0][0];
	}

	public void printArray() {
		System.out.println("Array of numbers");
		Stream.of(array).map(Arrays::toString).forEach(System.out::println);
	}

	public int bot() {

		for (int i = 1; i < size; i++) {
			answer[i][0] = array[i][0] + answer[i - 1][0];
		}

		for (int j = 1; j < size; j++) {
			answer[0][j] = array[0][j] + answer[0][j - 1];
		}

		for (int i = 1; i < size; i++) {
			for (int j = 1; j < size; j++) {
				answer[i][j] = Math.max(answer[i - 1][j], answer[i][j - 1]) + array[i][j];
			}
		}
		return answer[size - 1][size - 1];
	}
}