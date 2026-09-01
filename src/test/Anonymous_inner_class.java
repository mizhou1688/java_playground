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
 * Type 4: Anonymous Inner Classes 
 * Anonymous inner classes are declared without any name at all. They are 
 * created in two ways.
 * 1.	As a subclass of the specified type
 * 2. 	As an implementer of the specified interface
 * 
 */

//Java Program to Illustrate Anonymous Inner classes 
//Declaration Without any Name  
//As a subclass of the specified type

//Helper class
class Demo {
	// Method of helper class
	void show() {
		// Print statement
		System.out.println("i am in show method of super class");
	}
}

//Main class
class Flavor1Demo { //  An anonymous class with Demo as base class
	static Demo d = new Demo() {
		// show() method
		void show() {
			// Calling method show() via super keyword
			// which refers to parent class
			super.show();
			// Print statement
			System.out.println("i am in Flavor1Demo class");
		}
	};
	
	// Main driver method
	public static void test() {
		// Calling show() method inside test() method
		d.show();
	}
}

/**
 * In the above code, we have two classes Demo and Flavor1Demo. 
 * Here demo act as a super-class and the anonymous class acts 
 * as a subclass, both classes have a method show(). In anonymous 
 * class show() method is overridden.
 */

//Java Program to Illustrate Anonymous Inner Classes
//Declaration Without Any Name
//As an implementer of Specified interface

//Interface
interface Hello {
	// Method defined inside interface
	void show();
}

//Main class
class GFG {
	// Class implementing interface
	static Hello h = new Hello() {
		// show() method inside main class
		public void show() {
			// Print statement
			System.out.println("i am in anonymous class");
		}
	};
	// Main driver method
	public static void test() {
		// Calling show() method inside test() method
		h.show();
	}
}

/**
 * In the above code, we create an object of anonymous inner class 
 * but this anonymous inner class is an implementer of the interface 
 * Hello. Any anonymous inner class can implement only one interface 
 * at one time. It can either extend a class or implement an interface 
 * at a time.
 */

public class Anonymous_inner_class {
	public static void main(String[] args) {
		Flavor1Demo.test();
		GFG.test();
	}
}
