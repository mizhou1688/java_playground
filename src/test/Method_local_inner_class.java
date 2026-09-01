package test;
/**
 * There are certain advantages associated with inner classes are as follows:
 * 1.	Making code clean and readable.
 * 2.	Private methods of the outer class can be accessed, 
 * 		so bringing a new dimension and making it closer to the real world.
 * 3	Optimizing the code module.
 * 
 * There are basically four types of inner classes in java.
 * 1.	Nested Inner Class / Member Inner Class
 * 		It is a non-static class that is defined at the member level 
 * 		of a class. It has access to all the members of the outer class, 
 * 		including private members.
 * 
 * 2.	Method Local Inner Classes / Local Inner Classes
 * 		It is a class that is defined inside a method or a block of code. 
 * 		It has access to the final variables of the method or block in 
 * 		which it is defined.
 * 
 * 3.	Static Nested Classes
 * 		It is a static class that is defined inside another class. 
 * 		It does not have access to the non-static members of the 
 * 		outer class.
 * 
 * 4.	Anonymous Inner Classes
 * 		It is a class that is defined inline and has no name. It is 
 * 		used to implement interfaces or extend classes without creating 
 * 		a separate class.
 * 
 * 
 * Type 2: Method Local Inner Classes 
 * Inner class can be declared within a method of an outer 
 * class which we will be illustrating in the below example 
 * where Inner is an inner class in outerMethod().
 * 
 * Method Local inner classes can’t use a local variable of the 
 * outer method unless that local variable is declared as final.
 * While this statement was strictly true in Java 7 and earlier, 
 * since Java 8 it has been relaxed to include variables that 
 * are "effectively final."
 */

//Outer class
class Outer1 {

	// Method inside outer class
	void outerMethod() {
		
		int x = 10; // Effectively final (never reassigned)
	    final int y = 20; // Explicitly final
	    int z = 30;
	    z = 35; // Modified! Not effectively final
	    
		// Print statement
		System.out.println("inside outerMethod");

		// Inner class
		// It is local to outerMethod()
		class Inner {

			// Method defined inside inner class
			void innerMethod() {
				// Print statement whenever inner class is called
				System.out.println("inside innerMethod");
				System.out.println(x); // Valid! Treated as effectively final
                System.out.println(y); // Valid! Explicitly final
                // System.out.println(z); // COMPILER ERROR: Must be final or effectively final
			}
		}
		
		// Creating object of inner class
		Inner inn = new Inner();
		
		// Calling over method defined inside it
		inn.innerMethod();
	 }
}


public class Method_local_inner_class {
	// Main driver method
    public static void main(String[] args) {
    	
    	// Creating object of outer class inside main() method
        Outer1 x = new Outer1();
 
        // Calling over the same method
        // as we did for inner class above
        x.outerMethod();
	}
}

