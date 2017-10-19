package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import messageBuffer.MessageBuffer;

import communication.tcpCommunication.TcpCommunication;
import communication.udpCommunication.UdpCommunnication;

public class GameClient {
	final public static MessageBuffer messBuff = new MessageBuffer(
			new GameClientArouse());
	final private static TcpCommunication tcpComm = new TcpCommunication();
	final private static UdpCommunnication udpComm = new UdpCommunnication();
	private static boolean isUdpCommunication = true;

	private static String address = "127.0.0.1";
	private static int sendPort = 12999;
	private static int recePort = 12666;
	private static int clientStap = 1;// 记录客户端运行到第几步

	public static void StartClient() {
		if (clientStap == 1)
			if (isUdpCommunication) {
				udpComm.receive();
				clientStap = 2;
				while (true) {
					udpComm.send("UC0000newClient000" + address + "#"
							+ recePort);
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
			}
	}

	public static void buildClientByDefault() {
		udpComm.buildUdpCommunication(address, sendPort, recePort);
	}

	public static void buildClient() {
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

		System.out.println("Set sendPort and recePort");
		while (true) {
			String str1 = sc.nextLine();
			String str2 = sc.nextLine();
			try {
				sendPort = Integer.parseInt(str1);
				recePort = Integer.parseInt(str2);
				if ((sendPort < 0 || recePort >= 65535)
						&& (sendPort < 0 || recePort >= 65535))
					throw new Exception();
				break;
			} catch (Exception e) {
				System.out
						.println("Error port must between 0 and 65535,Please again");
			}
		}
		clientStap = 1;
		udpComm.buildUdpCommunication(address, sendPort, recePort);
		System.out.println("Build Server successful!!");
	}

}