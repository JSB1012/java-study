package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	List<Writer> listWriters;
	BufferedReader bufferedReader;
	PrintWriter printWriter;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		super.run();
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketAddress.getPort();

		ChatServer.log("connected by client [ " + remoteHostAddress + "/" + remoteHostPort + "]");

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			while (true) {
				String line = bufferedReader.readLine();

				if (line == null) {
					ChatServer.log("클라이언트로부터 연결 끊김");

					doQuit(printWriter);
					break;
				}

				String[] tokens = line.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
				} else {
					ChatServer.log("에러: 알수 없는 요청( " + tokens[0] + " )");
				}
			}

		} catch (UnsupportedEncodingException e) {
			ChatServer.log("에러: " + e);
		} catch (IOException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;

		String data = nickname + "님이 입장하였습니다.";
		broadcast(data);

		addWriter(writer);

		printWriter.println(data);
		//printWriter.flush();

		/*
		 * printWriter.println("join:ok"); printWriter.flush();
		 */
		
		printWriter.println(" 매너를 지켜 주세요.");
		//printWriter.flush();
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);

		String data = nickname + "님이 퇴장하였습니다.";
		broadcast(data);
	}

	private void doMessage(String message) {
		broadcast(this.nickname + ":" + message);
	}

	private void broadcast(String data) {

		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				//printWriter.flush();
			}

		}
	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
	}

}
