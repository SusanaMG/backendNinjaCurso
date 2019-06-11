package com.udemy.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
	
	@NotNull
	@Size(min=2, max=6)
	private String name;
	
	@NotNull
	@Min(18)
	private int age;

	//GETTERS Y SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//CONSTRUCTORES
	
	public Person() {}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//Para facilitar la recogida de la información de person
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
			
}
