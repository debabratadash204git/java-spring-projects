
package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class SecondHighestSalaryAndNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> employees = Arrays.asList(
	            new Employee("A",5000, "IT"),
	            new Employee("B",7000, "IT"),
	            new Employee("C",9000, "HR"),
	            new Employee("D",7000, "SALES")
	        );
		
		
		Optional<Double> secondHighest = employees.stream()
											.map(Employee::getSalary)
											.distinct()
											.sorted(Comparator.reverseOrder())
											.skip(1)
											.findFirst();
		System.out.println("SecondHighestSalary of Employee list   "+ secondHighest.orElse(0.1) );
		
		
		employees.stream().
				collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).ifPresent(e -> System.out.println("Highest Paid: " + e.getName()));
		
		
		//System.out.println("MAx Salary of An Employee in a list   "+ MaxSalaryOfEmplyee);
		
		
		
		
		//Number List Example
		
		List<Integer> numbers = Arrays.asList(10,40,400,300,70,68,40,10,32);
		
		Optional<Integer> secondHighestnumber = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		
		System.out.println("SecondHighestNumber  of Intger list   "+ secondHighestnumber.orElse(0) );
		
		Optional<Integer> secondLowestnumber = numbers.stream().distinct().sorted().skip(1).findFirst();
		
		
		System.out.println("secondLowestnumber  of Intger list   "+ secondLowestnumber.orElse(0) );
		
		List<Integer> duplicateNumber = numbers.stream().distinct().collect(Collectors.toList());
		System.out.println("remove Duplicate items list   "+ duplicateNumber );
		
	}

}
