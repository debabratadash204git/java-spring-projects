package Java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//To run 5 independent tasks using CompletableFuture.allOf() and print a message once all are finished
public class CompletableFutureDemoUsingrunAsync {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService executor = Executors.newFixedThreadPool(3);

		CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
			try {
				System.out.println("Task 1 Started");
				Thread.sleep(200);
				System.out.println("Task 1 finished.");
			}
			catch(InterruptedException e) {Thread.currentThread().interrupt();}

		}, executor);

		CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
			try {
				System.out.println("Task 2 Started");
				Thread.sleep(200);
				System.out.println("Task 2 finished.");
			}
			catch(InterruptedException e) {Thread.currentThread().interrupt();}

		}, executor);

		CompletableFuture<Void> task3 = CompletableFuture.runAsync(() -> {
			try {
				System.out.println("Task 3 Started");
				Thread.sleep(200);
				System.out.println("Task 3 finished.");
			}
			catch(InterruptedException e) {Thread.currentThread().interrupt();}

		}, executor);

		CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1,task2,task3);

		allTasks.thenRun(() -> {System.out.println("All 3 tasks have finished!");});

		try {
			allTasks.join();
		}
		finally {
			executor.shutdown();
		}



	}

}
