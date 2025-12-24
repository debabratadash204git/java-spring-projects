package arrays;

import java.util.Arrays;

//To find the difference in index between a current number 
//and the next smallest number in an array in Java, 
//you can iterate through the array and for each element, 
//find the next smallest number and its index.


public class NextSmallestindexDifference {
	
	public static int[] FindNextSmallestindexDifference(int[] arr) {
		if(arr.length == 0)
			return new int[0];
		int len = arr.length;
		int[] output = new int[len];
		int nextSmallestvalue = Integer.MAX_VALUE;
		int nextIndex = -1;
		for(int i = 0 ;i < len ; i++) 
		{
			int currItem = arr[i];
			for(int j = i+1;j<len ; j++) 
			{
				if(currItem > arr[j] &&  nextSmallestvalue > arr[j]) {
					nextSmallestvalue = arr[j];
					nextIndex = j;
				}
			}
			
			if(nextIndex != -1)
				output[i] = nextIndex -i;
			else
				output[i] = -1;
		}
		return output;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {5,9,2,3,4,1};
		int[] result = FindNextSmallestindexDifference(arr);
			System.out.println("result array = " + Arrays.toString(result));

	}

}
