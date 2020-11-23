package Practice_21_22;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Where u wanna work?\n"+
				"1|	on server\n"+
				"2|	in file");
		int a=in.nextInt();
		if(a==1)
		{
			Server exec=new Server();
			exec.execApp();
		} else if(a==2)
		{
			LocalFile exec=new LocalFile();
			exec.execApp();
		} else
		{
			System.out.println("Are u mad? I don't wanna play with u. BB");
		}
	}
}
