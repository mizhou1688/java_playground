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
 * Type 3: Static Nested Classes
 * Static nested classes are not technically inner classes. 
 * They are like a static member of outer class.
 * 
 */

//Outer class
class Outer2 {
	// Method
	private static void outerMethod() {
		// Print statement
		System.out.println("inside outerMethod");
	}
	
	// Static inner class
	static class Inner {
		public static void pr() {
			// Print statement
			System.out.println("inside inner class Method - pr");
		}
		public static void display() {
			// Print statement
			System.out.println("inside inner class Method");
			
			// Calling method in the same class
			pr();
			
			// Calling method in the outer class
			outerMethod();
		}
	}
}


public class Static_nested_class {
    // Main driver method
    public static void main(String args[]) {
    	
    	// Calling method static display method 
    	// rather than an instance of that class.
    	Outer2.Inner.display();
    }

}

