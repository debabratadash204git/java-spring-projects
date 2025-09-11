package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names = Arrays.asList("A", "B", "C", "A", "D", "B");
		
		Set<String> set = new HashSet<>();
		
		names.stream().filter(data-> !set.add(data)).forEach(data -> System.out.println("Duplicate item in list " + data));;
		
		Set<String> result = names.stream().filter(data-> !set.add(data)).collect(Collectors.toSet());

        result.forEach(System.out::println);

	}

}
