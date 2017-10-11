package communication.udpCommunication;


public class UdpCommunnication{
	
	public Thread reTh;
	public Thread seTh;
	
	public UdpCommunnication() {
		super();
		this.reTh = new Thread(new UdpReceiveThread(),"receiveThread");
		this.seTh = new Thread(new UdpSendThread("127.0.0.1", 30000),"sendThread");
	}
	
	synchronized public void receive(){
		System.out.println("receive is starting");
		reTh.start();
		System.out.println("receive is started");
	}
	
	synchronized public void send(String str)
	{
		System.out.println("send is starting");
		seTh.start();
		System.out.println("send is started");
	}
}
