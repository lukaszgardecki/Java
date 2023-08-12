package com.example.Springboot.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
//Tworzenie własnego endpointu w actuatorze!
//Nasz endpoint chcemy aby się nazywał /actuator/features
//również nasz nowy endpoint będzie wyświetlony na liście pod adresem /actuator
@Endpoint(id = "features")
public class FeatureEndpoint {

    // musimy stworzyć taką mapę:
    private final Map<String, Feature> featureMap =
            new ConcurrentHashMap<>();

    public FeatureEndpoint() {
        // wstawiamy do mapy interesujące nas elementy
        // które chcemy wyświetlać po przejściu na stronę /actuator/features
        // nie ma znaczenia co tu umieścimy
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }

    // po wywołaniu endpointu wyświetla wartości z mapy
    @ReadOperation
    public Map<String, Feature> features() {
        return featureMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName) {
        return featureMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }
}
