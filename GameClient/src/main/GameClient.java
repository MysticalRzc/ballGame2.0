package main;

import messageBuffer.MessageBuffer;

import communication.tcpCommunication.TcpCommunication;
import communication.udpCommunication.UdpCommunnication;

public class GameClient {
	final public static MessageBuffer messBuff = new MessageBuffer();
	final private static TcpCommunication tcpComm = new TcpCommunication();
	final private static UdpCommunnication udpComm = new UdpCommunnication();
	
	public static void StartClient()
	{
		
	}

}
