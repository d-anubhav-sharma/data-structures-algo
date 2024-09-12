package com.driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class XmlParser {
	public static void main(String[] args) throws IOException {
		Solution.main(args);
	}
	public class Solution{
		
		static class Token{
			String val;
			String type;
			public Token(String val, String type) {
				this.val = val;
				this.type = type;
			}
			@Override
			public String toString() {
				return "Token [val=" + val + ", type=" + type + "]";
			}
			
		}
		
		private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		public static void main(String[] args) throws IOException{
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
			int testCases = Integer.parseInt(reader.readLine());
			while(testCases>0){
				System.out.print(parseXml(reader.readLine()));
				testCases--;
			}
		}

		private static String parseXml(String line) {
			StringBuilder builder = new StringBuilder();
			Deque<Token> stack = new ArrayDeque<>();
			Token token = null;
			while((token = nextToken(line))!=null) {
				if(token.type.equals("text")) {
					builder.append(token.val).append("\n");
					line = line.substring(token.val.length());
				}
				else if(token.type.equals("close-tag")) {
					if(stack.isEmpty()) {
						return "None\n";
					}
					Token popped = stack.pop();
					if(!popped.type.equals("open-tag") || !popped.val.equals(token.val)) {
						return "None\n";
					}
					line = line.substring(token.val.length()+3);
				}
				else {
					stack.push(token);
					line = line.substring(token.val.length()+2);
				}
				
			}
			return builder.toString();
			
		}
		
		private static Token nextToken(String line) {
			if(line.isEmpty()) return null;
			if(line.charAt(0)=='<') {
				if(line.charAt(1)=='/') {
					return new Token(line.substring(2, line.indexOf('>')), "close-tag");
				}
				else {
					return new Token(line.substring(1, line.indexOf('>')), "open-tag");
				}
			}
			if(ALPHABET.indexOf(line.charAt(0))>-1) {
				if(line.indexOf('<')>-1) {
					return new Token(line.substring(0,line.indexOf('<')), "text");
				}
				else return new Token(line, "text");
			}
			return null;
		}
	}

}
