package com.example.app;

import com.example.app.dto.BMIDto;
import com.example.app.dto.BMRDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthyController {
    private final HealthyService service;

    public HealthyController(HealthyService service) {
        this.service = service;
    }

    @GetMapping(value = "/api/bmi", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BMIDto> getBMI_JSON(@RequestParam double weight, @RequestParam double height) {
        if (weight > 0 && height > 0) {
            BMIDto object = service.createBmiObject(weight, height);
            return ResponseEntity.ok(object);

        }
        return ResponseEntity.badRequest()
                .header("reason", "invalid data, weight and height parameteres must be positive numbers")
                .build();
    }

    @GetMapping(value = "/api/bmi", produces = MediaType.TEXT_PLAIN_VALUE)
    ResponseEntity<String> getBMI_Text(@RequestParam double weight, @RequestParam double height) {
        if (weight > 0 && height > 0) {
            BMIDto object = service.createBmiObject(weight, height);
            return ResponseEntity.ok(object.getBmi().toString());

        }
        return ResponseEntity.badRequest()
                .header("reason", "invalid data, weight and height parameteres must be positive numbers")
                .build();
    }




    @GetMapping(value = "/api/bmr/{gender}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BMRDto> getBMR_JSON(@PathVariable String gender,
                                  @RequestParam double weight,
                                  @RequestParam double height,
                                  @RequestParam int age) {

        if (!service.checkGender(gender)) {
            return ResponseEntity.badRequest()
                    .header("reason", "invalid data, gender parameter must be man or woman")
                    .build();
        }

        if (weight > 0 && height > 0 && age > 0) {
            BMRDto object = service.createBmrObject(gender, weight, height, age);
            return ResponseEntity.ok(object);
        }
        return ResponseEntity.badRequest()
                .header("reason", "invalid data, weight, height and age parameteres must be positive numbers")
                .build();
    }

    @GetMapping(value = "/api/bmr/{gender}", produces = MediaType.TEXT_PLAIN_VALUE)
    ResponseEntity<String> getBMR_Text(@PathVariable String gender,
                                       @RequestParam double weight,
                                       @RequestParam double height,
                                       @RequestParam int age) {

        if (!service.checkGender(gender)) {
            return ResponseEntity.badRequest()
                    .header("reason", "invalid data, gender parameter must be man or woman")
                    .build();
        }

        if (weight > 0 && height > 0 && age > 0) {
            BMRDto object = service.createBmrObject(gender, weight, height, age);
            String text = String.format("%skcal", object.getBmr());
            return ResponseEntity.ok(text);
        }
        return ResponseEntity.badRequest()
                .header("reason", "invalid data, weight, height and age parameteres must be positive numbers")
                .build();
    }
}
