package jx04;

public class Penguin extends Bird{

	private static int numPenguin = 0;

	public Penguin(String name) {
		super(name);
		numPenguin++;
	}

	public static int getNum() {
		return numPenguin;
	}


}
