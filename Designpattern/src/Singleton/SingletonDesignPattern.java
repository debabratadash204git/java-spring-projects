package Singleton;

public class SingletonDesignPattern {
	
	public static volatile SingletonDesignPattern instance = null;
	
	private SingletonDesignPattern() {
		
	}
	
	public static SingletonDesignPattern getInstance() {
		
		if(instance == null)
			synchronized (SingletonDesignPattern.class) {
				if(instance == null) {
					instance =  new SingletonDesignPattern();
				}
			}
		
		return instance;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SingletonDesignPattern s1 = SingletonDesignPattern.getInstance();
		SingletonDesignPattern s2 =  SingletonDesignPattern.getInstance();
		System.out.println(s1 == s2);

	}

}
