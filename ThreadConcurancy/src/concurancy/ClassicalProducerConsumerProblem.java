package concurancy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ClassicalProducerConsumerProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Use BlckingQueue instead of wait and notify all
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		
		//SharedBuffer sb = new SharedBuffer();
		
		Runnable producer = ()->{
			
			int i = 0;
			try {
			while(i<=5) {
				//sb.producer(i++);
				queue.put(i);
				System.out.println("Produced: " + i);
				//i++;
				Thread.sleep(300);
				i++;
				}
			}
			
			catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
		};
		
		Runnable consumer = ()->{
			try {
				while(true) {
					//sb.consumer();
					int value = queue.take();
					System.out.println("consumed value = " + value);
					Thread.sleep(500);
					}
				}
				catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			
		};
		
//		new Thread(producer).start();
//		new Thread(consumer).start();
		
		//start multiple producer
		for (int i = 1; i <= 2; i++) {
            new Thread(producer, "Producer-" + i).start();
        }

        // Start multiple consumers
        for (int i = 1; i <= 3; i++) {
            new Thread(consumer, "Consumer-" + i).start();
        }
	}

}
