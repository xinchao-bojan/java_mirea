package Practice_7_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Company {

	private double income=0;
	private List <Employee> otherEmployers=new ArrayList<>();
	private boolean needToSort=true;

	public void makeSomeWork()
	{
		needToSort=true;
		for(Employee mng : otherEmployers)
		{
			if(mng.getJobPlace().getJobTitle().equals("Manager"))
			{
				mng.setFinalSalary(mng.getJobPlace().calcSalary(mng.getBaseSalary()));
				income+=(mng.getFinalSalary()-mng.getBaseSalary() )*20;
			}

		}

		for(Employee oe : otherEmployers)
		{
			if(!oe.getJobPlace().getJobTitle().equals("Manager"))
				oe.setFinalSalary(oe.getJobPlace().calcSalary(oe.getBaseSalary()));
		}

	}

	private boolean staffSorting(int count)
	{
		if(count>0 && count<otherEmployers.size())
		{
			if(needToSort)
			{
				otherEmployers.sort(Comparator.comparing(Employee::getFinalSalary));
				needToSort=false;
			}
			return true;
		}
		return false;
	}

	public List<Employee> getTopSalaryStaff(int count)
	{
		if(staffSorting(count)) {
			Collections.reverse(otherEmployers.subList(otherEmployers.size() - 1 - count, otherEmployers.size() - 1));
			return otherEmployers.subList(otherEmployers.size() - 1 - count, otherEmployers.size() - 1);
		}
		return null;
	}

	public List<Employee> getLowestSalaryStaff(int count)
	{
		if(staffSorting(count))
			return otherEmployers.subList(0,count);
		return null;
	}

	public void hire(Employee worker)
	{
		needToSort=true;
		otherEmployers.add(worker);
		System.out.println(worker.getName()+" "+worker.getSurname()+" was hired to our company");
	}

	public void hireAll(List<Employee> listOfEmployers)
	{
		for(Employee emp : listOfEmployers)
		{
			hire(emp);
		}
	}

	public void fire(Employee worker)
	{
		needToSort=true;
		otherEmployers.remove(worker);
		System.out.println(worker.getName()+" "+worker.getSurname()+" was fired from our company");
	}

	public void fireByCount(int count)
	{
		if(count<=0 )
			return;
		if(count> otherEmployers.size())
		{
			otherEmployers.clear();
			System.out.println("All employers was fired");
		}
		else
			for(int i= 0;i<count;i++)
				fire(otherEmployers.get((int)(Math.random()*otherEmployers.size())));
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income+=income;
	}

	public List<Employee> getOtherEmployers() {
		return otherEmployers;
	}
}
