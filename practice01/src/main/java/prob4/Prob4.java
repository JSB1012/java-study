package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {

		/*
		 * System.out.println(str.substring(0,1));
		 * System.out.println(str.substring(0,2));
		 * System.out.println(str.substring(0,3));
		 * System.out.println(str.substring(0,4));
		 * System.out.println(str.substring(0,5));
		 * System.out.println(str.substring(0,6));
		 * System.out.println(str.substring(0,7));
		 */

		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		int slength = text.length();

		int i = 0;
		while (i < slength) {
			i++;
			System.out.println(text.substring(0, i));
			if (i == Integer.valueOf(slength)) {
				break;
			}
		}

		scanner.close();
	}

}