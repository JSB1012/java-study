package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		/* java.util.Scanner 클래스를 이용하여 입력된 수가 3의 배수인지 판별하는 프로그램을 작성하세요. */
		
	
		System.out.print("수를 입력하세요:");
		int number = scanner.nextInt();

		if (number % 3 == 0) {
			System.out.println("3의 배수입니다.");
		} else {
			System.out.println("3의 배수가 아닙니다.");
		}

		scanner.close();
	}
}
