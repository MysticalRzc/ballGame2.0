package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameClientMode {
	// Ĭ�� default ֧��ͬһ���µ�����Ϣ�ɼ�
	private static String address = "127.0.0.1";
	private static int sendPort = 12999;
	private static int recePort = 12666;
	
	private static String serverId = "0001";
	
	private static int clientId = -1;
	private static String userName;

	private static int tableId;

	static String getAddress() {
		return address;
	}

	static boolean setAddress(String address) {
		String regEx = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(address);
		if (m.find())
			GameClientMode.address = address;
		else
			return false;
		return true;
	}

	static int getSendPort() {
		return sendPort;
	}

	static boolean setSendPort(int sendPort) {
		if (sendPort < 0 || recePort >= 65535) {
			GameClientMode.sendPort = sendPort;
			return true;
		} else
			return false;
	}

	static int getRecePort() {
		return recePort;
	}

	static boolean setRecePort(int recePort) {
		if (sendPort < 0 || recePort >= 65535) {
			GameClientMode.recePort = recePort;
			return true;
		} else
			return false;
	}

	static int getClientId() {
		return clientId;
	}

	static void setClientId(int clientId) {
		GameClientMode.clientId = clientId;
	}

	static String getUserName() {
		return userName;
	}

	static void setUserName(String userName) {
		GameClientMode.userName = userName;
	}

	static int getTableId() {
		return tableId;
	}

	static void setTableId(int tableId) {
		GameClientMode.tableId = tableId;
	}

	static String getServerId() {
		return serverId;
	}

	static void setServerId(String serverId) {
		GameClientMode.serverId = serverId;
	}

	public static void showInfor() {
		System.out
				.println("====================ClientInfor====================");
		System.out.println("address: " + address);
		System.out.print("sendPort: " + sendPort);
		System.out.println(" recePort: " + recePort);
		System.out.println("clientId: "+clientId +" serverId: "+serverId + " tableId: "+tableId);
		System.out.println("userName: "+userName);
	}
}