package budget;
import java.util.ArrayList;
import java.util.Map;

public enum TypesOfProducts {

    FOOD("Food", 0,  new ArrayList<>()),
    CLOTHES("Clothes", 0, new ArrayList<>()),
    ENTERTAINMENT("Entertainment", 0, new ArrayList<>()),
    OTHER("Other", 0, new ArrayList<>()),
    ALL("All", 0, new ArrayList<>() );

    final String name;
    double sum;
    ArrayList<String> boughtProducts;

    TypesOfProducts(String name, double sum, ArrayList<String> boughtProducts) {
        this.name = name;
        this.sum = sum;
        this.boughtProducts = boughtProducts;
    }

    public static void createHashMap(Map<Integer, TypesOfProducts> map) {
        map.put(1, TypesOfProducts.FOOD);
        map.put(2, TypesOfProducts.CLOTHES);
        map.put(3, TypesOfProducts.ENTERTAINMENT);
        map.put(4, TypesOfProducts.OTHER);
        map.put(5, TypesOfProducts.ALL);
    }

    public String getName() {
        return name;
    }
    public double getSum() {
        return sum;
    }
    public ArrayList<String> getBoughtProducts() {
        return boughtProducts;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
    public void setBoughtProducts(ArrayList<String> list) {
        this.boughtProducts = list;
    }



}
