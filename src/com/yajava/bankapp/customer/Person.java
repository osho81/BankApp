package com.yajava.bankapp.customer;

public abstract class Person {

	private String fName;
	private String lName;
	private String address; 
	private String ssn;
	
	public Person(String fName, String lName, String address, String ssn) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.ssn = ssn;
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
	public String getSSN() {
		return ssn;
	}
	public void setSSN(String sSN) {
		ssn = sSN;
	}

	public String getAdress() {
		return address;
	}

	public void setAdress(String adress) {
		this.address = adress;
	} 
	
	@Override
	public String toString() {
		return "SSN: " + ssn + "\nName: " + fName + " " + lName + "\tAddress: " + address;
	}
	
}
