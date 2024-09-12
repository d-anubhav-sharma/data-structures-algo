package com.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import com.logger.DLogger;

public class RandomSegmentSum {    
    Segment segment;
    Random random = new Random();
    List<List<Integer>> queries = new ArrayList<>();
    
    public RandomSegmentSum(int size, long lowerBound, long upperBound) {
    	List<Long> arr = randomArray(size, lowerBound, upperBound);
    	DLogger.info("Random array: {}", arr);
    	segment = new Segment(arr, 0, arr.size()-1);
    	queries = randomQueries(size);
    	DLogger.info("Random queries: {}", queries);

	}
    
    private List<List<Integer>> randomQueries(int size) {
    	IntStream
    		.range(0, size)
    		.forEach(index -> {
    			int start = random.nextInt(size);
    			queries.add(List.of(start, start+random.nextInt(size-start)));
    		});
    	return queries;
	}

	private List<Long> randomArray(int size, long lowerBound, long upperBound) {
    	return LongStream
    		.range(0, size)
    		.mapToObj(x -> random.nextLong(upperBound-lowerBound)+lowerBound)
    		.toList();
    }
	
	public List<Long> sumArray() {
		return queries
				.stream()
				.map(query -> segment.lookupSum(query.getFirst(), query.getLast()))
				.toList();
	}
}
