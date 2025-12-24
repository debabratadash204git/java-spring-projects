package general;

public class PrimeNumber {

	private static void isPrime(int num) {
		if(num <= 1) {
			return ;
		}

		for(int i = 2; i <= Math.sqrt(num); i++) {

			if(num% i == 0) {
				System.out.println(num + "is not a prime number");
			} else {
				System.out.println(num + "is a prime number");
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int num = 11;
		isPrime(6);

	}

}
