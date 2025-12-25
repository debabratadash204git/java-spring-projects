package concurancy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threadplay {
	private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
	
	private static final CyclicBarrier barrier = new CyclicBarrier(2);
	
	public void produce() throws InterruptedException, BrokenBarrierException{
		int value = 0;
		while(value < 10) {
			queue.put(value);
			System.out.println("produced" + value);
			//Thread.sleep(300);
			barrier.await();
			value++;
		}
	}
	
	public void consume() throws InterruptedException, BrokenBarrierException{
		while(true) {
			int value = queue.take();
			System.out.println("consumed" + value);
//			Thread.sleep(500);
			barrier.await();
		}
	}
	public static void main(String[] args) {
		
		Threadplay tp = new Threadplay();
		new Thread(()-> {
			try {
				tp.produce();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		
		new Thread(()-> {
			try {
				tp.consume();
			} catch (InterruptedException  | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();

//		Runnable r1 = () -> {
//			int value = 0;
//			while (value < 10) {
//				try {
//					queue.put(value);
//					System.out.println("Produced" + value);
//					value++;
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
//
//		Runnable r2 = () -> {
//			while (true) {
//				try {
//					int value = queue.take();
//					System.out.println("consumed" + value);
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			}
//		};
//
//		// TODO Auto-generated method stub
//
//		ExecutorService ex = Executors.newFixedThreadPool(2);
//		ex.submit(r1);
//		ex.submit(r2);
//		ex.shutdown();

	}

}
