package chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		try {
			// 1. 키보드 연결
			System.out.print("닉네임 : ");
			String nickname = scanner.nextLine();

			// 2. 소켓 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress("127.0.0.1", 8000));
			log("connected");

			// 4. reader/writer 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			pw.println("join: " + nickname);
			//pw.flush();

			// 6. ChatClientThread 시작
			new ChatClientThread(socket).start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String line = scanner.nextLine();
				if ("quit".equals(line) == true) {
					// 8. quit 프로토콜 처리
					pw.println("quit");
					//pw.flush();
					break;
				} else {
					// 9. 메시지 처리
					
					pw.println("message:" + line);
					
					//pw.flush();
				}

			}

		} catch (IOException ex) {
			log("error:" + ex);
		} finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				} else if (scanner != null) {
					scanner.close();
				}

			} catch (IOException e) {
				System.out.println("error: " + e);
			}

		}
	}

	public static void log(String log) {
		System.out.println("[ChatClient] " + log);
	}

}
