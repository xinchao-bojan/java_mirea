package Practice_9;

import java.time.LocalDate;

public class Employee {

	private String name;
	private String surname;
	private final LocalDate dateOfBirth;
	private String location;
	private String phoneNumber;
	private double baseSalary;

	public Employee(String name, String surname, LocalDate dateOfBirth, String location, String phoneNumber, double baseSalary) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.baseSalary = baseSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void addBaseSalary(double baseSalary) {
		this.baseSalary += baseSalary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", dateOfBirth=" + dateOfBirth +
				", location='" + location + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", baseSalary=" + baseSalary +
				'}';
	}
}
