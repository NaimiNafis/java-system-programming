package jx02;

public class PersonTest {

	public static void main(String[] args) {

		Person myself = new Person();
		myself.setAddress("Shugakuin, Sakyoku, Kyoto ");
		myself.setFirstName("Naimi ");
		myself.setLastName("Nafis ");

		System.out.println("Name: " + myself.getName());
		System.out.println("Address: " + myself.getAddress());
		myself.print();


	}

}
