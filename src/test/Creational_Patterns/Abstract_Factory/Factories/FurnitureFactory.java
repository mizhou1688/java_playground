package test.Creational_Patterns.Abstract_Factory.Factories;

import test.Creational_Patterns.Abstract_Factory.Chairs.Chair;
import test.Creational_Patterns.Abstract_Factory.CoffeeTables.CoffeeTable;
import test.Creational_Patterns.Abstract_Factory.Sofas.Sofa;

public interface FurnitureFactory {
	Chair creatChair();
	CoffeeTable createCoffeeTable();
	Sofa createSofa();
}
