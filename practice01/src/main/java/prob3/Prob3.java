package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		System.out.print("수를 입력하세요:");
		int number = scanner.nextInt();
		int oddSum = 0;
		int evenSum = 0;

		if (number % 2 != 0) {
			for (int i = 0; i < number; i++) {
				if ((i + 1) % 2 != 0) {
					oddSum = oddSum + (i + 1);
				}
			}
			System.out.println("결과 값:" + oddSum);
		}
		if (number % 2 == 0) {
			for (int i = 0; i < number; i++) {
				if ((i + 1) % 2 == 0) {
					evenSum = evenSum + (i + 1);
				}
			}
			System.out.println("결과 값:" + evenSum);
		}
		scanner.close();
	}
}
