package main;

import messageBuffer.MessageArouse;

public class GameServerArouse extends MessageArouse {

	@Override
	public void Arouse(String mesId) {
		GameServer.messageRece(mesId);
		if(mesId.compareTo("U7T#0001getCliId") == 0)
			GameServer.BuildClientThread();
	}
}
