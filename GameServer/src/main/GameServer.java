package main;

import java.net.Socket;

import communication.tcpCommunication.TcpCommunication;
import communication.udpCommunication.UdpCommunnication;

import messageBuffer.MessageBuffer;
import ClientThread.ClientThread;

public class GameServer {
	final public static MessageBuffer messBuff = new MessageBuffer();
	final private static TcpCommunication tcpComm = new TcpCommunication();
	final private static UdpCommunnication udpComm = new UdpCommunnication();
	
	public static void main(String[] args) {
//		tcpComm.ServerBuild();
		udpComm.send("00000000hello is Server");
		udpComm.receive();
		while(true)
		{
			System.out.println(messBuff.getSize());
		}
	}
	
	public static void BuildClientThread(Socket socket){
		ClientThread clientTh= new ClientThread(socket);
	}
}