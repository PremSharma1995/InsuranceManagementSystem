package com.jbk.insurancemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientInsuranceData {

	@Id
	private String insuranceDataId;
	private int insuranceId;
	private String aadharNo;
	private String issueDate;
	private String expDate;
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

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public double getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	private String fName;
	private String lName;
	private int age;
	private String city;
	private String insuranceType;
	private double insurancePrice;
	public ClientInsuranceData() {
		super();

	}

	public ClientInsuranceData(String insuranceDataId, int insuranceId, String aadharNo, String issueDate,
			String expDate) {
		super();
		this.insuranceDataId = insuranceDataId;
		this.insuranceId = insuranceId;
		this.aadharNo = aadharNo;
		this.issueDate = issueDate;
		this.expDate = expDate;
	}

	public String getInsuranceDataId() {
		return insuranceDataId;
	}

	public void setInsuranceDataId(String insuranceDataId) {
		this.insuranceDataId = insuranceDataId;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	@Override
	public String toString() {
		return "ClientInsuranceData [insuranceDataId=" + insuranceDataId + ", insuranceId=" + insuranceId
				+ ", aadharNo=" + aadharNo + ", issueDate=" + issueDate + ", expDate=" + expDate + ", fName=" + fName
				+ ", lName=" + lName + ", age=" + age + ", city=" + city + ", insuranceType=" + insuranceType
				+ ", insurancePrice=" + insurancePrice + "]";
	}

	

}
