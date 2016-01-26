package com.ky0dai;

import java.util.List;

/**
 * Created by kyodai on 1/24/2016.
 */
public class DiscountPackage {

    private List<Promotion> discounts;
    private String discountName;

    public List<Promotion> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Promotion> discounts) {
        this.discounts = discounts;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public DiscountPackage(List<Promotion> discounts, String discountName) {
        this.discounts = discounts;
        this.discountName = discountName;
    }



}
