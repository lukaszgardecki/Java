import org.example.UKCarPriceCalculator;

public class Main {

  public static void main(String[] args) {
    CarPriceCalculator carPriceCalculator = new CarPriceCalculator("Ford", 3);
    printVehiclePrice(carPriceCalculator);

    TruckPriceCalculator truckPriceCalculator = new TruckPriceCalculator(10, 0);
    printVehiclePrice(truckPriceCalculator);

    UKCarPriceCalculator UKCarPriceCalculator = new UKCarPriceCalculator("BMW", 7);
    Adapter adapter = new Adapter(UKCarPriceCalculator);
    printVehiclePrice(adapter);
  }

  public static void printVehiclePrice(PriceCalculator calculator) {
    String price = calculator.calculatePrice();
    System.out.println("The price of vehicle is: " + price);
  }

}
