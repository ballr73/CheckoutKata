package com.coder73;

public class PricingRule {
    private final char sku;
    private final int price;

    public PricingRule(char sku, int price) {
        this.sku = sku;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public char getSku() {
        return sku;
    }
}
