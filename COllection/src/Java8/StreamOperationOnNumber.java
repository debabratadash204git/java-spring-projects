package Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOperationOnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = Arrays.asList(1,7,8,9,5,2,36,4,78,222,24,9,36,7);

		Optional<Integer> sum = list.stream().reduce((a,b) -> a+b);
		System.out.println("sum of the elements in the list =" + sum.get());

		Optional<Integer> SkipElementsAndSum = list.stream().skip(5).reduce((a,b) -> a+b);
		System.out.println("Skip 5 elements and sum of the rest elements in the list =" + SkipElementsAndSum.get());

		double avg = list.stream().mapToInt(a->a).average().orElse(0);
		System.out.println("Average elements in the List = "+ avg);


		List<Integer> evenNum = list.stream().filter(num->num%2 ==0).collect(Collectors.toList());
		List<Integer> oddNum = list.stream().filter(num->num%2 !=0).collect(Collectors.toList());
		System.out.println("Even number =" + evenNum + " And Odd number is " + oddNum);


		List<Integer> duplicateNum = list.stream().filter(num-> Collections.frequency(list, num)>1).collect(Collectors.toList());
		System.out.println("Duplicate Numbers in the list" + duplicateNum);

		Set<Integer> duplicates1 = new HashSet<>();
		Set<Integer> dup = list.stream().filter(num -> !duplicates1.add(num)).collect(Collectors.toSet());
		System.out.println("Duplicate Numbers in the list through set " + dup);
 
		int max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Maximum Value: "+max);

		int min = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println("Maximum Value: "+max);

		List<Integer> asc_order = list.stream().sorted().collect(Collectors.toList());
		System.out.println("ASC Order: "+asc_order);

		List<Integer> desc_order = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println("DESC Order: "+desc_order);


		Map<Integer, Long> frequncyOfNumber = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("frequency of each number" + frequncyOfNumber);

//		for(Map.Entry<Integer,Long> entry: frequncyOfNumber.entrySet()) {
//			System.out.println("Key=" + entry.getKey() + "value" + entry.getValue());
//
//		}
//
//		frequncyOfNumber.forEach((Key,Value) -> System.out.println("Key=" + Key + "value=" + Value));
//
	}

}
