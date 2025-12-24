package TestPracticepackage;

import java.util.ArrayList;
import java.util.List;

public class Main {

//	public static  void display(){
//		System.out.println("1");
//		}
//
//		public static String display(){
//			System.out.println("2");
//		return null;
//		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<>(20);
		//arr = {1,2,3,4,5};
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list.size());
//		for(int i : list){
//			System.out.println(i);
//			list.add(6);
//		}
//		for(int i=0 ; i<list.size();i++){
//			System.out.println(i);
//			list.add(1,6);
//			}

		Boolean c = new Boolean("Yes");
        System.out.println(c);

        Boolean b = new Boolean("No");
        System.out.println(b);

        System.out.println(c.equals(b));

        Integer i = 100;
        Integer j = 100;
        System.out.println(i==j);
        System.out.println(i.equals(j));

		String str1 = null;
		String str2 = "abc";
		if(str2.equalsIgnoreCase(str1)){
			System.out.println("hi");
		}else{
			System.out.println("hello");


		A a = new B();
		a.display(1);

		}

	}

}

class A
{
	public void display(int a){
		System.out.println("1");
		}
}
class B extends A
{
	@Override
	public void display(int a ){
		System.out.println("2");
		//return null;
	}
}
