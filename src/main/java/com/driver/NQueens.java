package com.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.logger.DLogger;

public class NQueens {
	
	public static void main(String[] args) {
		DLogger.info("{}",new NQueens().new Solution().totalNQueens(4));
	}
	
	class Solution {
	    public List<List<String>> totalNQueens(int n) {
	        char[][] board = new char[n][n];
	        List<List<String>> result = new ArrayList<>();
	        for(int i=0;i<n;i++) for(int j=0;j<n;j++) board[i][j]='.';
	        solve(board,0,n,result);
	        return result;
	    }

		private boolean solve(char[][] board, int row, int n, List<List<String>> result) {
			if(row==n) {
				result.add(getList(board));
				return true;
			}
			boolean solved = false;
			for(int i=0;i<n;i++) {
				if(board[row][i]=='.' && isValid(board, row, i, n)) {
					board[row][i] = 'Q';
					solved |= solve(board, row+1, n, result);
					board[row][i] = '.';
				}
			}
			return solved;
		}

		private boolean isValid(char[][] board, int x, int y, int n) {
			for(int i=0;i<n;i++) {
				if(board[i][y]=='Q'||board[x][i]=='Q') return false;
			}
			int i=x;
			int j=y;
			while(i>=0&&j>=0) {
				if(board[i--][j--]=='Q') return false;
			}
			i=x;
			j=y;
			while(i<n&&j<n) {
				if(board[i++][j++]=='Q') return false;
			}
			i=x;
			j=y;
			while(i<n&&j>=0) {
				if(board[i++][j--]=='Q') return false;
			}
			i=x;
			j=y;
			while(i>=0&&j<n) {
				if(board[i--][j++]=='Q') return false;
			}
			return true;
		}

		private List<String> getList(char[][] board) {
			return Arrays.stream(board).map(String::new).toList();
		}
	} 
}
