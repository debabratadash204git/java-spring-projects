package sorting;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfEachCharactersInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "programming";

		Map<Character, Long> frequencyMap  = str.chars()
											  .mapToObj(c -> (char)c)
											  .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

		frequencyMap.forEach((character, frequency) -> System.out.println("character   " + character + "  and it's frequency  " + frequency));

	}

}
