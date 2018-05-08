package com.coder73;

public class BasketItem {
    private final String sku;
    private int quantity;

    public BasketItem(String sku) {
        this.sku = sku;
        this.quantity = 1;
    }

    public String getSku() {
        return this.sku;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
