package command;

import java.util.Scanner;

import org.junit.Test;

import main.GameClient;

public class clientCommand {
	final private static GameClient gameClient = new GameClient();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// test
		GameClient.buildClientByDefault();
		GameClient.StartClient();
		// test
		while (true) {
			String com = sc.nextLine();
			com = com.toLowerCase();
			if (com.compareTo("buildclient") == 0) {
				GameClient.buildClient();
			} else if (com.compareTo("startclient") == 0) {
				GameClient.StartClient();
			}else if(com.compareTo("showinfor")==0){
				GameClient.showInfor();
			}
			
			else if (com.compareTo("commtest") == 0) {
				GameClient.commTest();
			}
		}
	}
}