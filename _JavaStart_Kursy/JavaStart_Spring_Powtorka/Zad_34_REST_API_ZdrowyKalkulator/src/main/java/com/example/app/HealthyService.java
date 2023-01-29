package com.example.app;

import com.example.app.dto.BMIDto;
import com.example.app.dto.BMRDto;
import com.example.app.enums.BmiCategory;
import com.example.app.enums.Gender;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class HealthyService {
    private static final int BMR_S_MAN = 5;
    private static final int BMR_S_WOMAN = -161;

    public BMIDto createBmiObject(double weight, double height) {
        double bmi = countBmi(weight, height);
        String type = getCategory(bmi);
        return new BMIDto(weight, height, (int)Math.round(bmi), type);
    }

    public BMRDto createBmrObject(String gender, double weight, double height, int age) {
        Gender g = Gender.valueOf(gender.toUpperCase());
        int bmr = switch (g) {
            case MAN -> countBmr(BMR_S_MAN, weight, height, age);
            case WOMAN -> countBmr(BMR_S_WOMAN, weight, height, age);
        };
        return new BMRDto(g, weight, height, age, bmr);
    }

    public boolean checkGender(String gender) {
        return Arrays.stream(Gender.values()).anyMatch(g -> g.name().equalsIgnoreCase(gender));
    }

    private String getCategory(double bmi) {
        BmiCategory[] categories = BmiCategory.values();
        for (BmiCategory category : categories) {
            if (bmi >= category.getLowerBound() && bmi < category.getUpperBound()) {
                return category.getDescription();
            }
        }
        return null;
    }

    private double countBmi(double weight, double height) {
        return weight / Math.pow((height / 100), 2);
    }


    private int countBmr(int s, double weight, double height, int age) {
        return (int) Math.round(10 * weight + 6.25 * height - 5 * age + s);
    }
}
