package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Group employees by department and calculate average salary
public class GroupEmployeesByDept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> employees = Arrays.asList(
	            new Employee("A",5000, "IT"),
	            new Employee("B",7000, "IT"),
	            new Employee("C",9000, "HR"),
	            new Employee("D",7000, "SALES"),
	            new Employee("D",6500, "SALES")
	        );

		Map<String,Double> avgeDeptBySalary = employees.stream()
														.collect(Collectors.groupingBy(Employee::getDept,
																Collectors.averagingDouble(Employee::getSalary)));

		System.out.println("Group employees by department and calculate average salary" + avgeDeptBySalary);




	}

}
