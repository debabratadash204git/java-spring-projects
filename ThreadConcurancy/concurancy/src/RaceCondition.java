package concurancy.src;

public class RaceCondition implements Runnable {

	private volatile int count;
	

	@Override
	public  void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(300);
				count++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public int getCount() {
		return count;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		RaceCondition rc = new RaceCondition();

		Thread t1 = new Thread(rc);

		Thread t2 = new Thread(rc);
		t1.start();
		t2.start();

		t1.join();
		t2.join();
		
		System.out.println("value of count" + rc.getCount());

	}

}
