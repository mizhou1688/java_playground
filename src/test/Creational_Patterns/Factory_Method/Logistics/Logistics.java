package test.Creational_Patterns.Factory_Method.Logistics;

import test.Creational_Patterns.Factory_Method.Transport.Transport;

public interface Logistics {
	void planDelivery();
	Transport createTransport();
}
