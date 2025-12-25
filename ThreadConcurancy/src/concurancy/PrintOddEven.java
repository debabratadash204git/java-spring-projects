package concurancy;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.lang.Runnable;
//Let’s solve the Odd–Even number printing problem using ExecutorService and CyclicBarrier — 
//this is the kind of twist you’ll see in senior-level interviews, 
//where they want to check if you can leverage high-level concurrency utilities instead of manual wait()/notify().

public class PrintOddEven {
	private static int number = 1;
	// private static final CyclicBarrier barrier = new CyclicBarrier(2);

	private static final int limit = 10;
	private static final CyclicBarrier barrier = new CyclicBarrier(2);
	
	private static Runnable eventask()
	{
		return ()-> {
			try {
				while(number <= limit) {
					if(number % 2 == 0) {
						System.out.println("Even thread -> " + number);
						number++;
					}
					barrier.await();
				}
			
			}
			catch(InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		
		Runnable oddtask = () -> {
			
			try {
				while(number <= limit) {
					if(number % 2 == 1) {
						System.out.println("Odd thread -> " + number);
						number++;
					}
					barrier.await();
				}
				
				
			}
			catch(InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			
		};
		
		
		executor.submit(eventask());
		executor.submit(oddtask);
		
		executor.shutdown();
	}

}
