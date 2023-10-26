package jx03;

public class Student extends Person{

	//attribute

	private String school;
	private int grade;
	private String number;

	//method

	public void setSchool(String sname) {
		school = sname;
	}

	public String getSchool() {
		return school;
	}

	public void setGrade(int gd) {
		grade = gd;
	}

	public int getGrade() {
		return grade;
	}

	public void setNumber(String no) {
		number = no;
	}

	public String getNumber() {
		return number;
	}

    public static void main(String[] args) {
    	Student s1 = new Student();
    	s1.setFirstName("Naimi ");
    	s1.setLastName("Nafis ");
    	s1.setAddress("Shugakuin, Kyoto");
    	s1.setSchool("Kyoto Institute of Technology");
    	s1.setGrade(2);
    	s1.setNumber("22122063");

    	System.out.println("Name: " + s1.getName());
		System.out.println("Address: " + s1.getAddress());
		System.out.println("School: " + s1.getSchool());
		System.out.println("Grade: " + s1.getGrade());
		System.out.println("Student Number: " + s1.getNumber());

    	s1.print();
    }

	@Override
	public void print() {
		super.print();
		System.out.println("School: " + getSchool());
		System.out.println("Grade: " + getGrade());
		System.out.println("Student Number: " + getNumber());
	}





}
