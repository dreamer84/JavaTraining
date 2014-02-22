import com.practicaljava.lesson7.Contractor;
import com.practicaljava.lesson7.Employee;
import com.practicaljava.lesson7.Payable;

public class TestPayIncrease {

	public static void main(String[] args) {
		// Creates and initializes the array of Payable objects
		Payable[] workers = new Payable[3];
		workers[0] = new Employee("Sergey", 30_000.0);
		workers[1] = new Contractor("Andrey", 10.0);
		workers[2] = new Employee("Yulya", 20_000.0);

		for (Payable p : workers) {
			p.increasePay(30); // Polymorphic method invocation
		}
	}
}
