package main;

import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import messageBuffer.MessageBuffer;
import ClientThread.ClientThread;

import communication.tcpCommunication.TcpCommunication;
import communication.udpCommunication.UdpCommunnication;

public class GameServer {

	final public static MessageBuffer messBuff =  new MessageBuffer(new GameServerArouse());
	final private static TcpCommunication tcpComm = new TcpCommunication();
	final private static UdpCommunnication udpComm = new UdpCommunnication();
	private static boolean isUdpCommunication = true;

	
	private static String address = null;
	private static int port = 12633;
	private static int serverStap = 0; // 记录服务器运行到第几步
	
	public static void StartServer() {
		if (serverStap == 1) {
			if (isUdpCommunication) {
				udpComm.buildUdpCommunication(address, port);
				udpComm.receive();
				Thread th = new Thread() {
					@Override
					public void run() {
						while (true) {
							System.out.println(">");
						}
					}
				};
				th.start();
			}
		}
		else
			System.out.println("server is not build");
	}

	public static void BuildServer() {
		String regEx = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		Pattern p = Pattern.compile(regEx);

		Scanner sc = new Scanner(System.in);
		System.out.println("Set address");

		while ((address = sc.nextLine()) != null) {
			Matcher m = p.matcher(address);
			if (m.find()) {
				break;
			}
			System.out.println("Error address Please Check and set again");
		}

		System.out.println("Set port");
		while (true) {
			String str = sc.nextLine();

			try {
				port = Integer.parseInt(str);
				if (port < 0 || port >= 65535)
					throw new Exception();
				break;
			} catch (Exception e) {
				System.out
						.println("Error port must between 0 and 65535,Please again");
			}
		}
		serverStap=1;
		System.out.println("Build Server successful!!");
	}

	public static void BuildClientThread(Socket socket) {
		ClientThread clientTh = new ClientThread(socket);
	}
	public static void BuildClientThread() {
		ClientThread clientTh = new ClientThread();
	}
}
