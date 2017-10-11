package communication.tcpCommunication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpCommunication {
	private static Socket socket;

	private InputStream inputStream;
	private OutputStream outputStream;

	private TcpAcceptingThread tcpAccTh;
	private TcpReceiveThread tcpRecTh;

	public TcpCommunication() {
	}

	public TcpCommunication(Socket socket) {
		// when build ClientThread use this constructor
		this.socket = socket;
		this.buildStream();
	}

	public void sendMessage(String message) {
		try {
			outputStream.write(message.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void receiveMessage() {
		tcpRecTh = new TcpReceiveThread(inputStream);
		tcpRecTh.start();
	}

	// Server
	public void ServerBuild() {// build Server wait to handshake
		try {
			tcpAccTh = new TcpAcceptingThread();
			tcpAccTh.start(); // start tcp wait thread
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static public void buildClientAlert(Socket socket) {
//		GameClient.BuildClientThread(socket); // a client is connect, alert server to
										// build client thread
	}

	// Client
	public void ClientBuild() {
		try {
			socket = new Socket("localhost", 5678); // try to connect to server
			this.buildStream();
			char c = (char) inputStream.read();
			System.out.println("receive success" + c);
			// System.out.println("Client: has been connect to Server");
		} catch (IOException e) {
			System.out.println("connect server failed!");
			socket = null;
		}
	}

	private boolean buildStream() {
		if (socket == null) {
			System.out.println("socket is null,can not build stream");
		}
		try {
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
