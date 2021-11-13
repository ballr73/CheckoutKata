package com.coder73.core;

public class DiscountPricingCalculator implements PricingCalculator {
    private BasketItem basketItem;
    private PricingRule pricingRule;

    public DiscountPricingCalculator(BasketItem basketItem, PricingRule pricingRule) {
        this.basketItem = basketItem;
        this.pricingRule = pricingRule;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        if(basketItem.getSku().equals(pricingRule.getSku())) {
            int multiples = basketItem.getQuantity() / pricingRule.getMultiBuy();
            totalPrice += pricingRule.getMultiPrice() * multiples;
            int remaining = basketItem.getQuantity() - (multiples * pricingRule.getMultiBuy());
            totalPrice += remaining * pricingRule.getPrice();
        }
        return totalPrice;
    }
}
