package command;

import java.util.Scanner;

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
            switch (com) {
                case "buildclient":
                    GameClient.buildClient();
                    break;
                case "startclient":
                    GameClient.StartClient();
                    break;
                case "showinfor":
                    GameClient.showInfor();
                    break;
                case "commtest":
                    GameClient.commTest();
                    break;
                default:
                    System.out.println("commend noFound");
//                if (com.compareTo("buildclient") == 0) {
//                    GameClient.buildClient();
//                } else if (com.compareTo("startclient") == 0) {
//                    GameClient.StartClient();
//                } else if (com.compareTo("showinfor") == 0) {
//                    GameClient.showInfor();
//                } else if (com.compareTo("commtest") == 0) {
//                    GameClient.commTest();
//                }
            }

        }
    }
}