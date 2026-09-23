package test.Creational_Patterns.Abstract_Factory.App;

import test.Creational_Patterns.Abstract_Factory.Chairs.Chair;
import test.Creational_Patterns.Abstract_Factory.CoffeeTables.CoffeeTable;
import test.Creational_Patterns.Abstract_Factory.Factories.FurnitureFactory;
import test.Creational_Patterns.Abstract_Factory.Sofas.Sofa;

public class Application {
	private Chair chair;
	private Sofa sofa;
	private CoffeeTable coffeeTable;
	
	public Application (FurnitureFactory factory) {
		chair = factory.creatChair();
		sofa = factory.createSofa();
		coffeeTable = factory.createCoffeeTable();
	}
	public void listProducts() {
		System.out.println(chair.style() + ' ' + chair.category());
		System.out.println(sofa.style() + ' ' + sofa.category());
		System.out.println(coffeeTable.style() + ' ' + coffeeTable.category());
	}
}
