package com.driver;

import com.logger.DLogger;

public class SudokuSolver {
	static char[][] board = new char[][] 
			{
			{'.','.','9','7','4','8','.','.','.'},
			{'7','.','.','.','.','.','.','.','.'},
			{'.','2','.','1','.','9','.','.','.'},
			{'.','.','7','.','.','.','2','4','.'},
			{'.','6','4','.','1','.','5','9','.'},
			{'.','9','8','.','.','.','3','.','.'},
			{'.','.','.','8','.','3','.','2','.'},
			{'.','.','.','.','.','.','.','.','6'},
			{'.','.','.','2','7','5','9','.','.'}}
		;
	public static String boardString() {
		StringBuilder builder = new StringBuilder();
		for(char[] row : board) {
			for(char cell : row) {
				builder.append(cell);
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	public static void main(String[] args) {
		
		new SudokuSolver().new Solution().solveSudoku(board);
		DLogger.info("{}", boardString());
	}

	
	class Solution {
		public void solveSudoku(char[][] board) {
			solve(board);
		}

		private boolean solve(char[][] board) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					if(board[i][j]=='.') {
						for(char c='1';c<='9';c++) {
							if(isValid(board, i, j, c)) {
								board[i][j] = c;
								if(solve(board)) return true;
								board[i][j] = '.';
							}
						}
						return false;
					}
				}
			}
			return true;
		}

		private boolean isValid(char[][] board, int x, int y, char c) {
			int bx = (x/3)*3;
			int by = (y/3)*3;
			for(int i=0;i<9;i++) {
				if(board[x][i]==c || board[i][y]==c) return false;
				if(board[bx+(i/3)][by+(i%3)]==c) return false;
			}
			return true;
		}
	}
}
