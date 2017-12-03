package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clientManage.GameIdManage;

public class GameServerMode {
	private static String address = "127.0.0.1";
	private static int sendPort = 12666;
	private static int recePort = 12999;

	private static int serverId;
	private static String serverName;
	
	private static GameIdManage gIdManage = new GameIdManage();  // clientNum  clientId

	static String getAddress() {
		return address;
	}

	static boolean setAddress(String address) {
		String regEx = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(address);
		if (m.find())
			GameServerMode.address = address;
		else
			return false;
		return true;
	}

	static int getSendPort() {
		return sendPort;
	}

	static boolean setSendPort(int sendPort) {
		if (sendPort < 0 || recePort >= 65535) {
			GameServerMode.sendPort = sendPort;
			return true;
		} else
			return false;
	}

	static int getRecePort() {
		return recePort;
	}

	static boolean setRecePort(int recePort) {
		if (sendPort < 0 || recePort >= 65535) {
			GameServerMode.recePort = recePort;
			return true;
		} else
			return false;
	}

	static int getServerId() {
		return serverId;
	}

	static void setServerId(int serverId) {
		GameServerMode.serverId = serverId;
	}

	static String getServerName() {
		return serverName;
	}

	static void setServerName(String serverName) {
		GameServerMode.serverName = serverName;
	}

	static GameIdManage getgIdManage() {
		return gIdManage;
	}

	public static void showInfor() {
		System.out.println("====================ClientInfor====================");
		System.out.println("address: " + address);
		System.out.print("sendPort: " + sendPort);
		System.out.println(" recePort: " + recePort);
		gIdManage.showInfor();
	}
}
