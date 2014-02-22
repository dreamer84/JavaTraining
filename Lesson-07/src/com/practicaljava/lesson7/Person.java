package com.practicaljava.lesson7;

/**
 * A Person object represents basic information
 * about a person.
 */
public class Person {
	private String name;
	
	/**
	 * Initializes a new Person object
	 * @param name the name of the new person
	 */
	public Person(String name) {
		this.name = name;
	}
	
	/**
	 * @return the person's name
	 */
	public String getName() {
		return "Person's name is " + name;
	}
}
