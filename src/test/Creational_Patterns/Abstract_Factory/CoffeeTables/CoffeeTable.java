package test.Creational_Patterns.Abstract_Factory.CoffeeTables;

import test.Creational_Patterns.Abstract_Factory.Furniture;

public interface CoffeeTable extends Furniture {
	final boolean hasLegs = true;
	final boolean sitOn = false;
	final String category ="CoffeeTable";
	default boolean hasLegs() {
		return hasLegs;
	};
	default boolean sitOn() {
		return sitOn;
	};
	default String category() {
		return category;
	}
}
