package concurancy.src;

public class Threadpractice implements Runnable {

	private  volatile static int counter = 0;

	private volatile static int count = 10;

	public int getCounter() {
		return counter;
	}

//	public void checkFlag() {
//		
//		while(!flag) {
//				
//		}
//		System.out.println("flag was set" + flag);
//	}

	public synchronized void run() {
		System.out.println("Thread executed inside run method.");

		try {
			counter++;
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub
		Thread th1 = new Thread(new Threadpractice());
		th1.start();
		Thread th2 = new Thread(new Threadpractice());
		th2.start();

		// Thread th3 = Thread.ofVirtual().start(th1);
		// th3.start();

		th1.join();
		th2.join();

		System.out.println(
				"thread name " + Thread.currentThread().getName() + "counter" + new Threadpractice().getCounter());

		Thread readingThread = new Thread(() -> {
			while (true) {
				if (count == 11) {
					System.out.println("Counter:inside reading thread " + count);
					break;
				}
			}
		});

		Thread modifyingThread = new Thread(() -> {
			System.out.println("Modifying Counter from from writing thread " + count);
			count++;
			System.out.println("Final value of count from the modified thread " + count);
		});

		readingThread.start();
		modifyingThread.start();

		readingThread.join();
		modifyingThread.join();
		
		System.out.println("Main thread completed;");

	}

}
