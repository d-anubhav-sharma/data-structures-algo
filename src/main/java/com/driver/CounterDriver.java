package com.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class CounterDriver {
	private static final long END_TIME = System.currentTimeMillis()+1000*60;
	public static void main(String[] args) throws InterruptedException {
		AtomicLong counter = new AtomicLong();
		List<Thread> threads = new ArrayList<>();
		IntStream.range(0, 1000).forEach(i -> {
			Thread t1 = new Thread(() -> {
				while(System.currentTimeMillis()<END_TIME) {
					counter.incrementAndGet();
				}
			});
			t1.start();
			threads.add(t1);
		});
		for(Thread t : threads) {
			t.join();
		}
		System.out.print(counter.get());
	}
}
