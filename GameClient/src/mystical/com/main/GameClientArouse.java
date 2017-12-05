package mystical.com.main;

import mystical.com.messageBuffer.MessageArouse;

public class GameClientArouse extends MessageArouse {
	@Override
	public void Arouse(String mesId) {
		GameClient.messageRece(mesId);
	}

}
