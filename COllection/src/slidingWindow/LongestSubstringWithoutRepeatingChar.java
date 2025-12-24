package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {

	private static  int findLongestSubstringWithoutRepeatingChar(String str) {
		
		int i = 0;
		int j = 0;
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(j=0; j< str.length();j++) {
			char ch = str.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0) +1);
			while(map.get(ch) > 1) {
				char first = str.charAt(i);
				map.put(first, map.get(first) -1);
				i++;
			}
			max = Math.max(max, j-i+1);
		}
		

		return max;
	}

	public static void main(String[] args) {

		String str = "eghghhgg";
		System.out.println("Length of the LongestSubstringWithoutRepeatingChar->  " 
							+ findLongestSubstringWithoutRepeatingChar(str));

	}

}



