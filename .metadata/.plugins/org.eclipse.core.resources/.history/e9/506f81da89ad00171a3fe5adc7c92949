import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client extends Thread{
	@Override
	public void run()
	{
		try {
			Socket socket = new Socket("127.0.0.1",30000);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream())
					);
			String line = br.readLine();
			System.out.println("from server"+line);
			br.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
		}
		
	}
}
