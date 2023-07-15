package sg.ntu.edu.simplecrm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  // 1st - is the entity to save 
  // 2nd - the data type of id
  // Spring JPA will implement everything
  // It will then become a bean in IOC

  
}
