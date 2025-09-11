package general;

public class LongestCommonprefix {
	
	public static String longestCommonPrefix(String[] strs) {
		
		if (strs.length == 0)
			return " ";
		
		String prefix = strs[0];
		
		for(int i = 1; i< strs.length; i++) {
			
			while(strs[i].indexOf(prefix) != 0) {
				
				prefix = prefix.substring(0, prefix.length() -1);
				if(prefix.length() == 0)
					return " ";
			}
			
			
			
		}
		
		
		return prefix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] input =  {"flower","flow","flight"};
		String[] input =  {"dog","racecar","car"};
		
		String output = longestCommonPrefix(input);
		System.out.println("Longest common prefix = " + output);
		

	}

}
