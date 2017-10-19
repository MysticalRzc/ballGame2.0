package communication.udpCommunication;

import java.net.SocketException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.GameClient;

public class UdpCommunnication {

	final private static String regEx = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
	private UdpReceiveThread reTh;
	private UdpSendFunction seFun;

	public UdpCommunnication() {
		super();
	}

	public UdpCommunnication(String address, int sendPort, int recePort) {
		super();
		try {
			this.checkAddPort(address, sendPort, recePort);
			this.reTh = new UdpReceiveThread(recePort);
			this.seFun = new UdpSendFunction(address, sendPort);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buildUdpCommunication(String address, int sendPort, int recePort) {
		try {
			this.checkAddPort(address, sendPort, recePort);
			if (this.reTh != null && this.reTh.isAlive() == true)
				this.reTh.interrupt();
			this.reTh = new UdpReceiveThread(recePort);
			this.seFun = new UdpSendFunction(address, sendPort);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void receive() {
		reTh.start();
	}

	public void send(String mess) {
		if (seFun != null) {
			seFun.sendMessage(mess);
		} else
			try {
				throw new Exception(
						"udpCommnication need build, nullPointException");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void send(String mess, String address, int port) {
		if (seFun != null)
			seFun.sendMessage(mess);
		else
			try {
				throw new Exception(
						"udpCommnication need build, nullPointException");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	static protected void setMessage(String message) { // kid visited only
		GameClient.messBuff.setMessage(message.substring(0, 8),
				message.substring(8));
	}

	public void checkAddPort(String address, int sendPort, int recePort)
			throws Exception {
		if ((sendPort < 0 || sendPort >= 65535) && (recePort < 0 || recePort >= 65535))
			throw new Exception("address error!");
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(address);
		if (!m.find())
			throw new Exception("port error!");
	}
}
