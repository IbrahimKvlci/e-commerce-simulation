package eCommerceSimulation.dataAccess.abstracts;

import eCommerceSimulation.entities.concretes.Customer;

public interface CustomerDao {
	void add(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	Customer getByEmail(String email);
	boolean isThereCustomerWithSpecificEMail(String email);
}
