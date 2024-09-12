package com.driver;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class ReversePolishNotation {
	
	public static void main(String[] args) {
		Solution solution = new ReversePolishNotation().new Solution();
		int[] result = {
				solution.evalRPN(new String[] {"2","1","+","3","*"}),
				solution.evalRPN(new String[] {"4","13","5","/","+"}),
				solution.evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}),
				solution.evalRPN(new String[] {"2","1","+","3","*"}),
				solution.evalRPN(new String[] {"2","1","+","3","*"}),
		};
		System.out.println(Arrays.toString(result));
	}
	
	class Solution {
	    public int evalRPN(String[] tokens) {
	    	List<String> opers = List.of("+","-","*","/");
	    	Deque<Integer> stack = new ArrayDeque<>();
	        for(String token : tokens) {
	        	if(opers.contains(token)) {
	        		stack.push(eval(stack.pop(),stack.pop(),token));
	        	}
	        	else {
	        		stack.push(Integer.parseInt(token));
	        	}
	        }
	        return stack.pop();
	    }

		private int eval(Integer val2, Integer val1, String token) {
			switch(token) {
				case "+": return val1+val2;
				case "-": return val1-val2;
				case "*": return val1*val2;
				case "/": return val1/val2;
				default: return 0;
			}
		}

	}
}
