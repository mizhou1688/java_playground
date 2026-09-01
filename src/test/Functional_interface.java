package test;

@FunctionalInterface
interface Square {
    int calculate(int x);
}

/**
 * 1. 	In functional interfaces, there is only one abstract method supported
 * 	Otherwise, the interfaces are called non-functional interfaces.
 * 
 * 2.	There is no such need for the @FunctionalInterface annotation as it is 
 * 	voluntary only. This is written because it helps in checking the compiler 
 * 	level. Besides this, it is optional.
 * 
 * 3.	An infinite number of methods (whether static or default) can be added 
 * 	to the functional interface. In simple words, there is no limit to a 
 * 	functional interface containing static and default methods.
 * 
 * 4.	Overriding methods from the parent class do not violate the rules of a 
 * 	functional interface in Java.
 */
public class Functional_interface {
	public static void main(String args[]) {
		/**
		 * create anonymous inner class object to implement functional interface
		 */
		new Thread(new Runnable() {
			@Override public void run() {
				System.out.println("New thread created.");
			}
		}).start();
		
		/**
		 * using lambda expressions to implement functional interface
		 */
		new Thread(() -> {
			System.out.println("New thread created1.");
		}).start();
		
		/**
		 * using lambda expressions to implement a user defined functional interface
		 */
		int a = 5;
		
		// lambda expression to define the calculate method
		Square s = (int x) -> x * x;
		
		// parameter passed and return type must be
		// same as defined in the prototype
		int ans = s.calculate(a);
		System.out.println(ans);

	}

}
