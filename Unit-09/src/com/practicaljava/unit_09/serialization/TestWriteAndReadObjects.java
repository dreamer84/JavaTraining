package com.practicaljava.unit_09.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestWriteAndReadObjects {

	public static void main(String[] args) throws IOException {
		Employee employee = new Employee("Grey", 30.000, 2014, 04, 05);
		Manager manager = new Manager("John Doe", 50.000, 2013, 07, 15);

		// Writes the objects in the file
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("employee.dat"))) {
			out.writeObject(employee);
			out.writeObject(manager);
		} catch (FileNotFoundException e) {
			System.err.println("Error: file not found!");
			System.exit(1);
		}

		// Reads the objects from the file
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"employee.dat"))) {
			Employee empl1 = (Employee) in.readObject();
			Employee empl2 = (Employee) in.readObject();

			System.out.println(empl1.getName());
			System.out.println(empl2.getName());

		} catch (FileNotFoundException e) {
			System.err.println("Error: file not found!");
			System.exit(1);
		} catch (ClassNotFoundException e) {
			System.err.println("Error: class not found!");
			System.exit(2);
		}
	}
}
