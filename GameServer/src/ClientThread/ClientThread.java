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
	public ClientThread()
	{
		connectByUdp = true;
	}

	public void chart() {
		if (connectByUdp) {
		} else {
			tcpComm.sendMessage("request0Hello this is Server");
		}
	}
}
