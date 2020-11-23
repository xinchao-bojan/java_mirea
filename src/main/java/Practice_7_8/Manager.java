package Practice_7_8;

public class Manager implements EmployeePosition {

	@Override
	public String getJobTitle() {
		return "Manager";
	}

	@Override
	public double calcSalary(double baseSalary) {
		return baseSalary + (int)(0.05*(115000+Math.random()*25000));
	}
}
