package com.driver;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {
	
	public static void main(String[] args) {
		new FullJustify().new Solution().fullJustify(new String[] {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
	}

	class Solution {
	    public List<String> fullJustify(String[] words, int maxWidth) {
	    	int n = words.length;
	        int[] lengthArray = new int[n];
	        int sum = 0;
	        for(int i=0;i<n;i++) {
	        	lengthArray[i] = words[i].length();
	        	sum += lengthArray[i];
	        }
	        List<List<Integer>> numList = new ArrayList<>();
	        List<Integer> sumList = new ArrayList<>();
	        int currSum = 0;
	        List<Integer> row = new ArrayList<>();
	        for(int x: lengthArray) {
	        	if(currSum+x+1>maxWidth) {
	        		sumList.add(currSum);
	        		numList.add(row);
	        		row = new ArrayList<>();
	        		currSum = x;
	        		row.add(x);
	        	}
	        	else {
	        		currSum+=x+1;
	        		row.add(x);
	        	}
	        }
	        numList.add(row);
	        int wordCounter = 0;
	        int lineCounter = 0;
	        for(List<Integer> arr : numList) {
	        	int wn = arr.size();
//	        	int extraSpace = maxWidth-sumList.get(lineCounter++);
	        	StringBuilder line = new StringBuilder();
	        	for(int i=0;i<wn;i++) {
	        		line.append(words[wordCounter++]).append(" ");
	        	}
	        	String printableLine = line.toString().trim();
	        	System.out.println(printableLine.length()+". "+ printableLine.toString());
	        }
	        return List.of();
	    }
	}
}
