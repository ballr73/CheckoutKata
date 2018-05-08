package com.coder73;

public class DiscountPricingCalculator implements PricingCalculator {
    private BasketItem item;
    private PricingRule rule;

    public DiscountPricingCalculator(BasketItem item, PricingRule rule) {
        this.item = item;
        this.rule = rule;
    }

    public double getTotal() {
        double total = 0;
        if(item.getSku().equals(rule.getSku())) {
            int multiples = item.getQuantity() / rule.getMultiBuy();
            total += rule.getMultiPrice() * multiples;
            int remaining = item.getQuantity() - (multiples * rule.getMultiBuy());
            total += remaining * rule.getPrice();
        }
        return total;
    }
}
