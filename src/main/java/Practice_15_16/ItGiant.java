package Practice_15_16;

class ItGiant {

	private final String[] action=new String[2];
	private final int[] way=new int[2];

	ItGiant(String phr0,String phr1,int s0,int s1)
	{
		action[0]=phr0;
		action[1]=phr1;
		way[0]=s0;
		way[1]=s1;
	}

	public int Job(int i)
	{
		System.out.println(action[i]);
		return way[i];
	}
}
