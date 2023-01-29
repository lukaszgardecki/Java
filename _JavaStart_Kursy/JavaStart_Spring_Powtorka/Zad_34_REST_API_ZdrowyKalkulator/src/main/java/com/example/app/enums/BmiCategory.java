package com.example.app.enums;

public enum BmiCategory {
    UNDERWEIGHT_3("Underweight (Severe thinness)", -1000, 16),
    UNDERWEIGHT_2("Underweight (Severe thinness)", 16, 17),
    UNDERWEIGHT_1("Underweight (Severe thinness)", 17, 18.5),
    NORMAL_RANGE("Normal range", 18.5, 25),
    OVERWEIGHT("Overweight (Pre-obese)", 25, 30),
    OBESE_1("Obese(Class 1)", 30, 35),
    OBESE_2("Obese(Class 2)", 35, 40),
    OBESE_3("Obese(Class 3)", 40, 1000);

    private String description;
    private double lowerBound;
    private double upperBound;

    BmiCategory(String description, double lowerBound, double upperBound) {
        this.description = description;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public String getDescription() {
        return description;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }
}
