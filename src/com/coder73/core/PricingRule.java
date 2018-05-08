package com.coder73.core;

public class PricingRule {
    private final int id;
    private final String sku;
    private final double price;
    private final int multiBuy;
    private final double multiPrice;


    public PricingRule(String sku, double price) {
        this.sku = sku;
        this.price = price;
        this.multiBuy = 0;
        this.multiPrice = 0;
        this.id = 0;
    }

    public PricingRule(String sku, double price, int multiBuy, double multiPrice) {
        this.sku = sku;
        this.price = price;
        this.multiBuy = multiBuy;
        this.multiPrice = multiPrice;
        this.id = 0;
    }

    public PricingRule(int id, String sku, double price, int multiBuy, double multiPrice) {
        this.id = id;
        this.sku = sku;
        this.price = price;
        this.multiBuy = multiBuy;
        this.multiPrice = multiPrice;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }

    public int getMultiBuy() {
        return multiBuy;
    }

    public double getMultiPrice() {
        return multiPrice;
    }


}
