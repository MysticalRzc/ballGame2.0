package mystical.com.main;

import java.util.Scanner;

import mystical.com.messageBuffer.MessageBuffer;

import mystical.com.communication.tcpCommunication.TcpCommunication;
import mystical.com.communication.udpCommunication.UdpCommunnication;

public class GameClient {
	final public static MessageBuffer messBuff = new MessageBuffer(
			new GameClientArouse());
	final private static TcpCommunication tcpComm = new TcpCommunication();
	final private static UdpCommunnication udpComm = new UdpCommunnication();
	private static boolean isUdpCommunication = true;

	private static int clientStap = 0;// ��¼�ͻ������е��ڼ���

	public static void StartClient() {
		// after finish configuration, then start some function on client
		if (clientStap == 1)
			if (isUdpCommunication) {
				udpComm.receive();
				udpComm.send("U7T#"+ GameClientMode.getServerId() +"getCliId"+GameClientMode.getAddress()+"#"+GameClientMode.getRecePort());
				String clientId;
				while((clientId = messBuff.getMessage("U3F#-001getCliId"))==null);
				GameClientMode.setClientId(Integer.parseInt(clientId));
				clientStap = 2;
				System.out.println("GameClient start successful");
			} else {
				System.out.println("GameClient start successful");
			}
	}

	public static void buildClientByDefault() {
		// build client use default address and port, Use this function to make
		// test quickly
		System.out.println("Build client by default start");
		udpComm.buildUdpCommunication(GameClientMode.getAddress(),
				GameClientMode.getSendPort(), GameClientMode.getRecePort());
	}

	public static void buildClient() {
		// build client user will input address sendPort and receivePort or
		// other configuration.

		Scanner sc = new Scanner(System.in);
		System.out.println("Set address");

		if (GameClientMode.setAddress(sc.nextLine())) {
			if (GameClientMode.setRecePort(sc.nextInt())
					&& GameClientMode.setSendPort(sc.nextInt())) {
				udpComm.buildUdpCommunication(GameClientMode.getAddress(),
						GameClientMode.getSendPort(),
						GameClientMode.getRecePort());
				clientStap = 1;
				System.out.println("Build Client Successful!!");
			} else {
				System.out.println("Error with port");
			}
		} else
			System.out.println("Error with address");

	}
	
	public static void showInfor(){
		GameClientMode.showInfor();
	}

	public static void commTest() {
		// test mystical.com.communication mode test send and receive
		System.out.println("commTest start");
		if (clientStap == 2) {
			Scanner sc = new Scanner(System.in);
			while (true) {
				String com = sc.nextLine();
				udpComm.send(com);
				System.out.println("send message: " + com);
			}
		}
	}

	public static void messageRece(String mesId) {
		System.out.println("receive message");
		System.out.println(mesId + "##" + messBuff.getMessage(mesId));
	}
	public static int getClientStap(){
		return clientStap;
	}
}