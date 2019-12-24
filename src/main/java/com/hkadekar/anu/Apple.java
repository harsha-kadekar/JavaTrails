package com.hkadekar.anu;

public class Apple {
    private String color;
    private Double weight;
    private AppleType appleType;

    public Apple(String color, Double weight, AppleType appleType) {
        this.color = color;
        this.weight = weight;
        this.appleType = appleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public AppleType getAppleType() {
        return appleType;
    }

    public void setAppleType(AppleType appleType) {
        this.appleType = appleType;
    }
}
