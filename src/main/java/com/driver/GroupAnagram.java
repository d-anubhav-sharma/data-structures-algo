package com.driver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagram {
	class Solution {
	    public List<List<String>> groupAnagrams(String[] strs) {
	        return Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
	        	char[] s = str.toCharArray();
	        	Arrays.sort(s);
	        	return new String(s);
	        })).values().stream().toList();
	    }
	}
}
