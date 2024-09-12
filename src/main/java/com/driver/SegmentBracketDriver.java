package com.driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.impl.SegmentBracket;

public class SegmentBracketDriver {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		SegmentBracket segment = new SegmentBracket(st, 0, st.length()-1);
		StringBuilder builder = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String[] mn = br.readLine().split(" ");
			int m = Integer.parseInt(mn[0]);
			int n = Integer.parseInt(mn[1]);
			builder.append(segment.lookupPaired(m-1, n-1).paired).append("\n");
		}
		System.out.println(builder.toString());
	}
}
