package Practice_7_8;

public class Employee {
	private String surname;
	private String name;
	private double baseSalary;
	private double finalSalary;
	private EmployeePosition jobPlace;

	public Employee(String surname, String name, double baseSalary, EmployeePosition jobPlace)
	{
		this.baseSalary=baseSalary;
		this.surname=surname;
		this.name=name;
		this.jobPlace=jobPlace;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public EmployeePosition getJobPlace() {
		return jobPlace;
	}

	public void setJobPlace(EmployeePosition jobPlace) {
		this.jobPlace = jobPlace;
	}

	public double getFinalSalary() {
		return finalSalary;
	}

	public void setFinalSalary(double finalSalary) {
		this.finalSalary = finalSalary;
	}
}
