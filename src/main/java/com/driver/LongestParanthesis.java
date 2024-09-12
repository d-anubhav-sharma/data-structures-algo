package com.driver;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class LongestParanthesis {
	
	public static void main(String[] args) {
		Solution solution = new LongestParanthesis().new Solution();
		assertThat(solution.longestValidParentheses("(()")).isEqualTo(2);
		assertThat(solution.longestValidParentheses(")()())")).isEqualTo(4);
		assertThat(solution.longestValidParentheses("")).isEqualTo(0);
		assertThat(solution.longestValidParentheses("()")).isEqualTo(2);
		assertThat(solution.longestValidParentheses("())")).isEqualTo(2);

		solution.longestValidParentheses("(()");
		solution.longestValidParentheses(")()())");
		solution.longestValidParentheses("");
		solution.longestValidParentheses("()");
		solution.longestValidParentheses("())");
	}

	class Solution {
	    public int longestValidParentheses(String braces) {
	    	Deque<Node> stack = new ArrayDeque<>();
	    	int n = braces.length();
	    	for(int i=0;i<n;i++) {
	    		char c = braces.charAt(i);
	    		if(c=='(') {
	    			stack.push(new Node(c,i));
	    		}
	    		else {
	    			Node node = stack.peek();
	    			if(node==null || node.c==')') {
	    				stack.push(new Node(c,i));
	    			}
	    			else stack.pop();
	    		}
	    	}
	    	if(stack.isEmpty()) return n;
	    	List<Integer> nlist = stack.stream().map(node -> node.i).sorted().toList();
	    	int size = nlist.size();
	    	int max = Math.max(nlist.get(0), n-nlist.get(size-1)-1);
	    	for(int i=1;i<size;i++) {
	    		int curr = nlist.get(i)-nlist.get(i-1)-1;
	    		if(curr>max) max = curr;
	    	}
	    	return Math.max(max, 0);
	    }
	}
	
	class Node {
		char c;
		int i;
		
		Node(char c, int i){
			this.c = c;
			this.i = i;
		}

		@Override
		public String toString() {
			return "(" + c + ", " + i + ")";
		}
		
		
	}
}
