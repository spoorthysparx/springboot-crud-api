package com.hexaware.web.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.*;

@Entity
public class Student {
	
	@Id
	int Roll;
	@NotEmpty
	String name;
	Double fee;
	@Min(value=18,message="Age can't be below 18")
	@Max(value=60,message="Age can't be above 60")
	int age;
	@Email
	String Email;
	@Size(min=4,max=50)
	String Address;

	Student(){
		
	}

	public Student(int roll, String name, Double fee ,int age,String email,String address) {
		super();
		Roll = roll;
		this.name = name;
		this.fee = fee;
		this.age=age;
		Email=email;
		Address = address;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRoll() {
		return Roll;
	}
	public void setRoll(int roll) {
		Roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Student [Roll=" + Roll + ", Name=" + name + ", fee=" + fee + ", Age=" + age + ", Email=" + Email
				+ ", Address=" + Address + "]";
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	
	
}
