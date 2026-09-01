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
 * Type 1: Nested Inner Class 
 * It can access any private instance variable of the outer class. 
 * Like any other instance variable, we can have access modifier 
 * private, protected, public, and default modifier. Like class, 
 * an interface can also be nested and can have access specifies. 
 * 
 */

//Helper classes
class Outer {
	 // Simple nested inner class
	 class Inner {
	     // show() method of inner class
	     public void show() {
	         // Print statement
	         System.out.println("In a nested class method");
	     }
	 }
}

public class Nested_inner_class {
	// Main driver method
    public static void main(String[] args) {
 
        // Note how inner class object is created inside
        // main()
        Outer.Inner in = new Outer().new Inner();
 
        // Calling show() method over above object created
        in.show();
    }
}

/**
 * Note:  
 * We cannot have a static method in a nested inner class 
 * because an inner class is implicitly associated with an object 
 * of its outer class so it cannot define any static method for 
 * itself. But Since JAVA Version 16 we can have static members 
 * in our inner class also.
 */

