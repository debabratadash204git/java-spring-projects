package generics;

public class genericsClass<T extends Object> {
	
	private T obj;
	
	public void setObject(T obj) {
		this.obj = obj;
	}
	
	public T getObject() {
		return obj ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		genericsClass<String> Stringgenericobj = new genericsClass();
		Stringgenericobj.setObject("deba");
		String value = Stringgenericobj.getObject();
		System.out.println("return value =" + value);
		
		genericsClass<Integer> integerGenericobj = new genericsClass();
		integerGenericobj.setObject(30);
		int intvalue = integerGenericobj.getObject();
		System.out.println("return value =" + intvalue);
		
		genericsClass<Double> doubleGenericobj = new genericsClass();
		doubleGenericobj.setObject(30.45);
		Double doublevalue = doubleGenericobj.getObject();
		System.out.println("return value =" + doublevalue);

	}
}
