package concurancy;

import java.util.*;

public class SharedBuffer {
	
	private final Queue<Integer> queue = new LinkedList<>();
	
	private final int capacity = 10;
	
	public synchronized void producer(int value) throws InterruptedException {
		
		while(queue.size() == capacity) {
			wait();
		}
		queue.add(value);
		System.out.println("Produced value" + value);
		notify();
		
	}
	
	public synchronized int consumer() throws InterruptedException {
		
		while(queue.isEmpty()) {
			wait();
		}
		int value = queue.poll();
		System.out.println("Consumed value" + value);
		notify();
		
		return value;
	}


}
