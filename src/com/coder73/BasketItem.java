package com.coder73;

public class BasketItem {
    private final char sku;
    private int quantity;

    public BasketItem(char sku) {
        this.sku = sku;
        this.quantity = 1;
    }

    public char getSku() {
        return this.sku;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
