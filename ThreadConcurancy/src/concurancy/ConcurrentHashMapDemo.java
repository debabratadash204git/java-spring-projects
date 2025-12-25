package concurancy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
		
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		
		Iterator<Map.Entry<String,Integer>> entry = map.entrySet().iterator();
		
		while(entry.hasNext()) {
			
			Map.Entry<String,Integer> entrytwo = entry.next();
			
			if(entrytwo.getKey().equals("two"))
				map.put("four", 4);
		}
		System.out.println(map);

	}

}
