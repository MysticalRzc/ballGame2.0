package mystical.com.command;

import java.util.Scanner;

import mystical.com.main.GameServer;

public class serverCommand {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//test
		GameServer.BuildServerByDefault();
		GameServer.StartServer();
		//test
		while (true) {
			String com = sc.nextLine();
			com = com.toLowerCase();
			if (com.compareTo("buildserver") == 0) {
				GameServer.BuildServer();
			} else if (com.compareTo("startserver") == 0) {
				GameServer.StartServer();
			}else if(com.compareTo("commtest") == 0){
				GameServer.commTest();
			}
		}
	}
}
