package com.grey.taxcalc;

public class TestTax {

	public static void main(String[] args) {
		double grossIncome;
		String state;
		int dependents;
		
		grossIncome = 50_000;
		dependents = 2;
		state = "NJ";
		
		Tax t = new Tax(grossIncome, state, dependents);
		Tax t2 = new Tax(65_000, "TX", 4);
		
		double yourTax = t.calcTax();
		double hisTax = t2.calcTax();
		
		System.out.println("Your tax is " + yourTax);
		Tax.convertToEuros(yourTax);
		System.out.println("His tax is " + hisTax);
		Tax.convertToEuros(hisTax);
	}
}
