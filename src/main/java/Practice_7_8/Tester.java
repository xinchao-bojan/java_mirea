package Practice_7_8;


import java.util.ArrayList;
import java.util.List;

public class Tester {
	public static void main(String[] args) {
		Company sony=new Company();
		sony.hire(new Employee("Lil","krystall",125000,new TopManager(sony)));
		sony.hire(new Employee("Tsoi","Viktor",75000,new Manager()));
		sony.hire(new Employee("A4","Vlad",35000,new Operator()));

		List <Employee> traineeList =new ArrayList<>();
		for(int i=0;i<179;i++)
			traineeList.add(new Employee("Operator "+i,"Model "+(int)(Math.random()*1000),(int)(10000+Math.random()*50000),new Operator()));
		for(int i=0;i<79;i++)
			traineeList.add(new Employee("Manager "+i,"Model "+(int)(Math.random()*1000),(int)(50000+Math.random()*50000),new Manager()));
		for(int i=0;i<9;i++)
			traineeList.add(new Employee("Top Manager "+i,"Model "+(int)(Math.random()*1000),(int)(100000+Math.random()*50000),new TopManager(sony)));
		sony.hireAll(traineeList);
		traineeList.clear();
		sony.makeSomeWork();

		System.out.println("Best workers of month:");
		for(Employee emp : sony.getTopSalaryStaff(11))
			System.out.println(emp.getFinalSalary());

		System.out.println();

		System.out.println("Worst workers of month:");
		for(Employee emp : sony.getLowestSalaryStaff(30))
			System.out.println(emp.getFinalSalary());

		System.out.println();

		sony.fireByCount(sony.getOtherEmployers().size()/2);

		System.out.println("Best workers of month:");
		for(Employee emp : sony.getTopSalaryStaff(12))
			System.out.println(emp.getFinalSalary());

		System.out.println();

		System.out.println("Worst workers of month:");
		for(Employee emp : sony.getLowestSalaryStaff(30))
			System.out.println(emp.getFinalSalary());
	}
}
