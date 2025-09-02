import java.util.HashMap;

public class ECommerceSite {
  private final HashMap<String, Integer> stock;

  public ECommerceSite() {
    stock = new HashMap<>();
    stock.put("pens", 100);
    stock.put("pencils", 50);
    stock.put("erasers", 75);
  }

  public boolean checkInStock(String item, int quantity) {
    return stock.containsKey(item) && stock.get(item) > quantity;
  }

  public void sell(String item, int quantity) {
    int newQuantity = stock.get(item) - quantity;
    stock.put(item, newQuantity);
  }

}
