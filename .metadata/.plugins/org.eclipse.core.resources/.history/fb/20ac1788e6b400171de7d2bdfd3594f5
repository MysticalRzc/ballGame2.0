package main;

import messageBuffer.MessageArouse;

public class GameServerArouse extends MessageArouse {

	@Override
	public void Arouse(String mesId) {
		if(mesId.compareTo("u_Client") == 0)
			GameServer.BuildClientThread();
	}

}
