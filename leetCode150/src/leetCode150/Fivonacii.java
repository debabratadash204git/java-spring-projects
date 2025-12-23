package leetCode150;

public class Fivonacii {
	
	public static int fivonacii(int num) {
		
		if (num <= 1)
			return num;
		return fivonacii(num -1) + fivonacii(num -2);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0 ;i < 10; i++) {
		System.out.print(fivonacii(i) + " ");
		}

	}

}


