package Java8;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
	
	String name;
	int score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	private Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	
	public static void main(String args[])
	{
		
		List<Student> studentList = List.of(
											new Student("Ram", 70),
											new Student("mark", 100),
											new Student("karn", 400),
											new Student("sree", 90)
											);
		int passingScore = 80;
		
		List<String> resultList = studentList.stream().filter(s-> s.getScore() > passingScore).sorted(Comparator.comparingInt(Student::getScore).reversed())
				                   .map(Student::getName).collect(Collectors.toList());
		System.out.println(resultList);
		
	}

}
