package Practice_13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Worker worker = new Worker();

		try {
			double salary = Double.parseDouble(new Scanner(System.in).nextLine());
			worker.addSalary(salary);
		} catch (MyPersonalException ex) {
			System.out.println("U r bad employer when salary of ur workers is <=0");
		} catch (NumberFormatException ex) {
			System.out.println("Something wrong. I can feel it");
		} finally {
			System.out.println(worker);
		}
		boolean er;
		System.out.println("Throw an error?");
		er=new Scanner(System.in).nextBoolean();
		if(er)
		{
			throw new MyRuntimeException();
		}

	}
}
