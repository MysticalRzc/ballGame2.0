package main;

import messageBuffer.MessageArouse;

public class GameServerArouse extends MessageArouse {

	@Override
	public void Arouse(String mesId) {
		GameServer.messageRece(mesId);
//		if(mesId.compareTo("u_Client") == 0)
//			GameServer.BuildClientThread();
	}

}
