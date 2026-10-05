package test.Creational_Patterns.Factory_Method.Transport;

public class Truck implements Transport {

	@Override
	public void delivery() {
		System.out.println("Deliver by land in a box.");
	}

}
