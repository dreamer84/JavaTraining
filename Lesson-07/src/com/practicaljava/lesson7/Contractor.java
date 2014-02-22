package com.practicaljava.lesson7;

/**
 * An Contractor object represent a person working as a contractor.
 */
public class Contractor extends Person implements Payable {
	
	/**
	 * Initializes a new Contractor object
	 * @param name the name of the new contractor
	 */
	public Contractor(String name) {
		super(name);
	}

	@Override
	public boolean increasePay(int percent) {
		if (percent < INCREASE_CAP) {
			System.out.println("Increasing salary by " + percent
					+ "%. " + getName());
			return true;
		} else {
			System.out.println("Sorry, can't increase hourly rate by more than " +
					INCREASE_CAP + "%. " + getName());
			return false;
		}
	}
}
