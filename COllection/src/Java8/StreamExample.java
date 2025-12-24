package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = List.of("mom", "dad", "civic", "dad", "level", "hello","deb","madam","hellow");

		//Print Palindrom
//		System.out.println("Print palindrom");
//		list.stream().filter(s -> new StringBuilder(s).reverse().toString().equals(s)).forEach(System.out::println);
//
//
//		//Remove Duplicate from the list and preserve the order of the list
//		System.out.println("Remove duplicates from the list");
//		list.stream().distinct().forEach(System.out::println);
//		list.stream().collect(Collectors.toSet()).forEach(System.out::println);
//		new HashSet<>(list).forEach(System.out::println);

		//find all the numbers starting with 1

		List<Integer> num = Arrays.asList(10,11,12,34,54,67,21,19);
		List<Integer> num1 = Arrays.asList(10,11,12,13,14,19);

		//num.stream().filter(x-> String.valueOf(x).startsWith("1")).forEach(System.out::println);

		//Join two streams
		Stream<Integer> combineStream = Stream.concat(num.stream(),num1.stream());
		combineStream.forEach(System.out::println);
		
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		myList.stream().filter(s->s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::print);


	}

}
