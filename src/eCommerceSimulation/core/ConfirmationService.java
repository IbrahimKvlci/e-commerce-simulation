package eCommerceSimulation.core;


public interface ConfirmationService {
	void sendConfirmationLink(String address);
	boolean verify(String address);
}
