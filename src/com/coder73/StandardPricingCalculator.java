package com.coder73;

public class StandardPricingCalculator implements PricingCalculator {
    private BasketItem item;
    private PricingRule rule;

    public StandardPricingCalculator(BasketItem item, PricingRule rule) {
        this.item = item;
        this.rule = rule;
    }
    public int getTotal(){
        if(item.getSku() == rule.getSku())
            return item.getQuantity() * rule.getPrice();

        return 0;
    }
}
