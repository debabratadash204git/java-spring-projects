package strings;
import java.util.List;
import java.util.ArrayList;

public class findAllSubstring {
	
	public static List<String> findAllTheSubString(String str) {
		
		if(str.isBlank())
			return null ;
		List<String> subStringList = new ArrayList<String>();
		String[] finallist = null;
		int length = str.length();
		
		for(int i = 0; i< length ; i++)
		{
			for(int j = i; j< length ;j++) {
				
				subStringList.add(str.substring(i, j+1));
			}
		}
		
//		for(String s :subStringList)
//			System.out.println(s);
		return subStringList;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "welcome";
		List<String> output = findAllTheSubString(str);
		for(String s :output)
			System.out.println(s);

	}

}
