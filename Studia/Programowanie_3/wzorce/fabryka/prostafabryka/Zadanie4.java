package wzorce.fabryka.prostafabryka;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Zadanie 4: Generator danych w różnych formatach
 *
 * Cel: zrozumienie, jak różne implementacje tego samego interfejsu mogą realizować odmienne strategie formatowania danych.
 *
 * - zaimplementuj prostą fabrykę DataExporterFactory, która na podstawie parametru ("json", "csv", "yaml") zwraca odpowiedni obiekt implementujący interfejs DataExporter
 * - każdy eksporter powinien przyjąć dane w postaci listy map (List<Map<String>>) i wypisać je na konsolę w odpowiednim formacie:
 *      - JsonExporter - wypisuje dane w formacie JSON
 *      - CsvExporter - wypisuje dane w foramcie CSV
 *      - YamlExporter - wypisuje dane w formacie YAML
 * - Rozszerzenie:
 *      - dodaj obsługę wyjątków (np. gdy dane są puste)
 *      - rozszerz fabrykę o możliwość dynamicznej rejestracji nowych eksporterów (np. XmlExporter)
 */
public class Zadanie4 {
    public static void main(String[] args) {
        List<Map<String, String>> data = new ArrayList<>();
        data.add(Map.of("id", "1", "imie", "Ala", "wiek", "23"));
        data.add(Map.of("id", "2", "imie", "Ola", "wiek", "30"));
        data.add(Map.of("id", "3", "imie", "Jan", "wiek", "27"));

//        System.out.println("=== JSON ===");
//        DataExporterFactory.createExporter(ExporterType.JSON).export(data);
//
//        System.out.println("\n=== CSV ===");
//        DataExporterFactory.createExporter(ExporterType.CSV).export(data);
//
//        System.out.println("\n=== YAML ===");
//        DataExporterFactory.createExporter(ExporterType.YAML).export(data);

        System.out.println("=== JSON ===");
        new JsonDataExporterFactory().createExporter().export(data);

        System.out.println("\n=== CSV ===");
        new CsvDataExporterFactory().createExporter().export(data);

        System.out.println("\n=== YAML ===");
        new YamlDataExporterFactory().createExporter().export(data);

        System.out.println("\n=== XML ===");
        new XmlDataExporterFactory().createExporter().export(data);
    }
}

//class DataExporterFactory {
//    static DataExporter createExporter(ExporterType type) {
//        return switch (type) {
//            case JSON -> new JsonDataExporter();
//            case CSV -> new CsvDataExporter();
//            case YAML -> new YamlDataExporter();
//        };
//    }
//}
//enum ExporterType { JSON, CSV, YAML }

interface DataExporterFactory {
    DataExporter createExporter();
}

class JsonDataExporterFactory implements DataExporterFactory {
    @Override
    public DataExporter createExporter() {
        return new JsonDataExporter();
    }
}

class CsvDataExporterFactory implements DataExporterFactory {
    @Override
    public DataExporter createExporter() {
        return new CsvDataExporter();
    }
}

class YamlDataExporterFactory implements DataExporterFactory {
    @Override
    public DataExporter createExporter() {
        return new YamlDataExporter();
    }
}

class XmlDataExporterFactory implements DataExporterFactory {
    @Override
    public DataExporter createExporter() {
        return new XmlDataExporter();
    }
}


interface DataExporter {
    void export(List<Map<String, String>> data);

    default void validate(List<Map<String, String>> data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Pusto panie w tym zbiorze...");
        }
    };
}

class JsonDataExporter implements DataExporter {
    @Override
    public void export(List<Map<String, String>> data) {
        validate(data);
        String json = data.stream()
                .map(map -> {
                    String mapContent = map.entrySet().stream()
                            .map(entry -> "\"%s\": \"%s\"".formatted(entry.getKey(), entry.getValue()))
                            .collect(Collectors.joining(","));
                    return String.format("    {%s}",  mapContent);
                })
                .collect(Collectors.joining(",\n"));

        System.out.println("[");
        System.out.println(json);
        System.out.println("]");
    }
}

class CsvDataExporter implements DataExporter {
    @Override
    public void export(List<Map<String, String>> data) {
        validate(data);
        String header = String.join(",", data.getFirst().keySet());
        System.out.println(header);

        data.stream()
                .map(m -> String.join(",", m.values()))
                .forEach(System.out::println);
    }
}

class YamlDataExporter implements DataExporter {
    @Override
    public void export(List<Map<String, String>> data) {
        validate(data);
        data.forEach(map -> {
            System.out.println("-");
            map.forEach((key, value) -> System.out.printf("    %s: %s\n", key, value));
        });
    }
}

class XmlDataExporter implements DataExporter {
    @Override
    public void export(List<Map<String, String>> data) {
        validate(data);
        System.out.println("<records>");
        data.forEach(map -> {
            System.out.println("    <record>");
            map.forEach((key, value) -> System.out.printf("        <%s>%s</%s>\n", key, value, key));
            System.out.println("    </record>");
        });
        System.out.println("</records>");
    }
}