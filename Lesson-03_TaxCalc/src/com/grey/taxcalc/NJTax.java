package com.grey.taxcalc;

public class NJTax extends Tax {
	private double deduct;
	
	public NJTax() {
		System.out.println("The NJTax's default constructor.");
	}
	
	public NJTax(double grossIncome, String state,
			int dependents, double deduct) {
		super(grossIncome, state, dependents);
		System.out.println("The NJTax's constructor (deduct).");
	}
	
	@Override
	public double calcTax() {
		return super.calcTax() - deduct;
	}
}
