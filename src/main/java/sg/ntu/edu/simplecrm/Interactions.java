package sg.ntu.edu.simplecrm;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "interactions")
public class Interactions {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "remarks")
  private String remarks;
  @Column(name = "interaction_date")
  private LocalDate interactionDate;

  @ManyToOne(optional = false)
  @JoinColumn(name ="customer_id", referencedColumnName = "id")
  private Customer customer;
  
  public Customer getCustomer() {
    return customer;
  }
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getRemarks() {
    return remarks;
  }
  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }
  public LocalDate getInteractionDate() {
    return interactionDate;
  }
  public void setInteractionDate(LocalDate intereactionDate) {
    this.interactionDate = intereactionDate;
  }
 
 
}
