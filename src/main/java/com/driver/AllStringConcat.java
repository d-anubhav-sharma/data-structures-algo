package com.driver;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.logger.DLogger;

public class AllStringConcat {
	
	public static void main(String[] args) {
		
		Solution solution = new AllStringConcat().new Solution();
		String s = "barfoothefoobarman";
		String[] words = {"foo","bar"};
		List<Integer> out = List.of(0,9);
		assertThat(solution.findSubstring(s, words)).containsExactlyInAnyOrderElementsOf(out);
		
		s = "wordgoodgoodgoodbestword";
		words = new String[]{"word","good","best","word"};
		out = List.of();
		assertThat(solution.findSubstring(s, words)).containsExactlyInAnyOrderElementsOf(out);

		s = "barfoofoobarthefoobarman";
		words = new String[]{"bar","foo","the"};
		out = List.of(6,9,12);
		assertThat(solution.findSubstring(s, words)).containsExactlyInAnyOrderElementsOf(out);
		
		DLogger.info("Here I start==============");
		s = "wordgoodgoodgoodbestword";
		words = new String[]{"word","good","best","good"};
		out = List.of(8);
		assertThat(solution.findSubstring(s, words)).containsExactlyInAnyOrderElementsOf(out);
		
	}
	
	class Solution {
	    public List<Integer> findSubstring(String s, String[] words) {
	    	Map<String, Integer> wordMap = getOccurenceDict(words);
	    	List<Integer> result = new ArrayList<>();
	    	int start = 0;
	    	int curr = words.length * words[0].length();
	    	int end = s.length();
	        while(curr<=end) {
	        	if(checkString(s,words,start,curr,wordMap)) {
	        		result.add(start);
	        	}
	        	start++;
	        	curr++;
	        }
	        return result;
	    }

		private Map<String, Integer> getOccurenceDict(String[] words) {
			Map<String, Integer> map = new HashMap<>();
			for(String word : words) {
				if(map.get(word)==null) {
					map.put(word, 1);
				}
				else {
					map.put(word, map.get(word)+1);
				}
			}
			return map;
		}

		private boolean checkString(String s, String[] words, int start, int curr, Map<String, Integer> wordMap) {
			Map<String, Integer> wmap = new HashMap<>(wordMap);
			int n = words[0].length();
			DLogger.info("Starting at {}", start);
			for(int i=start;i<curr;i+=n) {
				String word = s.substring(i,i+n);
				DLogger.info("Looking for word {}", word);
				Integer count = wmap.get(word);
				if(count==null || count<=0) return false;
				DLogger.info("Found word {}", word);
				wmap.put(word, count-1);
			}
			return true;
		}
	}
}


