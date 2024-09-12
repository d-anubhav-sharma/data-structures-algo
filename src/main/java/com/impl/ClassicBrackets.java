package com.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class ClassicBrackets {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		char[] braces = st.toCharArray();
		StringBuilder builder = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String[] mn = br.readLine().split(" ");
			Deque<Character> stack = new ArrayDeque<>();
			int m = Integer.parseInt(mn[0]);
			int n = Integer.parseInt(mn[1]);
			int count=0;
			for(int i=m-1;i<n;i++) {
				char c = braces[i];
				if(c=='(' || stack.isEmpty()) stack.push(c);
				else {
					char x = stack.peek();
					if(x=='(') {
						stack.pop();
						count+=2;
					}
					else if(stack.contains('(')){
						stack.remove('(');
						count+=2;
					}
				}
			}
			builder.append(count+"\n");
		}
		System.out.println(builder.toString());
	}
}
