package Java8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		CompletableFuture<String> dbcall = CompletableFuture.supplyAsync(()->{
			try {Thread.sleep(500);}
			catch(Exception e) {}
			return "DB call invoked";
		});

		CompletableFuture<String> serviceCall = CompletableFuture.supplyAsync(() -> {
			try {Thread.sleep(800);}
			catch(Exception e) {}
			return "Service call invoked";
		});

		CompletableFuture combine = dbcall.thenCombine(serviceCall, (db, service) -> db + " + " + service);

		System.out.println(combine.get());

	}

}
