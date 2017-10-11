package communication.tcpCommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class TcpCommunication {
	private static Socket socket;

	private BufferedReader bufferedReader;			//new BufferedReader(new InputStreamReader(inputStream));
	private PrintStream printStream;				//new PrintStream(outputStream)

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
		printStream.println(message);
	}

	public void receiveMessage() {
		tcpRecTh = new TcpReceiveThread(bufferedReader);
		tcpRecTh.start();
	}

	/*==========================================Server========================================*/
	public void ServerBuild() {// build Server wait to handshake
		try {
			tcpAccTh = new TcpAcceptingThread();
			tcpAccTh.start(); // start tcp wait thread
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static public void buildClientAlert(Socket socket) {
/*
 * 当外界需要接受socket时使用该方法。
		GameClient.BuildClientThread(socket); // a client is connect, alert server to
										// build client thread
*/
	}
	
	/*==========================================Client========================================*/
	public void ClientBuild() {
		try {
			socket = new Socket("localhost", 5678); // try to connect to server
			this.buildStream();
//			String c =  bufferedReader.readLine();
//			System.out.println("receive success" + c);
			System.out.println("Client: has been connect to Server");
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
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printStream = new PrintStream(socket.getOutputStream());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
