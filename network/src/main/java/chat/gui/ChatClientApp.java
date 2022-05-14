package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);

		try {
			while (true) {
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();

				if (name.isEmpty() == false) {
					break;
				}

				System.out.println("대화명은 한 글자 이상 입력해야 합니다.\n");
			}

			scanner.close();

			// 1. create socket
			socket = new Socket();

			// 2. connect server
			socket.connect(new InetSocketAddress("127.0.0.1", 8000));

			// 3. get iostream(pipline established)
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 4. join protocol 처리
			pw.println("join: " + name);
			String line = br.readLine();
			System.out.println(line);

			new ChatWindow(name, socket).show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}