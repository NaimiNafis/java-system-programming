package jx01;

public class Calc {

	public static void main(String[] args) {

		int numbers[] = {10, 12, 8, 16, 20, 6, 24, 32};

		int min = numbers[0];
		int max = numbers[0];
		int sum = 0;

		for (int i = 0; i < numbers.length; i++) {

			int num = numbers[i];
			if (num > max) {
				max = num;
			}
			else if(num < min) {
				min = num;
			}

			sum += num;
		}

		double average = sum / numbers.length;

		System.out.println("最大値: " + max);
		System.out.println("最小値: " + min);
		System.out.println("平均値: " + average);
	}

}
