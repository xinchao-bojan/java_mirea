package Practice_15_16;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<ItGiant> company=new ArrayList<>(5);
		company.add(new ItGiant("create_project","add_library",1,4));
		company.add(new ItGiant("test","drop_db",2,3));
		company.add(new ItGiant("drop_db","add_library",3,4));
		company.add(new ItGiant("restart","deploy",2,4));
		company.add(new ItGiant("deploy","restart",0,2));
		Scanner in=new Scanner(System.in);
		int i=in.nextInt();
		int current =0;
		while (i!=-1)
		{
			current=company.get(current).Job(i);
			i=in.nextInt();
		}
	}
}
