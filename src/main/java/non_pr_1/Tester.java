package non_pr_1;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Delivery obj=new Delivery();
		Scanner in=new Scanner(System.in);
		System.out.println(obj.recursion(in.nextInt(),5));
	}
}
