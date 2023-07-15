package sg.ntu.edu.simplecrm;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interactions")
public class InteractionController {

  // private CustomerService customerService = new CustomerService();

  @Autowired
  private InteractionService interactionService;

  // CRUD
  // 1. CREATE
  @PostMapping("")
  public ResponseEntity<Interactions> saveInteraction(@RequestBody Interactions interaction) {
    Interactions newInteraction = interactionService.createInteraction(interaction);
    return new ResponseEntity<>(newInteraction, HttpStatus.CREATED);
  }

  // 2. READ (Get and Get All)
  // Get All 
  @GetMapping("")
  // public ResponseEntity<Interactions> getAllInteractions() {

  //   Interactions allInteractions = interactionService.getAllInteractions();
  //   return new ResponseEntity<>(allInteractions, HttpStatus.OK);
  // }
  public ResponseEntity<ArrayList<Interactions>> getAllInteractions() {
    ArrayList<Interactions> allInteractions = interactionService.getAllInteractions();
    return new ResponseEntity<>(allInteractions, HttpStatus.OK);
  }

  // Get Customer
  @GetMapping("/{id}")
  public ResponseEntity<Interactions> getInteraction(@PathVariable int id) {
    Interactions found = interactionService.getInteraction(id);
    return new ResponseEntity<>(found, HttpStatus.OK);
  }

  // 3. UPDATE
  @PutMapping("/{id}")
  public ResponseEntity<Interactions> updateCustomer(@PathVariable int id, @RequestBody Interactions interaction) {
    Interactions updated = interactionService.updateInteraction(id, interaction);
    return new ResponseEntity<>(updated, HttpStatus.OK);

  }

  // 4. DELETE
  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteInteraction(@PathVariable int id) {
    interactionService.deleteInteraction(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
