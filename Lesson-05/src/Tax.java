public class Tax {
	private double grossIncome;
	private String state;
	private int dependents;

	public Tax() {
		System.out.println("The Tax's default constructor.");
	}

	public Tax(double grossIncome, String state, int dependents) {
		this.grossIncome = grossIncome;
		this.state = state;
		this.dependents = dependents;
	}

	public double calcTax() {
		double stateTax = 0;
		if (grossIncome < 30_000) {
			stateTax = grossIncome * 0.05;
		} else {
			stateTax = grossIncome * 0.06;
		}

		return stateTax;
	}
}
