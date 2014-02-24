package com.practicaljava.lesson7;

/**
 * A Contractor object represents a person working as a contractor.
 */
public class Contractor extends Person implements Payable {

	/*
	Object
	|
	Person
	|
	Contractor----Payable
	*/

	private double hourlyPay;

	/**
	 * Initializes a new Contractor object
	 *
	 * @param name the name of the new contractor
	 */
	public Contractor(String name, double hourlyPay) {
		super(name);
		this.hourlyPay = hourlyPay;
	}

	public double getHourlyPay() {
		return hourlyPay;
	}

	@Override
	public boolean increasePay(int percent) {
		if (percent < INCREASE_CAP) {
			System.out.println("Increasing salary by " + percent + "%. "
					+ getName());
			hourlyPay += hourlyPay * (percent / 100.0);
			System.out.println("New value: " + getHourlyPay());
			return true;
		} else {
			System.out
					.println("Sorry, can't increase hourly rate by more than "
							+ INCREASE_CAP + "%. " + getName());
			return false;
		}
	}
}
