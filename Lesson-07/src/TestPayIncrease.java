import com.practicaljava.lesson7.Contractor;
import com.practicaljava.lesson7.Employee;
import com.practicaljava.lesson7.Payable;

public class TestPayIncrease {

	public static void main(String[] args) {
		// Creates and initializes the array of Payable objects
		Payable[] workers = new Payable[3];
		workers[0] = new Employee("Sergey");
		workers[1] = new Contractor("Andrey");
		workers[2] = new Employee("Yulya");

		for (Payable p : workers) {
			p.increasePay(30); // Polymorphic method invocation
		}
	}
}
