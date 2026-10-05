package test.Creational_Patterns.Factory_Method.Logistics;

import test.Creational_Patterns.Factory_Method.Transport.Transport;
import test.Creational_Patterns.Factory_Method.Transport.Truck;

public class RoadLogistics implements Logistics {

	@Override
	public void planDelivery() {
		// TODO Auto-generated method stub

	}

	@Override
	public Transport createTransport() {
		return new Truck();
	}
}
