package com.grey.taxcalc;

public class TestTax {

	public static void main(String[] args) {
		Tax t = new Tax(12000, "NJ", 2);
		
		double yourTax = t.calcTax();
		
		System.out.println("Your tax is " + yourTax);
	}
}
