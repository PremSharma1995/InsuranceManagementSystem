package com.jbk.insurancemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	private String aadharNo;
	private String fName;
	private String lName;
	private int age;
	private String city;

	public Client() {
		super();
		
	}

	public Client(String aadharNo, String fName, String lName, int age, String city) {
		super();
		this.aadharNo = aadharNo;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.city = city;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Client [aadharNo=" + aadharNo + ", fName=" + fName + ", lName=" + lName + ", age=" + age + ", city="
				+ city + "]";
	}

}
