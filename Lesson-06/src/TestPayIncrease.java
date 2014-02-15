import com.practicaljava.lesson6.Contractor;
import com.practicaljava.lesson6.Employee;
import com.practicaljava.lesson6.Person;

public class TestPayIncrease {

	public static void main(String[] args) {
		Person[] workers = new Person[3];
		workers[0] = new Employee("Sergey");
		workers[1] = new Contractor("Andrey");
		workers[2] = new Employee("Yulya");
		
		Employee currentEmployee;
		Contractor currentContractor;
		
		for (Person person : workers) {
			if (person instanceof Employee) {
				currentEmployee = (Employee) person;
				currentEmployee.increasePay(30);
			} else if (person instanceof Contractor) {
				currentContractor = (Contractor) person;
				currentContractor.increasePay(30);
			}
		}
	}
}
