package prob03;

import java.util.Arrays;

public class Prob03 {
	public static void main(String args[]) {
		
		/* 문)문자 배열(char[])을 입력 받아, 공백을 ‘,’로 변환하는 메소드와 char[]을 입력 받아 출력하는 메소드를 만드세요. */
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };

		// 원래 배열 원소 출력
		printCharArray(c);

		// 공백 문자 바꾸기
		replaceSpace(c);

		// 수정된 배열 원소 출력
		printCharArray(c);
	}

	public static void replaceSpace(char[] c) {
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				c[i] = ',';
			}
		}
	}

	public static void printCharArray(char[] c) {
		System.out.println(c);
	}

}
