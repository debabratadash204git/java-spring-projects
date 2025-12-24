package general;

import java.util.Arrays;

public class SortArrayByParity {

	public static int[] sortArrayParity(int[] arr) {

		int left = 0;
		int right = arr.length -1;

		while(left < right) {

			if(arr[left] %2 == 0) {
				left++;
			} else if(arr[right] %2 != 0) {
				right--;
			} else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}


		return arr;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {6,3,5,4,2,9,3,7,1,13,14,76};

		int[] output = sortArrayParity(arr);
		System.out.println("Sorted Parity array" + Arrays.toString(output));



	}

}
