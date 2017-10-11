package main;

import messageBuffer.MessageBuffer;

import communication.tcpCommunication.TcpCommunication;
import communication.udpCommunication.UdpCommunnication;

public class GameClient {
	final public static MessageBuffer messBuff = new MessageBuffer();
	final private static TcpCommunication tcpComm = new TcpCommunication();
	final private static UdpCommunnication udpComm = new UdpCommunnication();
	
	
	public static void main(String[] args) {
//		tcpComm.ClientBuild();
		udpComm.send("00000000hello is Server");
		udpComm.receive();
		while(true)
		{
			System.out.println(messBuff.getSize());
		}
	}
	
}
