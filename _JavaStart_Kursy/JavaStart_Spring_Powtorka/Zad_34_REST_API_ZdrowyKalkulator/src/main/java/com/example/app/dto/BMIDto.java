package com.example.app.dto;

public class BMIDto {
    private double weight;
    private double height;
    private Integer bmi;
    private String type;

    public BMIDto(double weight, double height, Integer bmi, String type) {
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Integer getBmi() {
        return bmi;
    }

    public void setBmi(Integer bmi) {
        this.bmi = bmi;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
