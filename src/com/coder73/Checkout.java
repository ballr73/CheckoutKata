package com.coder73;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Checkout {
    private final List<PricingRule> rules;
    private HashSet<BasketItem> _basket = new HashSet<BasketItem>();

    public void Checkout() {}

    public Checkout(List<PricingRule> rules) {
        this.rules = rules;
    }

    public void scan(char sku) {
        _basket.add(new BasketItem(sku));
    }

    public int total() {
        int total = 0;
        for (BasketItem item: _basket) {
            PricingRule rule = findRule(item);
            if(rule != null) {
                total += rule.getPrice();
            }
        }

        return total;
    }

    private PricingRule findRule(BasketItem item) {
        for (PricingRule r: this.rules) {
            if(item.getSku() == r.getSku()) {
                return r;
            }
        }
        return null;
    }
}
