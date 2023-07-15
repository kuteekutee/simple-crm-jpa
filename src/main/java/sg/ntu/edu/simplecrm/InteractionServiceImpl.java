package sg.ntu.edu.simplecrm;


import java.util.ArrayList;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {


  private InteractionRepository interactionRepository;

  // Constructor-based injection
  // @Autowired
  public InteractionServiceImpl(InteractionRepository interactionRepository) {
    this.interactionRepository = interactionRepository;
  }
  
  // CustomerServiceImpl(mockRepository)

  // Create
  @Override
  public Interactions createInteraction(Interactions interaction) {
    Interactions newInteraction = interactionRepository.save(interaction);
    return newInteraction;
  }

  // Get One
  @Override
  public Interactions getInteraction(int id) {
    Interactions found = interactionRepository.findById(id).get();
    return found;
  }

  // Get All
  @Override
  public ArrayList<Interactions> getAllInteractions() {
    List<Interactions> allInteractions = interactionRepository.findAll();
    return (ArrayList<Interactions>)allInteractions;
  }

  // Update
  @Override
  public Interactions updateInteraction(int id, Interactions interaction) {
    // retrieve customer from db
    Interactions interactionToUpdate = interactionRepository.findById(id).get();
      // Update the customer retrieved from DB
      interactionToUpdate.setRemarks(interaction.getRemarks());
      interactionToUpdate.setInteractionDate(interaction.getInteractionDate());
      
  
      // Save and return the data
    return interactionRepository.save(interactionToUpdate);
  }

  // Delete
  @Override
  public void deleteInteraction(int id) {
    interactionRepository.deleteById(id);
  }

  // @Override
  // public Interactions addInteractionToCustomer(int id, Interactions interaction) {
  //   Customer selectedCustomer = CustomerRepository.findById(id).get();
  //   interaction.setCustomer(selectedCustomer);
  //   return interactionRepository.save(interaction);

  // }
}
