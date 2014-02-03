package Question4;

public class Modulo7 {

	public static void main(String[] args) {

		int count = 0;
		int sum = 0;
		for (int i = 100; i < 200; i++) {
			if (i % 7 == 0) {
				count += 1;
				sum += i;
				System.out.println(i + "\t is divisible by 7");
			}
		}
		System.out.println("The total numbers divisible by 7 is : " + count
				+ "\t The sum is : " + sum);
	}

}
