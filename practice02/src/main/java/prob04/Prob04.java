package prob04;

public class Prob04 {

	public static void main(String[] args) {

		/*
		 * 문)문자열(String)을 입력 받아, 해당 문자열을 문자 순서를 뒤집어서 char[]로 반환하는 메소드를 만들고, char[]을 입력
		 * 받아 출력하는 메소드를 만드시오.
		 */
		char[] c1 = reverse("Hello World");
		printCharArray(c1);

		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}

	public static char[] reverse(String str) {
		char[] result = str.toCharArray();

		int count = result.length / 2;
		for (int i = 0; i < count; i++) {
			char temp = result[i];
			result[i] = result[result.length - 1 - i];
			result[result.length - 1 - i] = temp;
		}

		return result;
	}

	public static void printCharArray(char[] array) {
		System.out.println(array);
	}
}