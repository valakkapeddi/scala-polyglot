package com.ky0dai;

/**
 * Created by kyodai on 1/25/2016.
 */
public class Promotion {

    private double discountAmount;
    private String name;
    private PromotionType type;

    public Promotion(double discountAmount, String name, PromotionType type) {
        this.discountAmount = discountAmount;
        this.name = name;
        this.type = type;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PromotionType getType() {
        return type;
    }

    public void setType(PromotionType type) {
        this.type = type;
    }
}
