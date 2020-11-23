package non_pr_1;

public class Delivery {

	public int recursion(int sum,int cur)
	{
		if (sum == 0)
			return 1;
		else if (sum < 0)
			return 0;
		else if (cur == 5)
			return recursion(sum - 5, 5) + recursion(sum - 3, 3) + recursion(sum - 1, 1);
		else if (cur == 3)
			return recursion(sum - 3, 3) + recursion(sum - 1, 1);
		else if (cur == 1)
			return recursion(sum - 1, 1);
		return 0;
	}
}
