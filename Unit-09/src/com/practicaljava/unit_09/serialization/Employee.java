package com.practicaljava.unit_09.serialization;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * An employee.
 */
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private double salary;
	private Date hireDay;

	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		this.hireDay = calendar.getTime();
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}
