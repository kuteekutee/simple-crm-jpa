package sg.ntu.edu.simplecrm;

import java.util.ArrayList;

public interface CustomerService {
  public Customer createCustomer(Customer customer);
  public Customer getCustomer(int id);
  public ArrayList<Customer> getAllCustomers();
  public Customer updateCustomer(int id, Customer customer);
  public void deleteCustomer(int id);
  public Interactions addInteractionToCustomer(int id, Interactions interaction);
}
