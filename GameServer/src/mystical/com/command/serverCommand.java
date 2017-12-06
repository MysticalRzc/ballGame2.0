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
			switch(com)
			{
				case "buildserver":
					GameServer.BuildServer();
					break;
				case "buildserverbydefault":
					GameServer.BuildServerByDefault();
					break;
				case "startserver":
					GameServer.StartServer();
					break;
				case "commtest":
					GameServer.commTest();
					break;
				default:
					System.out.println("Null Commend");
			}
		}
	}
}
