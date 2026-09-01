package test;
/**
 * Thread Class vs Runnable Interface 
 * 1.	If we extend the Thread class, our class cannot extend 
 * 		any other class because Java doesn’t support multiple 
 * 		inheritance. But, if we implement the Runnable interface, 
 * 		our class can still extend other base classes.
 * 2.	We can achieve basic functionality of a thread by extending 
 * 		Thread class because it provides some inbuilt methods like 
 * 		yield(), interrupt() etc. that are not available in Runnable 
 * 		interface.
 * 3.	Using runnable will give you an object that can be shared 
 * 		amongst multiple threads. 
 * 
 */

//Java code for thread creation by extending
//the Thread class
class MultithreadingDemo_thread extends Thread {
	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println("Thread " 
			+ Thread.currentThread().threadId() + " is running");
		}
		catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}

//Java code for thread creation by implementing
//the Runnable Interface
class MultithreadingDemo_runnable implements Runnable {
	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println("Runnable Thread " 
			+ Thread.currentThread().threadId() + " is running");
		}
		catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}



//Main Class
public class Multithread_thread_runnable_class {
	public static void main(String[] args) {
		int n = 8; // Number of threads
		for (int i = 0; i < n; i++) {
			MultithreadingDemo_thread thread_object = new MultithreadingDemo_thread();
			thread_object.start();
			Thread  thread_object2 = new Thread(new MultithreadingDemo_runnable());
			thread_object2.start();
        }
    }
}
