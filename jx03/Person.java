package jx03;

public class Person {

	//instance variable

	private String lastName;
	private String firstName;
	private String address;

	//instance method

	public void setLastName(String lname) { //setter
		lastName = lname;
	}

	public String getLastName() { //getter
		return lastName;
	}

	public void setFirstName(String fname) { //setter
		firstName = fname;
	}

	public String getFirstName() { //getter
		return firstName;
	}

	public String getName() {   //getter for both name
		return firstName + lastName;
	}

	public void setAddress(String add) { //setter
		address = add;
	}

	public String getAddress() { //getter
		return address;
	}

	public void print() {
		System.out.println("Name: " + getName());
		System.out.println("Address: " + getAddress());
	}



}
