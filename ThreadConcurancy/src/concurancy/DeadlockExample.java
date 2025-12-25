package concurancy;

public class DeadlockExample {

	public static void main(String[] args) {
		
		String obj1 = "ABC";
		String obj2 = "XYZ";
		
		new Thread(()-> {
				synchronized(obj1){
					System.out.println("Current Thread acquired the lock on object1---" + Thread.currentThread().getName());
					
					try {
						Thread.sleep(500);
					}
					catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					System.out.println("Current Thread acquired the lock on object2---" + Thread.currentThread().getName());
					synchronized (obj2) {
						System.out.println(Thread.currentThread().getName() + " has acquired lock on obj2");
						System.out.println(Thread.currentThread().getName() + " task complete");
					}
						
					}
				}
			).start();;
			
			new Thread(()-> {
					synchronized (obj1){
						System.out.println("Current Thread acquired the lock on object1---" + Thread.currentThread().getName());
						
						try {
							Thread.sleep(500);
						}
						catch(InterruptedException e) {
							Thread.currentThread().interrupt();
						}
						System.out.println("Current Thread acquired the lock on object2---" + Thread.currentThread().getName());
						synchronized (obj2) {
							System.out.println(Thread.currentThread().getName() + " has acquired lock on obj2");
							System.out.println(Thread.currentThread().getName() + " task complete");
						}
							
						}
					}
				).start();
				
		}

	}

