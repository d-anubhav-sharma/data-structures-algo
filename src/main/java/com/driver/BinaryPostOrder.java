package com.driver;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryPostOrder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	 }
	class Solution {
	    public List<Integer> postorderTraversal(TreeNode root) {
	    	if(root==null) return new ArrayList<>();
	    	List<Integer> result = new ArrayList<>();
	        Deque<TreeNode> stack = new ArrayDeque<>();
	        Deque<Integer> intStack = new ArrayDeque<>();
	        stack.push(root);
	        while(!stack.isEmpty()) {
		        TreeNode current = stack.pop();
	        	if(current.left!=null) {
	        		stack.push(current.left);
	        	}
	        	if(current.right!=null) {
	        		stack.push(current.right);
	        	}
	        	intStack.push(current.val);
	        }
	        while(!intStack.isEmpty()) result.add(intStack.pop());
	        return result;
	    }
	}
}
