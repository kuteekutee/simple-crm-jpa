package sg.ntu.edu.simplecrm;

import java.util.List;

public interface CustomerService {
  public Customer createCustomer(Customer customer);
  public Customer getCustomer(int id);
  public List<Customer> getAllCustomers();
  public Customer updateCustomer(int id, Customer customer);
  public void deleteCustomer(int id);
  public Interactions addInteractionToCustomer(int id, Interactions interaction);
}
