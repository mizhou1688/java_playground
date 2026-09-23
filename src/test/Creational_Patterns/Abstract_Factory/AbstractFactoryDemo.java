package test.Creational_Patterns.Abstract_Factory;

import test.Creational_Patterns.Abstract_Factory.App.Application;
import test.Creational_Patterns.Abstract_Factory.Factories.FurnitureFactory;
import test.Creational_Patterns.Abstract_Factory.Factories.ModernFurnitureFactory;
import test.Creational_Patterns.Abstract_Factory.Factories.VictorianFurnitureFactory;

/**
 * Abstract Factory is a creational design pattern that lets you produce families
 * of related objects without specifying their concrete classes.
 * 
 * The first thing the Abstract Factory pattern suggests is to explicitly declare 
 * interfaces for each distinct product of the product family. Then you can make 
 * all variants of products follow those interfaces.
 * 	Creational_Patterns/Abstract_Factory/Chairs/Chair.java
 * 	Creational_Patterns/Abstract_Factory/CoffeeTables/CoffeeTables.java
 * 	Creational_Patterns/Abstract_Factory/Sofas/Sofa.java
 * 
 * The next move is to declare the Abstract Factory—an interface with a list of 
 * creation methods for all products that are part of the product family (for example, 
 * createChair, createSofa and createCoffeeTable). These methods must return abstract 
 * product types represented by the interfaces we extracted previously.
 * 	Creational_Patterns/Abstract_Factory/Factories/FurnitureFactory.java
 * 
 * How about the product variants? For each variant of a product family, we create 
 * a separate factory class based on the AbstractFactory interface. A factory is a 
 * class that returns products of a particular kind.
 * 	Creational_Patterns/Abstract_Factory/Factories/ModernFurnitureFactory.java
 * 	Creational_Patterns/Abstract_Factory/Factories/VictorianFurnitureFactory.java
 * 
 * The client code has to work with both factories and products via their respective 
 * abstract interfaces. This lets you change the type of a factory that you pass to 
 * the client code, as well as the product variant that the client code receives, 
 * without breaking the actual client code.
 * 	Creational_Patterns/Abstract_Factory/App/Application.java
 *  
 * Say the client wants a factory to produce a chair. The client doesn’t have to be 
 * aware of the factory’s class, nor does it matter what kind of chair it gets. 
 * Whether it’s a Modern model or a Victorian-style chair, the client must treat all 
 * chairs in the same manner, using the abstract "Chair" interface. With this approach, 
 * the only thing that the client knows about the chair is that it implements the 
 * sitOn() method in some way. Also, whichever variant of the chair is returned, 
 * it’ll always match the type of sofa or coffee table produced by the same factory 
 * object.
 *  
 * If the client is only exposed to the abstract interfaces, what creates the actual 
 * factory objects? Usually, the application creates a concrete factory object at the 
 * initialization stage. Just before that, the app must select the factory type 
 * depending on the configuration or the environment settings.
 * 	Creational_Patterns/Abstract_Factory/AbstractFactoryDemo.java
 *  
 */

public class AbstractFactoryDemo {
	
	private static Application configureApplication() {
		Application app;
		FurnitureFactory factory;
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("mac")) {
			factory = new ModernFurnitureFactory();
		} else {
			factory = new VictorianFurnitureFactory();
		}
		app = new Application(factory);
		return app;
	}
	
	public static void main(String[] args) {
		Application app = configureApplication();
		app.listProducts();
	}
}
