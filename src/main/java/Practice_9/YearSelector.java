package Practice_9;

import java.time.LocalDate;

public class YearSelector implements Selector {
	private int maxAge;

	public YearSelector(int maxAge) {
		this.maxAge = maxAge;
	}

	@Override
	public boolean mayBeHandled(Employee employee) {
		return maxAge < LocalDate.now().getYear() - employee.getDateOfBirth().getYear();
	}
}
