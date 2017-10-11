package communication.udpCommunication;

public class UdpCommunnication {

	final private Thread reTh;
	final private Thread seTh;
	
	static String sendMess = "";

	public UdpCommunnication() {
		super();
		this.reTh = new Thread(new UdpReceiveThread(), "receiveThread");
		this.seTh = new Thread(new UdpSendThread("127.0.0.1", 5678),
				"sendThread");
	}

	public void receive() {
		reTh.start();
	}

	public void send(String mess) {
		if (!seTh.isAlive())
			seTh.start();
		sendMess = mess;
	}

	public void send(String mess, String address, int port) {
		if (!seTh.isAlive())
			seTh.start();
		sendMess = mess;

	}

	static public void setMessage(String message) {
		System.out.println(message.substring(0, 8));
		System.out.println(message.substring(8));
	}
}
