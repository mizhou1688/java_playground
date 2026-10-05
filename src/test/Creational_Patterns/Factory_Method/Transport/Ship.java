package test.Creational_Patterns.Factory_Method.Transport;

public class Ship implements Transport {

	@Override
	public void delivery() {
		System.out.println("Deliver by see in a container.");
	}
}
