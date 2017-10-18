package messageBuffer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MessageBuffer {
	final private Map<String, Queue> messBuffer = new HashMap<String, Queue>();
	final private Queue<String> mesIdQue = new LinkedList<String>();
	private MessageArouse messArouse;

	public MessageBuffer(MessageArouse messArouse) {
		this.messArouse = messArouse;
	}

	public int getSize() {
		return messBuffer.size();
	}

	/**
	 * 消息队列监听器
	 * 当message队列创建好之后便启动这个监听器，导尿管队列没有消息的时候监听器将会休息50毫秒，
	 * 如果有消息变回一直启动唤醒操作。
	 */
	public void messageListener() {
		Thread mesListener = new Thread() {
			@Override
			public void run() {
				synchronized (mesIdQue) {
					while (true) {
						if (!mesIdQue.isEmpty()) {
							messArouse.Arouse(mesIdQue.poll());
						} else {
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		};
	}

	public void setMessage(String mesId, String message) {
		System.out.println("MessageBuffer receive： " + message);
		if (!messBuffer.containsKey(mesId)) {
			messBuffer.put(mesId, new LinkedList<String>());
		}
		mesIdQue.add(mesId);
		messBuffer.get(mesId).add(message);
	}

	public String getMessage(String mesId) {
		String message;

		if (!messBuffer.containsKey(mesId))
			return null;
		message = (String) messBuffer.get(mesId).poll();
		return message;
	}
}