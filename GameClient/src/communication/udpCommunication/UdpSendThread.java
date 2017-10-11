package communication.udpCommunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpSendThread implements Runnable {

	private String address;
	private int port;

	public UdpSendThread(String address, int port) {
		super();
		this.address = address;
		this.port = port;
	}

	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket();

			while (UdpCommunnication.sendMess != "") {
				byte[] data = UdpCommunnication.sendMess.getBytes();
				DatagramPacket pack = new DatagramPacket(data, data.length,
						InetAddress.getByName(address), port);
				socket.send(pack);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
