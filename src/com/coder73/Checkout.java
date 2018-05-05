package com.coder73;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Checkout {
    private final List<PricingRule> rules;
    private List<BasketItem> _basket = new ArrayList<>();

    public void Checkout() {}

    public Checkout(List<PricingRule> rules) {
        this.rules = rules;
    }

    public void scan(char sku) {
       BasketItem item =  findItem(sku);
       if(item !=null)
           item.setQuantity(item.getQuantity()+1);
       else
           _basket.add(new BasketItem(sku));
    }

    private BasketItem findItem(char sku) {
        for (BasketItem item: _basket) {
            if(item.getSku() == sku)
                return item;
        }
        return null;
    }

    public int total() {
        int total = 0;
        for (BasketItem item: _basket) {
            PricingRule rule = findRule(item);
            if(rule != null) {
                if(rule.getMultiBuy() > 0 && item.getQuantity() >= rule.getMultiBuy()){
                    int multiples = item.getQuantity() / rule.getMultiBuy();
                    total += rule.getMultiPrice() * multiples;
                    int remaining = item.getQuantity() - (multiples * rule.getMultiBuy());
                    total += remaining * rule.getPrice();
                }
                else {
                    total += item.getQuantity() * rule.getPrice();
                }
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
