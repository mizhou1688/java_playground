package test;

import java.util.logging.Logger;
import java.util.logging.Level;


/** Using volatile is yet another way (like synchronized, atomic wrapper) 
 * of making class thread-safe. Thread-safe means that a method or class 
 * instance can be used by multiple threads at the same time without any problem
 * */

//Java Program to demonstrate the use of Volatile Keyword in Java

public class Volatile_keyword {
	// Acquire a logger named after the current class
	private static final Logger LOGGER	= Logger.getLogger(Volatile_keyword.class.getName());
	private static volatile int MY_INT = 0;

	public static void main(String[] args) {
		new ChangeListener().start();
		new ChangeMaker().start();
	}
	
	static class ChangeListener extends Thread {
		@Override public void run()	{
			int local_value = MY_INT;
			while (local_value < 5) {
				if (local_value != MY_INT) {
					LOGGER.log(Level.INFO, "Got Change for MY_INT : {0}",
						MY_INT);
					local_value = MY_INT;
				}
			}
		}
	}
	
	static class ChangeMaker extends Thread {
		@Override public void run()	{
			int local_value = MY_INT;
			while (MY_INT < 5) {
				LOGGER.log(Level.INFO, "Incrementing MY_INT to {0}",
						local_value + 1);
				MY_INT = ++local_value;
				try {
					Thread.sleep(500);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
