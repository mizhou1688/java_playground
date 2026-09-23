package test.Creational_Patterns.Abstract_Factory.Sofas;

import test.Creational_Patterns.Abstract_Factory.Furniture;

public interface Sofa extends Furniture {
	final boolean hasLegs = true;
	final boolean sitOn = true;
	final String category ="Sofa";
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
