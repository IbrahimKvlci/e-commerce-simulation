package eCommerceSimulation.business.abstracts;

import eCommerceSimulation.entities.concretes.Customer;

public interface CustomerService {
	void add(Customer customer);
	void verify(Customer customer);
	void login(String email, String password);
	void loginWithAuthorizationService();
}
