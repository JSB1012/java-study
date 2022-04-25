package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */

		/*
		 * for (int i = 0; i <= 8; i++) { for(int j=1; j<=10; j++) { // int k = i+j;
		 * 
		 * System.out.print(i + j + ""); } System.out.println(""); }
		 * 
		 * }
		 */

		/* 출력 값이 다음과 같도록 Prob2 클래스의 main 메쏘드를 완성하십시오. */
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(i + j + " ");
			}
			System.out.println();
		}
	}
}
