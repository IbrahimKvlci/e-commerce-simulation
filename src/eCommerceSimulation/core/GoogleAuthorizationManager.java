package eCommerceSimulation.core;

import eCommerceSimulation.googleAuthorization.GoogleAuthorization;

public class GoogleAuthorizationManager implements AuthorizationService{

	@Override
	public void authorize() {
		GoogleAuthorization googleAuthorization=new GoogleAuthorization();
		googleAuthorization.login();
		
	}

}
