package com.impl;

import java.util.ArrayList;
import java.util.List;

public class DominatingColorTree {

	private ColorTreeNode root;
	
	public DominatingColorTree(List<Integer> colorList, List<List<Integer>> edges) {
		int n = colorList.size();
		List<ColorTreeNode> nodes = new ArrayList<>();
		for(int i=0;i<n;i++) {
			ColorTreeNode node = new ColorTreeNode();
			root.setColor(colorList.get(i));
			root.setIndex(i);
			nodes.add(node);
		}
		for(List<Integer> edge : edges) {
			nodes.get(edge.get(0)).getChildren().add(nodes.get(edge.get(1)));
		}
	}
}
