
package test;

import messageBuffer.MessageBuffer;

import org.junit.Test;

import communication.udpCommunication.UdpCommunnication;

public class test {
//	public static void main(String[] args) throws InterruptedException
	
//	@Test
	public void testMessageBuffer() throws InterruptedException
	{
		MessageBuffer mesBuf  = new MessageBuffer();
		UdpCommunnication udpCom = new UdpCommunnication();
		
		udpCom.send("");
		//udpCom.receive();
		
		Thread.sleep(5000);
		
		System.out.println(mesBuf.getSize());
//		mesBuf.setMessage("ball", "ballMessage");
//		System.out.println(mesBuf.getMessage("ball"));
	}
	
//	@Test
	public void testUdp() throws InterruptedException
	{
		UdpCommunnication udpCom = new UdpCommunnication();

		udpCom.receive();
		udpCom.send("");
		Thread.sleep(5000);
	}
}
