package test;

/**
 * The primary purpose of a java Singleton class is to 
 * restrict the limit of the number of object creations 
 * to only one. This often ensures that there is access 
 * control to resources, for example, socket or database 
 * connection.
 * 
 * There are two forms of singleton design patterns, which are:
 * 1.	Early Instantiation: The object creation takes place at 
 * 		the load time.
 * 2.	Lazy Instantiation: The object creation is done according 
 * 		to the requirement.
 * 
 * while defining a class as a singleton class:
 *  1.	Make a constructor private.
 *  2.	Write a static method that has the return type 
 *  	object of this singleton class. Here, the concept of 
 *  	Lazy initialization is used to write this static method.
 *  
 */


//Java program implementing Singleton class
//with method name as that of class

//Class 1
//Helper class
class Singleton {
	 // Static variable single_instance of type Singleton
	 private static Singleton single_instance = null;
	
	 // Declaring a variable of type String
	 public String s;
	
	 // Constructor of this class
	 // Here private constructor is used to
	 // restricted to this class itself
	 private Singleton()
	 {
	     s = "Hello I am a string part of Singleton class";
	 }
	
	 // Method
	 // Static method to create instance of Singleton class
	 public static Singleton Singleton()
	 {
	     // To ensure only one instance is created
	     if (single_instance == null) {
	         single_instance = new Singleton();
	     }
	     return single_instance;
	 }
}


public class Singleton_design_pattern {
	
    // Main driver method
    public static void main(String args[])
    {
        // Instantiating Singleton class with variable x
        Singleton x = Singleton.Singleton();
 
        // Instantiating Singleton class with variable y
        Singleton y = Singleton.Singleton();
 
        // instantiating Singleton class with variable z
        Singleton z = Singleton.Singleton();
 
        if (x == y && x == z)
        	System.out.println("x, y and z are pointing to the same instance.");
        else
        	System.out.println("x, y and z are NOT pointing to the same instance.");
        
        // Now  changing variable of instance x
        // via toUpperCase() method
        x.s = (x.s).toUpperCase();
 
        // Print and display commands
        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");
 
        // Now again changing variable of instance z
        z.s = (z.s).toLowerCase();
 
        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
    }

}
