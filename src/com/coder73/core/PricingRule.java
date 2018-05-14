package com.coder73.core;

public class PricingRule {
    private final int _id;
    private final String _sku;
    private final double _price;
    private final int _multiBuy;
    private final double _multiPrice;


    public PricingRule(String sku, double price) {
        this._sku = sku;
        this._price = price;
        this._multiBuy = 0;
        this._multiPrice = 0;
        this._id = 0;
    }

    public PricingRule(String sku, double price, int multiBuy, double multiPrice) {
        this._sku = sku;
        this._price = price;
        this._multiBuy = multiBuy;
        this._multiPrice = multiPrice;
        this._id = 0;
    }

    public PricingRule(int id, String sku, double price, int multiBuy, double multiPrice) {
        this._id = id;
        this._sku = sku;
        this._price = price;
        this._multiBuy = multiBuy;
        this._multiPrice = multiPrice;
    }

    public int getId() {
        return _id;
    }

    public double getPrice() {
        return _price;
    }

    public String getSku() {
        return _sku;
    }

    public int getMultiBuy() {
        return _multiBuy;
    }

    public double getMultiPrice() {
        return _multiPrice;
    }


}
