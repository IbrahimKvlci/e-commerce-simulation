package eCommerceSimulation.core;


public class EMailConfirmationManager implements ConfirmationService{

	@Override
	public void sendConfirmationLink(String address) {
		System.out.println("A confirmation link has been sent to: "+address);
		
	}

	@Override
	public boolean verify(String address) {
		System.out.println("Your email address has been confirmed!");
		return true;
	}

	


}
