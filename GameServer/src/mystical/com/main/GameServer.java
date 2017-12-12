package mystical.com.main;

import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mystical.com.messageBuffer.MessageBuffer;
import mystical.com.ClientThread.ClientThread;

import mystical.com.communication.tcpCommunication.TcpCommunication;
import mystical.com.communication.udpCommunication.UdpCommunnication;
import mystical.com.utill.Utill;

public class GameServer {

    final public static MessageBuffer messBuff = new MessageBuffer(
            new GameServerArouse());
    final private static TcpCommunication tcpComm = new TcpCommunication();
    final private static UdpCommunnication udpComm = new UdpCommunnication();
    private static boolean isUdpCommunication = true;

    private static int serverStap = 0; // 记录服务器运行到第几步

    public static void StartServer() {
        if (serverStap == 1) {
            udpComm.receive();
            serverStap = 2;
            System.out.println("GameServer start successful");
        } else
            System.out.println("GameServer start failed");
    }

    public static void BuildServerByDefault() {
        System.out.println("Build server by default start ");
        if (udpComm.buildUdpCommunication(GameServerMode.getAddress(), GameServerMode.getSendPort(), GameServerMode.getRecePort()))
            serverStap = 1;
    }

    public static void BuildServer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Set address");

        if (GameServerMode.setAddress(sc.nextLine())) {
            if (GameServerMode.setRecePort(sc.nextInt())
                    && GameServerMode.setSendPort(sc.nextInt())) {
                udpComm.buildUdpCommunication(GameServerMode.getAddress(),
                        GameServerMode.getSendPort(),
                        GameServerMode.getRecePort());
                serverStap = 1;
                System.out.println("Build Server successful!!");
            } else {
                System.out.println("Error with port");
            }
        } else
            System.out.println("Error with address");
    }

    public static void BuildClientThread(Socket socket) {
        ClientThread clientTh = new ClientThread(socket);
    }

    public static boolean BuildClientThread() {
//		mystical.com.ClientThread clientTh = new mystical.com.ClientThread();
        String message = messBuff.getMessage("U7T#+" + GameServerMode.getServerId() + "+getCliId");
        int port = 0001;
        String[] mes = message.split("#");
        if (Utill.isAddress(mes[0]) && Utill.isPort(mes[1])) {
            port = Integer.parseInt(mes[1]);
            int clientId = GameServerMode.getgIdManage().getClientId(mes[0], port);
        }
    }

    public static void commTest() {
        // test mystical.com.communication mode test send and receive
        System.out.println("commTest start");
        if (serverStap == 2) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                String com = sc.nextLine();
                udpComm.send(com);
                System.out.println("send message: " + com);
            }
        }
    }

    public static void messageRece(String mesId) {
        System.out.println("receive message");
        System.out.println(mesId + " : " + messBuff.getMessage(mesId));
    }

    public static int getServerStap() {
        return serverStap;
    }
}
