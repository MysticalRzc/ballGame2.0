
public class main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Client c = new Client();
		Server s = new Server();
		c.start();
		s.start();
		c.join();
		s.join();
	}

}
