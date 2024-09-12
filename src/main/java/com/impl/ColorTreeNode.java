package com.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColorTreeNode {

	private int index;
	private int color;
	private List<ColorTreeNode> children = new ArrayList<>();
	private Map<Integer, Integer> colorCounter = new HashMap<>();
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public List<ColorTreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<ColorTreeNode> children) {
		this.children = children;
	}
	public Map<Integer, Integer> getColorCounter() {
		return colorCounter;
	}
	public void setColorCounter(Map<Integer, Integer> colorCounter) {
		this.colorCounter = colorCounter;
	}
}
