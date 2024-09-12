package com.impl;

import java.util.ArrayDeque;
import java.util.Deque;

import com.logger.DLogger;

public class BracketValidation {
	public static void main(String[] args) {
		DLogger.info("{}",validate("(())"));
	}
	
	private static boolean validate(String braces) {
		Deque<Character> stack = new ArrayDeque<>();
		for(char c : braces.toCharArray()) {
			if(c=='(') {
				stack.push(c);
			}
			else {
				if(stack.isEmpty()) return false;
				if(stack.pop()==')') return false;
			}
		}
		return stack.isEmpty();
	}
}
