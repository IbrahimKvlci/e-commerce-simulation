package eCommerceSimulation;

import eCommerceSimulation.business.abstracts.CustomerService;
import eCommerceSimulation.business.concretes.CustomerManager;
import eCommerceSimulation.core.EMailConfirmationManager;
import eCommerceSimulation.core.GoogleAuthorizationManager;
import eCommerceSimulation.dataAccess.concretes.MyCustomerDao;
import eCommerceSimulation.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		CustomerService customerService=new CustomerManager(new MyCustomerDao(),new EMailConfirmationManager(),new GoogleAuthorizationManager());
		
		Customer customer1=new Customer(1,"User","User","user@gmail.com","123456");
		Customer customer2=new Customer(2,"User2","User2","user2@gmail.com","123456");
		
		customerService.add(customer1);
		customerService.add(customer2);
		
		customerService.verify(customer1);
		customerService.verify(customer2);
		
		customerService.loginWithAuthorizationService();
		customerService.login("user@gmail.com", "123456");
	}

}
