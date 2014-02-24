package com.practicaljava.lesson7;

/**
 * An Employee object represents a person working as an employee.
 */
public class Employee extends Person implements Payable {

	/*
	Object
	|
	Person
	|
	Employee----Payable
	*/

	private double salary;

	/**
	 * Initializes a new Employee object
	 *
	 * @param name the name of the new employee
	 * @param salary the employee's salary
	 */
	public Employee(String name, double salary) {
		super(name);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public boolean increasePay(int percent) {
		System.out.println("Increasing salary by " + percent + "%. "
				+ getName());
		salary += salary * (percent / 100.0);
		System.out.println("New value: " + getSalary());
		return true;
	}
}
