package Practice_9;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private double income = 0;
	private List<Employee> otherEmployers = new ArrayList<>();
	private boolean needToSort = true;

	public void hire(Employee worker) {
		needToSort = true;
		otherEmployers.add(worker);
		System.out.println(worker.getName() + " " + worker.getSurname() + " was hired to our company");
	}

	public void hireAll(List<Employee> listOfEmployers) {
		for (Employee emp : listOfEmployers) {
			hire(emp);
		}
	}

	public void fire(Employee worker) {
		needToSort = true;
		otherEmployers.remove(worker);
		System.out.println(worker.getName() + " " + worker.getSurname() + " was fired from our company");
	}

	public void fireByCount(int count) {
		if (count <= 0)
			return;
		if (count > otherEmployers.size()) {
			otherEmployers.clear();
			System.out.println("All employers was fired");
		} else
			for (int i = 0; i < count; i++)
				fire(otherEmployers.get((int) (Math.random() * otherEmployers.size())));
	}

	public void HandleEmlpoyees(Selector s, Handler h) {
		int count = 0;
		for (Employee emp : otherEmployers) {
			if (s.mayBeHandled(emp)) {
				h.handle(emp);
				System.out.println(emp.toString());
				count++;
			}
		}
	}
}
