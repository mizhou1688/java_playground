package test;

/**
 * Static Synchronization
 * In this, the synchronized method is declared as “static” 
 * which means the lock or monitor is applied on the class 
 * not on the object so that only one thread will access the 
 * class at a time.
 */

//Java Program Illustrate  Synchronized
//Using static synchronization


//Helper class
//Note: not needed to extend the Thread class
class PrintTest1 extends Thread {
	// Static synchronization locks the class PrintTest
	synchronized public static void printThread(int n) {
		for (int i = 1; i <= 10; i++) {
			// Print message when threads are executing
			System.out.println("Thread " + n
					+ " is working...");
			
			// Try block to check for exceptions
			try {
				
				// making thread to sleep for 0.6 seconds
				Thread.sleep(600);
			}
			// Catch block to handle the exceptions
			catch (Exception ex) {
				// Print message when exception occurs
				System.out.println(ex.toString());
			}
		}
		
		// Display message for better readability
		System.out.println("--------------------------");
		
		try {
			Thread.sleep(1000);
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}

// class 2
//Helper class extending Thread class
class Thread21 extends Thread {
	// run() method for thread
	public void run() {
		// Passing the class not the object
		PrintTest1.printThread(1);
	}
}

// class 3
//Helper class extending Thread class
class Thread22 extends Thread {
	public void run() {
		// Passing the class not the object
		PrintTest1.printThread(2);
	}
}

//Main class
public class Static_synchronization {
	// Main driver method
    public static void main(String[] args) {
 
        // No shared object
        // Creating objects of class 2 and 3 that
        // are extending to Thread class
        Thread21 t1 = new Thread21();
        Thread22 t2 = new Thread22();
 
        // Starting thread with help of start() method
        t1.start();
        t2.start();
    }

}
