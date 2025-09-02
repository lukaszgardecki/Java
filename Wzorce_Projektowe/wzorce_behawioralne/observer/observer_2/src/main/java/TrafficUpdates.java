import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class TrafficUpdates implements PropertyChangeListener {

  private ArrayList<String> updates = new ArrayList<>();

  public void getUpdates() {
    updates.forEach(System.out::println);
  }

  @Override
  public void propertyChange(PropertyChangeEvent event) {
    updates.add((String) event.getNewValue());
  }
}
