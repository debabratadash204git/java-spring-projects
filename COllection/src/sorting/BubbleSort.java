package sorting;

import java.util.Arrays;

public class BubbleSort {

	void bubbleSort(int[] arr) {

		int n = arr.length;
		for (int i =0; i < n-1; i++) {
			for(int j = 0; j < n-i-1 ; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BubbleSort bs = new BubbleSort();
		int[] data = { -2, 45, 0, 11, -9 };
		bs.bubbleSort(data);
		System.out.println("Sorted Array in Ascending Order:");
	    System.out.println(Arrays.toString(data));

	}

}
