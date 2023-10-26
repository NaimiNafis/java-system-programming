package jx02;



public class FactorialTest {

	public static int calcFact(int n) {
		int result = 1;


		// 5.4.3.2.1
		for (int i = 1; i <= n; i++) {
			result = result * i;
		}

		return result;
	}

	public static void main(String[] args) {

		Factorial[] arr = new Factorial[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = new Factorial();
			arr[i].setNum(i);
			arr[i].setFact(calcFact(arr[i].getNum()));
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Number: " + arr[i].getNum());
			System.out.println("Factorial: " + arr[i].getFact());
		}

	}

}


//public static void main(String[] args) {
//
//	Factorial c1 = new Factorial();
//
//	c1.setNum(5);
//	c1.setFact(calcFact(c1.getNum()));
//
//	System.out.println(c1.getNum());
//	System.out.println(c1.getFact());
//
//}
