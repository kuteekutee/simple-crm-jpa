package sg.ntu.edu.simplecrm;


//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service is where we will put our business logic (i.e. decisions, procesing, computations, etc.)
// Service layer will call the repository layer to update the data store.
// CustomerService will need an instance of CustomerRepository
// Remember concept of composition?
// SelfServiceMachine
// Vending Machine IS A SelfServiceMachine (Inheritance)
// Vending Machine HAS A Cashbox (Composition)

@Service
public class CustomerServiceImpl implements CustomerService {

  // private CustomerRepository customerRepository = new CustomerRepository();

  // Field-based injection
  @Autowired
  private CustomerRepository customerRepository;
  //private CustomerRepository customerRepository;

  // Constructor-based injection
  // @Autowired
  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }
  @Autowired
  private InteractionRepository interactionRepository;
  // CustomerServiceImpl(mockRepository)

  // Create
  @Override
  public Customer createCustomer(Customer customer) {
    Customer newCustomer = customerRepository.save(customer);
    return newCustomer;
  }

  // Get One
  @Override
  public Customer getCustomer(int id) {
    Customer foundCustomer = customerRepository.findById(id).get();
    return foundCustomer;
  }

  // Get All
  @Override
  public List<Customer> getAllCustomers() {
    List<Customer> allCustomers = customerRepository.findAll();
    return (List<Customer>)allCustomers;
  }

  // Update
  @Override
  public Customer updateCustomer(int id, Customer customer) {
    // retrieve customer from db
    Customer customerToUpdate = customerRepository.findById(id).get();
      // Update the customer retrieved from DB
      customerToUpdate.setFirstName(customer.getFirstName());
      customerToUpdate.setLastName(customer.getLastName());
      customerToUpdate.setEmail(customer.getEmail());
      customerToUpdate.setContactNo(customer.getContactNo());
      customerToUpdate.setJobTitle(customer.getJobTitle());
      customerToUpdate.setYob(customer.getYob());
  
      // Save and return the data
    return customerRepository.save(customerToUpdate);
  }

  // Delete
  @Override
  public void deleteCustomer(int id) {
    customerRepository.deleteById(id);
  }

  @Override
  public Interactions addInteractionToCustomer(int id, Interactions interaction) {
    Customer selectedCustomer = customerRepository.findById(id).get();
    interaction.setCustomer(selectedCustomer);
    return interactionRepository.save(interaction);

  }

}
