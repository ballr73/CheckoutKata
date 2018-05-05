package com.coder73;

public class PricingProvider {
    public PricingProvider() {
    }

    public PricingCalculator getPricingCalculator(BasketItem item, PricingRule rule) {
        if(rule.getMultiBuy() > 0 && item.getQuantity() >= rule.getMultiBuy()){
            return new DiscountPricingCalculator(item, rule);
        }
        else {
            return new StandardPricingCalculator(item, rule);
        }
    }
}
