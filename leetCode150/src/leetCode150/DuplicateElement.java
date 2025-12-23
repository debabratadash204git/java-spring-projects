package leetCode150;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,4,5,6};
		boolean result = findDuplicateElement(arr);
		if(result)
			System.out.println("Duplicate found");
		else
		System.out.println("Duplicate Not found");
	}

	private static Boolean findDuplicateElement(int[] arr) {
		// TODO Auto-generated method stub
		if(arr.length == 0)
			return false;
		
		Set<Integer> hs = new HashSet<Integer>();
		
		for(int elem : arr) {
			if(hs.contains(elem))
				return true;
			hs.add(elem);
		}
		return false;
	}

}
