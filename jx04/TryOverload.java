package jx04;

public class TryOverload {

	private int valInt;
	private String valStr;
	private double valDouble;

	//setter getter

	public void setValInt(int val) {
		this.valInt = val;
	}

	public int getValInt() {
		return valInt;
	}

	public void setValStr(String val) {
		this.valStr = val;
	}

	public String getValStr() {
		return valStr;
	}

	public void setValDouble(double val) {
		this.valDouble = val;
	}

	public double getValDouble() {
		return valDouble;
	}


	//setValue method
	public void setValue(int val) {
		this.valInt = val;
	}

	public void setValue(String val) {
		this.valStr = val;
	}

	public void setValue(Double val) {
		this.valDouble = val;
	}





	//times method

	public void times(int val1, int val2) {
		System.out.println(val1 * val2);
	}

	public void times(String str, int num) {
		for(int i = 0; i < num; i++) {
			System.out.print(str);
		}
		System.out.println();
	}

	public void times(int num, String str) {
		for(int i = 0; i < num; i++) {
			System.out.print(str);
		}
		System.out.println();
	}

	public void times(String str1, String str2) {
		System.out.println(str1 + str2);
	}

	public static void main(String[] args) {
		TryOverload inst1 = new TryOverload();

		inst1.setValue(3);
		System.out.println("valInt: " + inst1.getValInt());
		inst1.setValue(2);
		System.out.println("valDouble: " + inst1.getValDouble());
		inst1.setValue("Happy");
		System.out.println("valStr: " + inst1.getValStr());

		inst1.times(3, 4);
		inst1.times("Happy", 3);
		inst1.times(4, "Birthday");
		inst1.times("Happy ", "Birthday!");

		System.out.println();

	}

}
