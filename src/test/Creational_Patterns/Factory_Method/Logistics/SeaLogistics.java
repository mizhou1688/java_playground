package test.Creational_Patterns.Factory_Method.Logistics;

import test.Creational_Patterns.Factory_Method.Transport.Ship;
import test.Creational_Patterns.Factory_Method.Transport.Transport;

public class SeaLogistics implements Logistics {

	@Override
	public void planDelivery() {
		// TODO Auto-generated method stub

	}

	@Override
	public Transport createTransport() {
		return new Ship();
	}

}
