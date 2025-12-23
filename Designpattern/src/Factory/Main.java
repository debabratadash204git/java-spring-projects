package Factory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape s1 = Factoryclass.getInstance("circle");
		s1.draw();
		Shape s2 = Factoryclass.getInstance("square");
		s2.draw();
		

	}

}
