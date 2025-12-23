package leetCode150;
import java.util.*;

public class GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 String[] input = {"eat","tea","tan","ate","nat","bat","aet"};
		 
		 List<List<String>> groups = groupAnagram(input);
		 System.out.println(groups);

	}

	private static List<List<String>> groupAnagram(String[] input) {
		
		Map<String, List<String>> groupMap = new HashMap<>();
		
		for(String str:input) {
			int[] frequency = new int[26];
			for(char c : str.toCharArray()) {
				frequency[c - 'a']++;
			}
		String sortedStr = Arrays.toString(frequency);
		groupMap.putIfAbsent(sortedStr, new ArrayList<>());
		groupMap.get(sortedStr).add(str);
			
		}
		return new ArrayList<>(groupMap.values());
	}

}
