package Zad_59_Comparator2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class PropertyDB {
    private Property[] properties = new Property[10];
    private int addedEl = 0;

    public PropertyDB(File file) {
        read(file);
    }

    private void read(File file) {
        try (   FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)
        ) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                addProperty(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void sortAscByPriceForMetre() {
        Arrays.sort(properties, new Comparator<Property>() {
            @Override
            public int compare(Property p1, Property p2) {
                if (p1.getPriceForArea() > p2.getPriceForArea()) {
                    return 1;
                } else if (p1.getPriceForArea() < p2.getPriceForArea()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    private void addProperty(String line) {
        String[] split = line.split(";");
        String city = split[0];
        double price = Double.parseDouble(split[1]);
        double area = Double.parseDouble(split[2]);
        properties[addedEl] = new Property(city, price, area);
        addedEl++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Property property : properties) {
            sb.append(property);
        }
        return sb.toString();
    }
}
