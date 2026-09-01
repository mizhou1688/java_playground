package test;
/**
 * Covariant return type refers to the return type of an overriding method. 
 * This statement means that the return type of the sub-class method can be 
 * a covariant (may vary in the same direction) of the parent method’s return 
 * type.
 * 
 */

//parent class
class Car {
	Car get() {
		System.out.println("This is the Car class.");
		return this;
	}    
} 
   
// child class 
class BMW extends Car {
@Override  
	// overloading the get method
    BMW get() {
		System.out.println("This is the BMW class.");
		return this;
	}
}


public class Covariant_Return_Type {
	public static void main(String args[]) {
		Car MyCar = new BMW();
		MyCar.get();
	}
}
