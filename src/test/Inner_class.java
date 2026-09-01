package test;

/**
 * Inner class
 * There are certain advantages associated with inner classes are as follows:
 * •	Making code clean and readable.
 * •	Private methods of the outer class can be accessed, so bringing a new 
 * 		dimension and making it closer to the real world.
 * •	Optimizing the code module.
 * 
 * An inner class can access the members of the outer class, including 
 * private members, and it can be used to implement callbacks and event 
 * handlers. 
 * 
 * There are basically four types of inner classes in java.
 * 1.	Nested Inner Class (Member Inner Class)
 * 		It is a non-static class that is defined at the member level of a 
 * 		class. It has access to all the members of the outer class, including 
 * 		private members.
 * 
 * 2.	Method Local Inner Classes
 * 		It is a class that is defined inside a method or a block of code. 
 * 		It has access to the final variables of the method or block in 
 * 		which it is defined.
 * 
 * 3.	Static Nested Classes
 * 		It is a static class that is defined inside another class. It 
 * 		does not have access to the non-static members of the outer class.
 * 
 * 4.	Anonymous Inner Classes
 * 		It is a class that is defined inline and has no name. It is used to 
 * 		implement interfaces or extend classes without creating a separate class.
 */

/**
 * Type 1: Nested Inner Class 
 * It can access any private instance variable of the outer class. 
 * Like any other instance variable, we can have access modifier private, 
 * protected, public, and default modifier. Like class, an interface can 
 * also be nested and can have access specifies. 
 */

//Class 1
//Helper classes
class Outer3 {
	// Class 2
	// Simple nested inner class
	class Inner {
		
		// show() method of inner class
		public void show() {
			// Print statement
			System.out.println("In a nested class method");
		}
	}
}

/**
 * Type 2: Method Local Inner Classes 
 * Inner class can be declared within a method of an outer class which 
 * we will be illustrating in the below example where Inner is an inner 
 * class in outerMethod().
 */
//Class 1
//Outer class
class Outer4 {
	// Method inside outer class
	void outerMethod() {
		
		// Print statement
		System.out.println("inside outerMethod");
		
		// Class 2
		// Inner class
		// It is local to outerMethod()
		class Inner {
			
			// Method defined inside inner class
			void innerMethod() {
				// Print statement whenever inner class is
				// called
				System.out.println("inside innerMethod");
			}
		}
		
		// Creating object of inner class
		Inner y = new Inner();
		
		// Calling over method defined inside it
		y.innerMethod();
	}
}

/**
 * Type 3: Static Nested Classes
 * Static nested classes are not technically inner classes. 
 * They are like a static member of outer class.
 */
//Class 1
//Outer class
class Outer5 {
	
	// Method
	private static void outerMethod() {
		
		// Print statement
		System.out.println("inside static outerMethod");
	}
	
	// Class 2
	// Static inner class
	static class Inner {
		
		public static void display() {
			
			// Print statement
			System.out.println("inside inner class Method");
			
			// Calling method inside main() method
			outerMethod();
		}
	}
}

/**
 * Type 4: Anonymous Inner Classes 
 * Anonymous inner classes are declared without any name at all. 
 * They are created in two ways.
 * •	As a subclass of the specified type
 * •	As an implementer of the specified interface
 * 
 * Any anonymous inner class can implement only one interface at one time. 
 * It can either extend a class or implement an interface at a time.
 */

/**
 * Way 1: As a subclass of the specified type 
 */
//Class 1
//Helper class
class Demo1 {
	
	// Method of helper class
	void show() {
		// Print statement
		System.out.println("i am in show method of super class");
	}
}

//Class 2
//Main class
class Flavor1Demo1 {
	
	//  An anonymous class with Demo as base class
	static Demo1 d = new Demo1() {
		// Method 1
		// show() method
		void show() {
			// Calling method show() via super keyword 
			// which refers to parent class
			super.show();
			
			// Print statement
			System.out.println("i am in Flavor1Demo1 class");
		}
	};
}

/**
 * Way 2: As an implementer of the specified interface  
 */
//Interface
interface Hello1 {
	
	// Method defined inside interface
	void show();
}

//Main class
class GFG1 {
	
	// Class implementing interface
	static Hello1 h = new Hello1() {
		
		// Method 1
		// show() method inside main class
		public void show() {
			
			// Print statement
			System.out.println("i am in anonymous class");
		}
	};
}


public class Inner_class {
	// Main driver method
	public static void main(String[] args) {
		
		/**
		 * 1.	Nested Inner Class
		 */
		// Note how inner class object is created inside main()
		Outer3.Inner in = new Outer3().new Inner();
		// Calling show() method over above object created
		in.show();
		
		/**
		 * 2.	Method Local Inner Classes 
		 */
		// Creating object of outer class inside main() method
		Outer4 x = new Outer4();
		// Calling over the same method as we did for inner class above
		x.outerMethod();
		
		/**
		 * 3.	Static Nested Classes
		 */
	     // Calling method static display method rather than an instance of that class.
	     Outer5.Inner.display();
	     
	     /**
	      * 4.	Anonymous Inner Classes
	      * As a subclass of the specified type
	      */
	     Flavor1Demo1.d.show();
	     
	     /**
	      * 4.	Anonymous Inner Classes
	      * As an implementer of the specified interface
	      */
	     GFG1.h.show();
	}

}
