package test;

/**
 *  Nested interfaces can be used for a variety of purposes, including:
 *  1.	To group related interfaces together: 
 *  	By nesting one interface within another, you can organize related 
 *  	interfaces in a more logical and readable way. This can make your 
 *  	code easier to understand and maintain.
 *  
 *  2.	To create more secure code: 
 *  	By making an interface nested inside a class, you can limit its scope 
 *  	and prevent it from being accessed outside of that class. This can 
 *  	make your code more secure and less	prone to errors.
 *  
 *  3.	To implement multiple interfaces: 
 *  	By nesting interfaces, you can implement multiple interfaces in a 
 *  	single class, without cluttering up the global namespace with too 
 *  	many interface names.
 *  
 *  4.	To create callbacks: 
 *  	Nested interfaces can be used to create callback functions, where 
 *  	an object can be passed to another object and that object can call 
 *  	back a method defined in the nested interface.
 *  
 *  5.	To define a contract between classes: 
 *  	By using nested interfaces, you can define a contract between classes, 
 *  	where each class implements	the same interface, but provides its own 
 *  	implementation. This can make your code more modular and easier to test.
 */

class Test1 {
    protected interface Yes {
        void show();
    }
}
 
class Testing1 implements Test1.Yes {
    public void show()
    {
        System.out.println("show method of interface");
    }
}
 
// Driver Class
class A {
    // main function
    public static void main(String[] args)
    {
        Test1.Yes obj;
        Testing1 t = new Testing1();
        obj = t;
        obj.show();
    }
}


public class Nested_interface {
	
	// Nested interface inside a class
	public interface NestedInterface {
		public void nestedMethod();
	}
	
	public static void main(String[] args) {
		// Implement nested interface
		NestedInterface nested = new NestedInterface() {
			public void nestedMethod() {
				System.out.println("Hello from nested interface!");
			}
		};
		
		// Call nested interface method
		nested.nestedMethod();
    }
}
