package general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//One String permutation to another String
//One string anagram to another String
public class StringPermutaion {
	
	public static boolean findPermutationUsingSorting(String str1, String str2) {
		
		if(str1.length() != str2.length())
			return false;
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		if(Arrays.equals(arr1,arr2))
			return true;
		else
			return false;
	}
	
	public static boolean findPermutationUsingHashMap(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		
		Map<Character,Integer> charMap = new HashMap<>();
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		for(char ch :arr1) {
			charMap.put(ch, charMap.getOrDefault(ch, 0)+1);
		}
		
		for(char ch :arr2) {
			if(!charMap.containsKey(ch) || charMap.get(ch) == 0)
				return false;
			charMap.put(ch, charMap.get(ch)-1);
		}
		
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String input1 = "hello";
		String input2 = "elooh";
		
		System.out.println("String one permutaion of string 2 is    " + findPermutationUsingSorting(input1,input2));
		
		System.out.println("String one permutaion of string 2 is    " + findPermutationUsingHashMap(input1,input2));
	}

}
