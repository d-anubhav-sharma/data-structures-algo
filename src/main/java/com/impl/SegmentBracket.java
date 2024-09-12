package com.impl;

import com.logger.DGson;

public class SegmentBracket implements Cloneable{

	public int left;
	public int right;
	public int extraOpen;
	public int extraClosed;
	public int paired;
	public String brace;
	
	SegmentBracket leftSegment;
	SegmentBracket rightSegment;
	
	public SegmentBracket(String braces, int left, int right) {
		if (braces == null || braces.isEmpty())
			return;
		brace = braces.substring(left, right+1);

		this.left = left;
		this.right = right;

		if (left == right) {
			if(braces.charAt(right)=='(') {
				extraOpen = 1;
			}
			else {
				extraClosed = 1;
			}
			return;
		}
		
		int mid = (left + right) / 2;
		leftSegment = new SegmentBracket(braces, left, mid);
		rightSegment = new SegmentBracket(braces, mid + 1, right);
		int matched = Math.min(leftSegment.extraOpen, rightSegment.extraClosed);
		extraOpen = leftSegment.extraOpen + rightSegment.extraOpen - matched;
		extraClosed = leftSegment.extraClosed + rightSegment.extraClosed - matched;
		paired = leftSegment.paired + rightSegment.paired + matched*2;
	}
	
	public SegmentBracket lookupPaired(int start, int end) {
		if(end<left || start>right) {
			return null;
		}
		if(start<=left && end>=right) {
			return this;
		}
		SegmentBracket leftResult = leftSegment==null?null:leftSegment.lookupPaired(start, end);
		SegmentBracket rigthResult = rightSegment==null?null:rightSegment.lookupPaired(start, end);;
		
		if(leftResult==null && rigthResult==null) return null;
		if(leftResult==null) return rigthResult;
		if(rigthResult==null) return leftResult;
		
		SegmentBracket result = new SegmentBracket();
		int matched = Math.min(leftResult.extraOpen, rigthResult.extraClosed);
		result.extraOpen = leftResult.extraOpen + rigthResult.extraOpen - matched;
		result.extraClosed = leftResult.extraClosed + rigthResult.extraClosed - matched;
		result.paired = leftResult.paired + rigthResult.paired + matched*2;
		return result;
		
	}
	
	private SegmentBracket() {}
		
	public SegmentBracket clone() throws CloneNotSupportedException {
		SegmentBracket target = (SegmentBracket)super.clone();
		target.brace = this.brace;
		target.extraClosed = this.extraClosed;
		target.extraOpen = this.extraOpen;
		target.paired = this.paired;
		target.left = this.left;
		target.right = this.right;
		return target;
	}

	@Override
	public String toString() {
		return DGson.dgson().stringify(this);
	}

}
