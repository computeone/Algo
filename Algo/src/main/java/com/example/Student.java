package com.example;

public class Student implements StudentMBean{
	private String  name="";
	private int age;
	private int number;
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
	     this.age=age;	
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void save(){
		System.out.println("save success!");
	}

}
