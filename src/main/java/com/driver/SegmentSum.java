package com.driver;

import com.impl.RandomSegmentSum;
import com.logger.DLogger;

public class SegmentSum {

	public static void main(String[] args) {
		RandomSegmentSum randomSegmentSum = new RandomSegmentSum(10, -10, 10);
		DLogger.info("RandomSegmentArraySum: {}", randomSegmentSum.sumArray());
	}

}
