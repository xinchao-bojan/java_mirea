package Practice_2;

import java.util.Scanner;

public class DogKennel {
	Dog[] doggy = new Dog[5];
	public static int count=0;
	private int i=count;
	public void addDogs(Dog sobaka)
	{
		doggy[i]=sobaka;
		System.out.println(doggy[i].toString());
		i=count++;
	}

	public static void main(String[] args) {
		DogKennel kennel = new DogKennel();
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			String name = in.next();
			int age = in.nextInt();
			Dog sobaka = new Dog(name, age);
			kennel.addDogs(sobaka);

		}
	}
}

