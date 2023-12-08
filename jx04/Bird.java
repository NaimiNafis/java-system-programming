package jx04;

public class Bird {

	private String name;
	private static int numBird = 0;

	public Bird(String nm) {
		this.name = nm;
		numBird++;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static int getNum() {
		return numBird;
	}

	public static void main(String[] args) {

		Bird b = new Bird("Bird");
		Chicken c1 = new Chicken("c1");
		Chicken c2 = new Chicken("c2");
		Penguin p1 = new Penguin("p1");
		Penguin p2 = new Penguin("p2");
		Penguin p3 = new Penguin("p3");

		System.out.println("Bird: " + Bird.getNum());
		System.out.println("Chicken: " + Chicken.getNum());
		System.out.println("Penguin: " + Penguin.getNum());
		System.out.println(b + "" + c1 + c2 + p1 + p2 + p3);

	}

}
