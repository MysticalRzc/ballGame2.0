import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends Thread{

	@Override
	public void run()
	{
		try {
			ServerSocket ss = new ServerSocket(30000);
			Socket s = ss.accept();
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println(" hello is server");
			
			ps.close();
			s.close();
			ss.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
