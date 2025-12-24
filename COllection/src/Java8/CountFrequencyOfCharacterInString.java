package Java8;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountFrequencyOfCharacterInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "programming";
		
		Map<Character, Long> freqencyMap = input.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		
		
		freqencyMap.forEach((x,y)-> {
		if(y>1) {
			System.out.println("repeated char is " + x + " And its count " + y);
		}});
		
		freqencyMap.entrySet().stream().filter(entry-> entry.getValue() > 1).map(Map.Entry::getKey).forEach(System.out::println);
		
		
		
		 for(Map.Entry<Character, Long> entry : freqencyMap.entrySet())
	     {
	     	if(entry.getValue() > 1){
	     		System.out.println(entry.getKey() + " : " + entry.getValue());
	     	}
	     		
	     }
	}

}
