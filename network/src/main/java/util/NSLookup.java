package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		InetAddress inetaddr[] = null;
		while (true) {
			System.out.print("> ");
			String str = scanner.nextLine();

			if (str.equals("exit")) {
				break;
			}

			try {
				inetaddr = InetAddress.getAllByName(str);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < inetaddr.length; i++) {
				System.out.println(inetaddr[i].getHostName() + " : " + inetaddr[i].getHostAddress());
			}

		}
	}
}
