package mystical.com.communication.tcpCommunication;

import java.io.BufferedReader;
import java.io.IOException;

public class TcpReceiveThread extends Thread {
	
	final private BufferedReader bufferedReader;
	
	public TcpReceiveThread(BufferedReader bufferedReader)
	{
		this.bufferedReader = bufferedReader;
	}
	
	@Override
	public void run()
	{
		String message;
		try {
			while((message = bufferedReader.readLine()) != null)
			{
				System.out.println(message);
			}
			System.out.println("get message end");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
