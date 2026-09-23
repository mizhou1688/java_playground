package test.Creational_Patterns.Abstract_Factory;

import test.Creational_Patterns.Abstract_Factory.App.Application;
import test.Creational_Patterns.Abstract_Factory.Factories.FurnitureFactory;
import test.Creational_Patterns.Abstract_Factory.Factories.ModernFurnitureFactory;
import test.Creational_Patterns.Abstract_Factory.Factories.VictorianFurnitureFactory;

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
			// TODO Auto-generated method stub
	        Application app = configureApplication();
	        app.listProducts();
		}
}
