package com.driver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PossiblePath {
	public static void main(String[] args) throws IOException {
		List<List<Integer>> list = new ArrayList<>();
		try(FileWriter writer = new FileWriter(new File("out.txt"))){
			printAllPaths(13,7,0, list);
			list.sort((a,b) -> {
				if(a.get(0).equals(b.get(0))) return a.get(1)-b.get(1);
				return a.get(0)-b.get(0);
			});
			writer.write(list.toString());
		}
	}

	private static void printAllPaths(int a, int b, int depth, List<List<Integer>> writer) throws IOException {
		if(depth>10) return;
		if(!contains(writer,a,b))writer.add(List.of(a,b));
		printAllPaths(a+b, b, depth+1, writer);
		printAllPaths(a-b, b, depth+1, writer);
		printAllPaths(a, b+a, depth+1, writer);
		printAllPaths(a, b-a, depth+1, writer);
	}

	private static boolean contains(List<List<Integer>> list, int a, int b) {
		for(List<Integer> ele : list) {
			if(ele.get(0).equals(a) && ele.get(1).equals(b)) return true;
		}
		return false;
	}
	
}
