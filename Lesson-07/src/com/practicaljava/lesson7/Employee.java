package com.practicaljava.lesson7;

/**
 * An Employee object represent a person working as an employee.
 */
public class Employee extends Person implements Payable {
	
	/**
	 * Initializes a new Employee object
	 * @param name the name of the new employee
	 */
	public Employee(String name) {
		super(name);
	}

	@Override
	public boolean increasePay(int percent) {
		System.out.println("Increasing salary by " + percent
				+ "%. " + getName());
		return true;
	}
}
