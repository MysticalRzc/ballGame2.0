

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import messageBuffer.MessageBuffer;

import communication.udpCommunication.UdpCommunnication;



public class test {

	// public static void main(String[] args) throws InterruptedException

	// @Test
	public void addressTest() {

		// String address="127.0.0.1";
		//
		String regEx = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
				+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		// Pattern pattern = Pattern.compile(regEx);
		//
		// System.out.println(pattern.matches(address, regEx));
		// if (pattern.matches(address, regEx)) {
		// System.out.println("Yes");
		// }
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher("127.0.0.255");
		System.out.println(m.find());// ����true

	}

	// @Test
	public void testMessageBuffer() throws InterruptedException {
		MessageBuffer mesBuf = new MessageBuffer();
		UdpCommunnication udpCom = new UdpCommunnication();

		// udpCom.send("");
		udpCom.receive();

		Thread.sleep(5000);

		System.out.println(mesBuf.getSize());
		// mesBuf.setMessage("ball", "ballMessage");
		// System.out.println(mesBuf.getMessage("ball"));
	}

	// @Test
	public void testUdp() throws InterruptedException {
		UdpCommunnication udpCom = new UdpCommunnication();

		udpCom.receive();
		udpCom.send("");
		Thread.sleep(5000);
	}
}