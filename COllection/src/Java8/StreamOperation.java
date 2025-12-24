package Java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperation {

	public static void addEmployees(List<Employees> empList) {

		empList.add(new Employees(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020));
		empList.add(new Employees(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015));
		empList.add(new Employees(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
		empList.add(new Employees(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));

		empList.add(new Employees(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
		empList.add(new Employees(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017));
		empList.add(new Employees(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016));
		empList.add(new Employees(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015));
		empList.add(new Employees(9, "Ram", 25, 160, "M", "IT", "Blore", 2010));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employees> empList = new ArrayList<>();
		addEmployees(empList);

		//Group the Employees by city.

		Map<String, List<Employees>> citymap = empList.stream().collect(Collectors.groupingBy(Employees::getCity,Collectors.toList()));
		System.out.println("Group the Employees by city." + "\n" +  citymap + '\n');


		Set<String> cityset = empList.stream().collect(Collectors.groupingBy(Employees::getCity)).keySet();

		List<String> cityList= empList.stream().map(Employees::getCity).collect(Collectors.toList());
		System.out.println("Display theCity name Only" + cityList + "\n" + cityset);


		Collection<List<Employees>> employeeData = empList.stream().collect(Collectors.groupingBy(Employees::getCity)).values();
		System.out.println("Display the Employee object Only" + employeeData.toString());


		//Find the count of male and female employees present in the organization.

		Map<String, Long> noOfMaleAndFemaleEmployees = empList.stream()
                .collect(Collectors.groupingBy(Employees::getGender, Collectors.counting()));
			System.out.println("Count of male and female employees present in the organization:: \n" + noOfMaleAndFemaleEmployees);

	   // Compute sum of salaries of employee
		 Long total = empList.stream()
		                          .collect(Collectors.summingLong(Employees::getSalary));

		 System.out.println("Compute sum of salaries of employee" + total);


		// Compute sum of salaries by department
	     Map<String, Long> totalByDept
	         = empList.stream()
	                    .collect(Collectors.groupingBy(Employees::getDeptName,
	                                                   Collectors.summingLong(Employees::getSalary)));
	     System.out.println("Compute sum of salaries by Department" + totalByDept);
	     
	     
	     //Find the highest salary of each department
	     
	    Map<String,Optional<Employees>> deptSalary= empList.stream().collect(Collectors.groupingBy(Employees::getDeptName,Collectors.maxBy(Comparator.comparing(Employees::getSalary))));
	    
	    //Find the 2nd  highest salary 
	    
	    Employees SecondSal = empList.stream().sorted(Comparator.comparingDouble(Employees::getSalary).reversed()).skip(1).findFirst().get();
	    
	    System.out.println("2nd largest salary of an employee : -> " + SecondSal);
	    
	    deptSalary.forEach((String k,Optional<Employees> v)-> System.out.println(k + ":" + v));

	     //Find the count of male and female present in each department

	     Map<String,Map<String,Long>> genderMapInDept =   empList.stream().collect(Collectors.groupingBy(Employees::getDeptName,Collectors.groupingBy(Employees::getGender, Collectors.counting())));
	     System.out.println("Find the count of male and female present in each department" + genderMapInDept);

	    //Print the number of employees in each department
	     Map<String, Long> countByDept = empList.stream().collect(Collectors.groupingBy
                 (Employees::getDeptName,Collectors.counting()));
	     			System.out.println("No of employees in each department" + countByDept);
	     for(Map.Entry<String, Long> entry : countByDept.entrySet())
	     {
	     	System.out.println(entry.getKey() + " : " + entry.getValue());
	     }


	     //Sorting a Stream by age and name fields.

	     Comparator<Employees> comparator1 = Comparator.comparing(Employees::getAge);
	     Comparator<Employees> comparator2 = Comparator.comparing(Employees::getName);
	     empList.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);

	     List<Employees> compareList = empList.stream().sorted(comparator1.thenComparing(comparator2)).collect(Collectors.toList());
System.out.println(compareList);
	}

}
