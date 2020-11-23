package Practice_13;

public class Worker {

	private double salary;

	public void addSalary(double salary) throws MyPersonalException
	{
		if(salary<=0)
			throw new MyPersonalException();
		this.salary+=salary;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Worker{" +
				"salary=" + salary +
				'}';
	}
}
