package communication.tcpCommunication;

import java.io.IOException;
import java.io.InputStream;

public class TcpReceiveThread extends Thread {
	
	final private InputStream input;
	
	public TcpReceiveThread(InputStream input)
	{
		this.input = input;
	}
	
	@Override
	public void run()
	{
		byte[] b = new byte[2000];
		try {
			while(input.read(b) != 0)
			{
				System.out.println(new String(b));	
			}
			System.out.println("get message end");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
