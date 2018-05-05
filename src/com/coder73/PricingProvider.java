package com.coder73;

public class PricingProvider {
    private BasketItem item;
    private PricingRule rule;

    public PricingProvider(BasketItem item, PricingRule rule) {
        this.item = item;
        this.rule = rule;
    }

    public PricingCalculator getPricingCalculator() {
        if(rule.getMultiBuy() > 0 && item.getQuantity() >= rule.getMultiBuy()){
            return new DiscountPricingCalculator(item, rule);
        }
        else {
            return new StandardPricingCalculator(item, rule);
        }
    }
}
