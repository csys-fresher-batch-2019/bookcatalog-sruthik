package com.sruthi;



public class Logger {
	public static Logger getInstance() {
		return new Logger();
	}
	public void getInput(Object message) {
		Logger.log(message);
	}
	private static void log(Object message) {
		System.out.println(message);
		
	}
	public void debug(Object message) {
		Logger.log(message);
	}
	public void info(Object message) {
		Logger.log(message);
	}
	public void error(Object message) {
		Logger.log(message);
	}
	

}
