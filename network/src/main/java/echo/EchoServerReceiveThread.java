package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerReceiveThread extends Thread {
	private Socket socket;

	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();

		String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetSocketAddress.getPort();

		EchoServer.log("connected by client[" + remoteHostAddress + "]" + " :  " + remoteHostPort);

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			while (true) {
				String data = br.readLine();
				if (data == null) {
					EchoServer.log("close by client");
					break;
				}

				EchoServer.log("received : " + data);
				pw.println(data);
			}
		} catch (SocketException ex) {
			System.out.println("[server] 갑자기 닫힘 :" + ex);
		} catch (IOException ex) {
			System.out.println("[server] error:" + ex);
		} finally {
			try {
				if (socket != null && !socket.isClosed() == false) {
					socket.close(); // 소켓만 닫으면 됨
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
