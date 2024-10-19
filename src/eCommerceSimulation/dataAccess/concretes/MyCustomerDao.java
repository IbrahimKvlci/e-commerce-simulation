package eCommerceSimulation.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSimulation.dataAccess.abstracts.CustomerDao;
import eCommerceSimulation.entities.concretes.Customer;

public class MyCustomerDao implements CustomerDao{

	List<Customer> customerList=new ArrayList<Customer>();
	
	@Override
	public void add(Customer customer) {
		customerList.add(customer);
		System.out.println(customer.getName()+" was added!");
		
	}

	@Override
	public void update(Customer customer) {
		System.out.println(customer.getName()+" was updated!");
		
	}

	@Override
	public void delete(Customer customer) {
		System.out.println(customer.getName()+" was deleted!");
		
	}

	@Override
	public boolean isThereCustomerWithSpecificEMail(String email) {
		for (Customer customer : customerList) {
			if(customer.getEmail().equals(email))
				return true;
		}
		return false;
	}

	@Override
	public Customer getByEmail(String email) {
		for (Customer customer : customerList) {
			if(customer.getEmail().equals(email)) {
				return customer;
			}
		}
		return null;
	}


}
