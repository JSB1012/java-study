package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientThread extends Thread {
	BufferedReader bufferedReader;
	PrintWriter printWriter;
	private Socket socket;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			while (true) {
				String message = bufferedReader.readLine();

				if (message == null) {
					ChatClient.log("입력하셔야합니다.");
					break;
				} else {
					System.out.println(message);
				}
			}
		} catch (IOException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}