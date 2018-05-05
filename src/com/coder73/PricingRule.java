package com.coder73;

public class PricingRule {
    private final char sku;
    private final int price;
    private final int multiBuy;
    private final int multiPrice;

    public PricingRule(char sku, int price) {
        this.sku = sku;
        this.price = price;
        this.multiBuy = 0;
        this.multiPrice = 0;
    }

    public PricingRule(char sku, int price, int multiBuy, int multiPrice) {
        this.sku = sku;
        this.price = price;
        this.multiBuy = multiBuy;
        this.multiPrice = multiPrice;
    }


    public int getPrice() {
        return price;
    }

    public char getSku() {
        return sku;
    }

    public int getMultiBuy() {
        return multiBuy;
    }

    public int getMultiPrice() {
        return multiPrice;
    }
}
