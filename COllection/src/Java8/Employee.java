package Java8;

public class Employee {
	String name;
    double salary;
    String dept;


    Employee(String name, double salary,String dept) {
    	this.name = name; this.salary = salary; this.dept = dept;
    }


    public String getName() {
    	return name;
    }

    public String getDept() {
		return dept;
	}


	public double getSalary() {
    	return salary;
    }

}
