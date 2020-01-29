package com.sruthi;

public class Logger {
	public static Logger getInstance() {
		Logger logger = new Logger();
		return logger;
	}
	public void getInput(Object message) {
		System.out.println(message);
	}
	public void debug(Object message) {
		System.out.println(message);
	}
	public void info(Object message) {
		System.out.println(message);
	}
	public void error(Object message) {
		System.out.println(message);
	}

}
