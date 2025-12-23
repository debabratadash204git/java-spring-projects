package leetCode150;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "madam";
		String str2 = "manad";
		Boolean result = ValidAnagramOfString(str1,str2);
		if(result)
				System.out.println("valid anagram");
		else
			System.out.println("Not valid");
				
	}

	private static Boolean ValidAnagramOfString(String str1, String str2) {
		// TODO Auto-generated method stub
		if(str1.length() != str2.length())
			return false;
		
		int charArray[] = new int[26];
		
		for (int i = 0; i< str1.length() ; i++) {
			charArray[str1.charAt(i) - 'a']++;
			charArray[str2.charAt(i) - 'a']--;
		}
		
		for(int x:charArray)
		{
			if(x != 0)
				return false;
		}
		return true;
		
	}

}
