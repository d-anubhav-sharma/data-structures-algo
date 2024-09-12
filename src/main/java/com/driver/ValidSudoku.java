package com.driver;

public class ValidSudoku {

	class Solution {
	    public boolean isValidSudoku(char[][] board) {
	        for(char[] row : board) {
	        	if(isValidRow(row)) continue;
	        	return false;
	        }
	        return true;
	    }
	    
	    public boolean isValidRow(char[] row) {
	    	boolean[] checklist = new boolean[10];
	    	for(char cell : row) {
	    		if(cell=='.') continue;
	    		if(checklist[cell-48]) return false;
	    		checklist[cell-48] = true;
	    	}
	    	return true;
	    }
	}
}
