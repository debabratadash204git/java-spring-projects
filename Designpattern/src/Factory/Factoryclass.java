package Factory;

public class Factoryclass {
	
	public static Shape getInstance(String type) {
		
		if(type.equalsIgnoreCase("circle"))
			return new Circle();
		else if(type.equalsIgnoreCase("square"))
			return new Square();
		else
			return null;
	}

}
