package sorting;

import java.util.Arrays;

public class MergeSort {

	public void merge(int[] arr, int left, int mid, int right) {

	}


	void mergeSort(int[] arr,int lo,int hi) {

		if(lo < hi) {
			int mid = lo+hi/2;
			mergeSort(arr,lo,mid);
			mergeSort(arr,mid+1,hi);
			merge(arr,lo,mid,hi);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort ms = new MergeSort();
		int[] data = { -2, 45, 0, 11, -9 };
		ms.mergeSort(data,0,data.length-1);
		System.out.println("Sorted Array in Ascending Order:");
	    System.out.println(Arrays.toString(data));

	}

}
