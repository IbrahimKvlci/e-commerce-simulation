package eCommerceSimulation.business.concretes;

import eCommerceSimulation.business.abstracts.CustomerService;
import eCommerceSimulation.core.AuthorizationService;
import eCommerceSimulation.core.ConfirmationService;
import eCommerceSimulation.dataAccess.abstracts.CustomerDao;
import eCommerceSimulation.entities.concretes.Customer;

public class CustomerManager implements CustomerService{

	private CustomerDao customerDao;
	private ConfirmationService confirmationService;
	private AuthorizationService authorizationService;
	
	public CustomerManager(CustomerDao customerDao,ConfirmationService confirmationService,AuthorizationService authorizationService) {
		super();
		this.customerDao = customerDao;
		this.confirmationService=confirmationService;
		this.authorizationService=authorizationService;
	}

	@Override
	public void add(Customer customer) {
		if(customer.getEmail().isEmpty()||customer.getPassword().isEmpty()||customer.getName().isEmpty()||customer.getSurname().isEmpty()) {
			System.out.println("Required fields cannot be empty! Please fill the required fields");
			return;
		}
		if(customerDao.isThereCustomerWithSpecificEMail(customer.getEmail())) {
			System.out.println("This email is already used!");
			return;
		}
		if(customer.getPassword().length()<6) {
			System.out.println("Password cannot be less than 6 characters");
			return;
		}
		if(!customer.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
			System.out.println("Given email is not valid");
			return;
		}
		if(customer.getName().length()<2||customer.getSurname().length()<2) {
			System.out.println("Name and surname cannot be less than 2 characters");
			return;
		}
		
		confirmationService.sendConfirmationLink(customer.getEmail());
	}

	@Override
	public void verify(Customer customer) {
		if(this.confirmationService.verify(customer.getEmail()))
			this.customerDao.add(customer);
	}

	@Override
	public void loginWithAuthorizationService() {
		this.authorizationService.authorize();
		
	}

	@Override
	public void login(String email, String password) {
		Customer customer=customerDao.getByEmail(email);
		if(customer!=null) {
			if(customer.getPassword().equals(password)) {
				System.out.println("You successfully logged in!");
				return;
			}
		}
		System.out.println("The email address or password is incorrect!");
		
	}

}
