package test.Creational_Patterns.Factory_Method;

import test.Creational_Patterns.Factory_Method.Logistics.Logistics;
import test.Creational_Patterns.Factory_Method.Logistics.RoadLogistics;
import test.Creational_Patterns.Factory_Method.Logistics.SeaLogistics;

/**
 * Factory Method is a creational design pattern that provides an interface
 *  for creating objects in a superclass, but allows subclasses to alter the 
 *  type of objects that will be created.
 * 
 * The Factory Method pattern suggests that you replace direct object 
 * construction calls (using the "new" operator) with calls to a special 
 * factory method. Don’t worry: the objects are still created via the "new" 
 * operator, but it’s being called from within the factory method. Objects 
 * returned by a factory method are often referred to as products.
 * 
 * At first glance, this change may look pointless: we just moved the constructor 
 * call from one part of the program to another. However, consider this: now you can 
 * override the factory method in a subclass and change the class of products being 
 * created by the method.
 * 
 * There’s a slight limitation though: subclasses may return different types of 
 * products only if these products have a common base class or interface. Also, the 
 * factory method in the base class should have its return type declared as this 
 * interface.
 * 
 */
public class Factory_Method_Demo {

	private static Logistics logistic;
	public static void main(String[] args) {
		configure();
        runBusinessLogic();
	}
	/**
     * The concrete factory is usually chosen depending on configuration or
     * environment options.
     */
	static void configure() {
		if (System.getProperty("os.name").equals("Windows 11")) {
			logistic = new RoadLogistics();
		} else {
			logistic = new SeaLogistics();
		}
    }

    /**
     * All of the client code should work with factories and products through
     * abstract interfaces. This way it does not care which factory it works
     * with and what kind of product it returns.
     */
	static void runBusinessLogic() {
		logistic.createTransport().delivery();
	}



}
