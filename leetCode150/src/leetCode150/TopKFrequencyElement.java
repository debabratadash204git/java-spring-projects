package leetCode150;

import java.util.*;
import java.util.Map.Entry;

public class TopKFrequencyElement {
	
	public static int[] topKFreqthroughbruteforce(int[] arr, int k) {
		
		HashMap<Integer,Integer> freq = new HashMap<>();
		for (int ele: arr)
			freq.put(ele, freq.getOrDefault(ele, 0)+1);
		
		List<int[]> freqlist = new ArrayList<>();
		
		  for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			  freqlist.add(new int[] {entry.getValue(), entry.getKey()});
	        }
//		for(int key :freq.keySet()) {		
//			int frequency = freq.get(key);
//			freqlist.add(new int[frequency]);
//		}
		
		freqlist.sort((a,b)->b[0]-a[0]);
		int[] res = new int[k];
		
		for (int i=0;i<k;i++ ) {
			res[i]= freqlist.get(i)[1];
		}
		
		return res;
		
	}
	
	
	
	
	public static int[] topKFreqthroughBocketSort(int[] arr, int k) {
		
		HashMap<Integer,Integer> freq = new HashMap<>();
		
		List<Integer>[] bucket = new List[arr.length+1];
		
		for(int i = 0; i< bucket.length ;i++) {
			bucket[i] = new ArrayList<>();
		}
		
		for (int ele: arr)
			freq.put(ele, freq.getOrDefault(ele, 0)+1);
		
		for(int key :freq.keySet()) {		
			int frequency = freq.get(key);
			bucket[frequency].add(key);
		}
		
//		for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
//			
//			bucket[entry.getValue()].add(entry.getKey());
//			
//		}
		int[] res = new int[k];
		int index = 0;
		
		for(int i = bucket.length -1; i>0 & index<k ;i--) {
			
			for(int data:bucket[i]) {
				res[index++] = data;
				if(index== k)
					return res;
			}
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
	     int k = 2;
	     //Time and Space complexity O(n)
	     int[] res = topKFreqthroughBocketSort(arr,k);
	     for (int val : res)
	    	 System.out.println(val + " ");
	     
	     int[] output = topKFreqthroughbruteforce(arr,k);
	     for (int val : output)
	    	 System.out.println(val + " ");

	}

}
