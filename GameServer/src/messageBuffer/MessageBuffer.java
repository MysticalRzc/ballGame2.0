package messageBuffer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MessageBuffer {
	/**
	 * LinkedBlockingQueue 后续需要把Queue切换成这个阻塞队列
	 */
	final private Map<String, Queue> messBuffer = new HashMap<String, Queue>();
	final private Queue<String> mesIdQue = new LinkedList<String>();
	private MessageArouse messArouse;
	private Thread mesListener;

	public MessageBuffer() {
		messageListener();
	}

	public MessageBuffer(MessageArouse messArouse) {
		this.messArouse = messArouse;
		messageListener();
	}

	public int getSize() {
		return messBuffer.size();
	}

	/**
	 * 消息队列监听器 当message队列创建好之后便启动这个监听器，导尿管队列没有消息的时候监听器将会休息50毫秒， 如果有消息变回一直启动唤醒操作。
	 */
	public void messageListener() {
		mesListener = new Thread() {
			@Override
			public void run() {
				synchronized (mesIdQue) {
					System.out.println("Message listen is running");
					while (!this.isInterrupted()) {
						if (!mesIdQue.isEmpty()) {
							{
								messArouse.Arouse(mesIdQue.poll());
								try {
									Thread.sleep(1);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
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
		mesListener.start();
	}

	public void mesListenerStop() {
		if (mesListener != null && mesListener.isAlive()) {
			mesListener.interrupt();
		}
	}

	public void setMessage(String mesId, String message) {
		// System.out.println("MessageBuffer receive： " + message);
		if (!messBuffer.containsKey(mesId)) {
			messBuffer.put(mesId, new LinkedList<String>());
		}
		mesIdQue.add(mesId);
		messBuffer.get(mesId).add(message);
		System.out.println("new message>>"+mesIdQue.size());
	}

	public String getMessage(String mesId) {
		if (!messBuffer.containsKey(mesId))
			return null;
		return (String) messBuffer.get(mesId).poll();
	}
}