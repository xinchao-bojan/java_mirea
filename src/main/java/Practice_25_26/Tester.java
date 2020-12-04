package Practice_25_26;

import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		MyHashMap<Integer,String> myHashMap=new MyHashMap<>(10);
		myHashMap.add(2,"Ivan");
		myHashMap.add(1,"Max");
		myHashMap.add(3,"Kostya");
		myHashMap.add(4,"Maksudbek");
		myHashMap.add(5,"Stas");
		myHashMap.add(6,"Tarakan");
		System.out.println("Who will clean the floor next?"+"\n"+myHashMap.get(2));
		myHashMap.remove(2);
		System.out.println("\nPeople who didnt clean the floor yet:");
		for(String value:myHashMap)
		{
			System.out.println(value);
		}
		System.out.println("==========");
		for(String value:myHashMap)
		{
			System.out.println(value);
		}


	}

}
