package ClientThread;

import java.net.Socket;

import communication.tcpCommunication.TcpCommunication;

public class ClientThread extends Thread {

	final private boolean connectByUdp;

	private int clientId;
	// udp connect

	// tcp connect
	private TcpCommunication tcpComm;

	public ClientThread(Socket socket) {
		connectByUdp = false;
		this.tcpComm = new TcpCommunication(socket);
		this.chart();
	}

	public void chart() {
		if (connectByUdp) {
		} else {
			tcpComm.sendMessage("你好这里是服务器�");
//			System.out.println(">>>");
		}
	}
}
