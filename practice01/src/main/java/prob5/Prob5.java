package prob5;

public class Prob5 {

	/*
	 * 반복문을 이용하여 369게임에서 박수를 쳐야 하는 경우의 수를 순서대로 화면에 출력해보세요. 1부터 99까지만 실행하세요
	 */

	public static void main(String[] args) {
		for (int i = 1; i <= 99; i++) {
			if ((i % 10) == 3 || (i % 10) == 6 || (i % 10) == 9) {
				if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9)
					System.out.println(i + " 짝짝");
				else
					System.out.println(i + " 짝");
			} else if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9)
				System.out.println(i + " 짝");
		}
	}
}
