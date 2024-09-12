package com.driver;

import java.util.ArrayDeque;
import java.util.Deque;

import com.logger.DLogger;

public class SimplifyUnixPath {
	public static void main(String[] args) {
		Solution solution = new SimplifyUnixPath().new Solution();
		DLogger.info(
				""
			+"\n"+solution.simplifyPath("/home/").equals("/home")
			+"\n"+solution.simplifyPath("/home//foo/").equals("/home/foo")
			+"\n"+solution.simplifyPath("/home/user/Documents/../Pictures").equals("/home/user/Pictures")
			+"\n"+solution.simplifyPath("/../").equals("/")
			+"\n"+solution.simplifyPath("/.../a/../b/c/../d/./").equals("/.../b/d")
		);
	}
	class Solution {
	    public String simplifyPath(String path) {
	    	String[] pathDirs = path.split("/");
	    	Deque<String> pathStack = new ArrayDeque<>();
	    	for(String dir : pathDirs) {
	    		if(dir.equals("..")) {
	    			if(!pathStack.isEmpty())pathStack.pop();
	    		}
	    		else if(!dir.equals(".") && !dir.isEmpty()) {
	    			pathStack.push(dir);
	    		}
	    	}
	    	StringBuilder builder = new StringBuilder();
	    	while(!pathStack.isEmpty()) {
	    		builder.append("/").append(pathStack.pollLast());
	    	}
	        if(builder.isEmpty()) return "/";
	        return builder.toString();
	    }
	}
}
