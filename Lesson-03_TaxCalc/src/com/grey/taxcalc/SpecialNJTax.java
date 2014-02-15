package com.grey.taxcalc;

public class SpecialNJTax extends NJTax {
	
	public SpecialNJTax() {
		super(20_000, "NJ", 1, 100);
		System.out.println("The SpecialNJTax's default constructor.");
	}
}
