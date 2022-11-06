package Zad_65_Mapy2;

import java.io.*;
import java.util.*;

class Store {
    private Map<String, TreeSet<Product>> products = new HashMap<>();

    public Store(File file) {
        read(file);
    }

    private void read(File file) {
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)
        ) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                String cat = split[0];
                String name = split[1];
                double price = Double.parseDouble(split[2]);

                if (!products.containsKey(cat)) {
                    products.put(cat, new TreeSet<>(new Comparator<Product>() {
                        @Override
                        public int compare(Product p1, Product p2) {
                            return Double.compare(p1.getPrice(), p2.getPrice());
                        }
                    }));
                }
                products.get(cat).add(new Product(cat, name, price));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String getCategories() {
        StringBuilder sb = new StringBuilder("[");
        for (String s : products.keySet()) {
            sb.append(s).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("]");
        return sb.toString();
    }

    public String getInfoAbout(String category) {
        StringBuilder sb = new StringBuilder();
        if (products.containsKey(category)) {
            TreeSet<Product> prod = products.get(category);
            double sum = 0;

            for (Product p : prod) {
                sum += p.getPrice();
                sb.append(p);
            }
            double average = sum / prod.size();
            sb.append(String.format("Œrednia cena produktów: %.2fz³%n", average));
            sb.append(String.format("Najtañszy produkt: %s", prod.first()));
            sb.append(String.format("Najdro¿szy produkt: %s", prod.last()));
        } else {
            sb.append("Brak takiej kategorii.");
        }
        return sb.toString();

    }
}
