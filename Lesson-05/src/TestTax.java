public class TestTax {

	public static void main(String[] args) {
		// Test program arguments
		if (args.length != 3) {
			System.out.println("Usage: java TestTax 32000 CA 2");
			System.exit(1);
		}
		
		double grossIncome = Double.parseDouble(args[0]);
		String state = args[1];
		int dependents = Integer.parseInt(args[2]);

		Tax t = new Tax(grossIncome, state, dependents);
		System.out.println("Your tax is " + t.calcTax());
	}
}
