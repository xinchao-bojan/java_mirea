package Practice_27_28;

import Practice_17_18.Something;

import java.util.ArrayList;

public class Worker {

	public int sum(Data data)
	{
		int sum=0;
		ArrayList<Integer> arr= data.getNumbers();
		for(Integer number : arr)
		{
			sum+=number;
		}
		System.out.println("Sum is "+sum);
		return sum;
	}

	public String print(Data data)
	{
		StringBuilder sb=new StringBuilder();
		ArrayList<String> arr= data.getWords();
		String delimeter=data.getDelimeter();
		for (int i = 0; i < arr.size()-1; i++) {
			sb.append(arr.get(i)+delimeter);
			System.out.print(arr.get(i)+delimeter);
		}
		sb.append(arr.get((arr.size()-1)));
		System.out.print(arr.get((arr.size()-1)));
		return String.valueOf(sb);
	}
}
