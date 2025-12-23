package leetCode150;

public class FindMinElementInARotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,6,7,8,9,10,2,3,4};
		
		int element = searchMinElement(arr);
		System.out.print("Search Minimum Element=== " + element);

	}

	private static int searchMinElement(int[] arr) {
		int lo = 0;
		int hi =  arr.length -1;
		while(lo < hi)
		{
			int mid = (lo + hi)/2;
			if(arr[mid] > arr[hi])
				lo = mid+1;
			else
				hi = mid;
		}
		
		return arr[lo];
	}

}
