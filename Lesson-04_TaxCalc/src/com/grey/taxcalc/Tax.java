package com.grey.taxcalc;

public class Tax {
	double grossIncome;
	String state;
	int dependents;
	static int customerCounter;
	
	Tax(double gi, String st, int depen) {
		grossIncome = gi;
		state = st;
		dependents = depen;
		customerCounter++;
		System.out.println("Preparing the tax data for the customer #" + customerCounter);
	}
	
	double calcTax() {
		return (grossIncome * 0.33 - dependents * 100);
	}
	
	static void convertToEuros(double tax) {
		System.out.println(tax * 0.75 + " euro(s)");
	}
}
