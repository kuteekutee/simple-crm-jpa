package sg.ntu.edu.simplecrm;

import java.util.ArrayList;

public interface InteractionService {
  public Interactions createInteraction(Interactions customer);
  public Interactions getInteraction(int id);
  public ArrayList<Interactions> getAllInteractions();
  public Interactions updateInteraction(int id, Interactions customer);
  public void deleteInteraction(int id);
}
