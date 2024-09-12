package com.driver;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
	private final Map<Integer, Integer> cache;

	public LRUCache(int capacity) {
		this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
	}

	public int get(int key) {
		return cache.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		cache.put(key, value);
	}

	public static void main(String[] args) {
		LRUCache c = new LRUCache(2);
		c.put(1, 1);
		c.put(2, 2);
		System.out.println(c.get(1)); // returns 1
		c.put(3, 3); // evicts key 2
		System.out.println(c.get(2)); // returns -1 (not found)
		c.put(4, 4); // evicts key 1
		System.out.println(c.get(1)); // returns -1 (not found)
		System.out.println(c.get(3)); // returns 3
		System.out.println(c.get(4)); // returns 4
	}
}
