package com.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DLogger {

	private static final Logger LOGGER = LogManager.getLogger();
	
	public static void info(String message, Object... formatter) {
		LOGGER.atInfo().log(message, formatter);
	}

	public static void error(String message, Object... formatter) {
		LOGGER.atError().log(message, formatter);
	}
	private DLogger() {}
}
