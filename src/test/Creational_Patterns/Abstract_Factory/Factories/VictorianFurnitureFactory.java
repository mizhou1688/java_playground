package test.Creational_Patterns.Abstract_Factory.Factories;

import test.Creational_Patterns.Abstract_Factory.Chairs.Chair;
import test.Creational_Patterns.Abstract_Factory.Chairs.VictorianChair;
import test.Creational_Patterns.Abstract_Factory.CoffeeTables.CoffeeTable;
import test.Creational_Patterns.Abstract_Factory.CoffeeTables.VictorianCoffeeTable;
import test.Creational_Patterns.Abstract_Factory.Sofas.Sofa;
import test.Creational_Patterns.Abstract_Factory.Sofas.VictorianSofa;

public class VictorianFurnitureFactory implements FurnitureFactory {
	@Override
	public Chair creatChair() {
		return new VictorianChair(10, 12, 25, "red", "wood & leather", 1 );
	};
	
	@Override
	public CoffeeTable createCoffeeTable() {
		return new VictorianCoffeeTable(120, 50, 75, "blue", "wood & glass");
	};
	
	@Override
	public Sofa createSofa() {
		return new VictorianSofa(100, 12, 50, "green", "Wood & febric", 3 );
	};
}
