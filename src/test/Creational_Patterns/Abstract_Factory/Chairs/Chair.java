package test.Creational_Patterns.Abstract_Factory.Chairs;

import test.Creational_Patterns.Abstract_Factory.Furniture;

public interface Chair extends Furniture {
	final boolean hasLegs = true;
	final boolean sitOn = true;
	final String category ="Chair";
	default boolean hasLegs() {
		return hasLegs;
	};
	default boolean sitOn() {
		return sitOn;
	};
	default String category() {
		return category;
	}
	int numberOfPeopleCanSitOn();
}
