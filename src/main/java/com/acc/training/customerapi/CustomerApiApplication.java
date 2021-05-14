package com.acc.training.customerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApiApplication {

    /*
    @Autowired
    private CustomerRepository repository;
	*/

	public static void main(String[] args) {
		SpringApplication.run(CustomerApiApplication.class, args);
	}

    /*
	@EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        createCustomer();
        
    }

	private void createCustomer() {
        Customer newCustomer = new Customer();
        newCustomer.setCustomerId(12345);
        newCustomer.customerName("Rahul Anand");
        newCustomer.customerAddress("Hartford, CT");
        
        System.out.println("Saving new customer...");

        this.repository.save(newCustomer);
    }
    */
    


}
