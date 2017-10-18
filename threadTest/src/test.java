public class test {
	public static Object lock = new Object();
	public static boolean run;

	public static void main(String[] args) throws InterruptedException {
		thread();
		run = true;
		Thread.sleep(200);
		run = false;
		Thread.sleep(200);
		run = true;
		synchronized (lock) {
			lock.notify();			
		}
	}

	public static void thread() {
		Thread th = new Thread() {
			@Override
			public void run() {
				synchronized (lock) {
					while (true) {
						if (run)
							System.out.println(">");
						else
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			
		};
		th.start();
	}

}