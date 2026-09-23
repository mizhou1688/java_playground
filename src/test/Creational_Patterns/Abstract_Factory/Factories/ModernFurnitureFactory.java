package test.Creational_Patterns.Abstract_Factory.Factories;

import test.Creational_Patterns.Abstract_Factory.Chairs.Chair;
import test.Creational_Patterns.Abstract_Factory.Chairs.ModernChair;
import test.Creational_Patterns.Abstract_Factory.CoffeeTables.CoffeeTable;
import test.Creational_Patterns.Abstract_Factory.CoffeeTables.ModernCoffeeTable;
import test.Creational_Patterns.Abstract_Factory.Sofas.ModernSofa;
import test.Creational_Patterns.Abstract_Factory.Sofas.Sofa;

public class ModernFurnitureFactory implements FurnitureFactory {

	@Override
	public Chair creatChair() {
		return new ModernChair(11, 13, 26, "yellow", "wood & leather", 1 );
	};
	
	@Override
	public CoffeeTable createCoffeeTable() {
		return new ModernCoffeeTable(122, 52, 77, "silver", "wood & glass");
	};
	
	@Override
	public Sofa createSofa() {
		return new ModernSofa(103, 15, 53, "golden", "Wood & febric", 3 );
	};

}
