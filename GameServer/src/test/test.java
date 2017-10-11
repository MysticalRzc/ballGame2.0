
package test;

import org.junit.Test;

import communication.udpCommunication.UdpCommunnication;

public class test {
//	public static void main(String[] args) throws InterruptedException
	
	@Test
	public void test() throws InterruptedException
	{
		UdpCommunnication udpCom = new UdpCommunnication();

		
//		udpCom.receive();
		udpCom.send("");
		udpCom.seTh.join();
//		udpCom.reTh.join();
		
	}
}
