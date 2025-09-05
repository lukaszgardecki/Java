package com.example.abstractfactories;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FactoryMaker {
    private static final Map<String, Supplier<UserInterfaceFactory>> interfaceFactories = new HashMap<>();

    static {
        interfaceFactories.put("RED", RedUserInterfaceFactory::new);
        interfaceFactories.put("BLUE", BlueUserInterfaceFactory::new);
    }

    public static UserInterfaceFactory createFactory(String factoryType) {
        if (interfaceFactories.get(factoryType) != null) {
            return interfaceFactories.get(factoryType).get();
        } else {
            throw new IllegalArgumentException("Invalid factory type");
        }
    }
}
