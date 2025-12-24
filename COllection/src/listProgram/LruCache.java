package listProgram;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LruCache {

	int capacity;
	Map<Integer,Integer> map;
	List<Integer> list;

	LruCache(int capacity){
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.list = new LinkedList();
	}

	public int get(int key)
	{
		if(!map.containsKey(key)) {
			return -1;
		}
		list.remove(Integer.valueOf(key));
		list.addFirst(key);
		return map.get(key);
	}

	public void put(int key, int value) {

		if(map.containsKey(key)) {
			list.remove(Integer.valueOf(key));
			map.put(key, value);
		}
		else {
			if(map.size() >= capacity) {
				int item = list.removeLast();
				map.remove(item);
			}
			map.put(key, value);
		}
		list.addFirst(key);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LruCache cache = new LruCache(3);
		cache.put(2, 3);
		cache.put(4, 5);
		cache.put(1, 6);
		System.out.println("Get Operation->" + cache.get(1));
		cache.put(4, 4);
		System.out.println("Get Operation->" + cache.get(2));
		System.out.println("Get Operation->" + cache.get(3));
		System.out.println("Get Operation->" + cache.get(4));


	}

}
