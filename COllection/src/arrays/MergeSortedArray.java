package arrays;

import java.util.*;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1 = {1,2,2,3,4, 5,6,8};
		int[] arr2 = {2,5,6};
		int len1 = arr1.length;
		int len2 = arr2.length;
		
		mergeSortedArry(arr1,arr2,len1,len2);
		
		removeDuplicateElement(arr1);

	}

	private static void removeDuplicateElement(int[] arr1) {
		
		Set<Integer> set = new HashSet<>();
		
		for(int x : arr1)
			set.add(x);
			
		System.out.println("size ===="+ set.size());
		
		  int[] result = new int[set.size()];
         int i = 0;
         for(int x :set)
             result[i++] = x;
		System.out.print(Arrays.toString(result));
		
	}

	private static void mergeSortedArry(int[] arr1, int[] arr2, int len1, int len2) {
		
		int[] merge = new int[len1 +len2];
		
		int i =0, j=0, k=0;
		
		while(i < len1 && j<len2) {
			
			if(arr1[i] <= arr2[j])
				merge[k++] = arr1[i++];
			else
				merge[k++] = arr2[j++];
		}
		
		while(i < len1) {
			merge[k++] = arr1[i++];
		}
		while(j < len2) {
			merge[k++] = arr2[j++];
		}
		
		for(int element: merge)
			System.out.print(element + " ");
		
		
	}

}
