package jx04;

public class Chicken extends Bird{

	private static int numChicken = 0;

	public Chicken(String name) {
		super(name);
		numChicken++;
	}

	public static int getNum() {
		return numChicken;
	}


}
