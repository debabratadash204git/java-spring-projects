package leetCode150;

import java.util.Arrays;

public class ProductOfArray {
	
	public static int[] productofArrayNumberUsingbruteForce(int[] arr) {
		if (arr.length == 0)
			return new int[0];

		int[] result = new int[arr.length];
		Arrays.fill(result, 1);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {

				if (i != j)
					result[i] *= arr[j];

			}
		}
		return result;
	}
	
	public static int[] productofArrayNumberUsingSuffixArray(int[] arr) {
		
		if (arr.length == 0)
			return new int[0];
		
		int prefix = 1, postfix = 1;
		int[] result = new int[arr.length];
		Arrays.fill(result, 1);
		
		for(int i = 0 ; i< arr.length ; i++) {
			result[i] = prefix;
			prefix = arr[i]* prefix;
			
		}
		
		for(int i = arr.length -1; i>=0 ; i--) {
			result[i] = result[i]*postfix;
			postfix = postfix*arr[i];
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,4,5,6,3};
		int[] output = productofArrayNumberUsingbruteForce(arr);
		System.out.println(Arrays.toString(output));
		
		int[] result = productofArrayNumberUsingSuffixArray(arr);
		System.out.println(Arrays.toString(result));
		

	}

}
