package com.coder73;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private final List<PricingRule> rules;
    private List<BasketItem> _basket = new ArrayList<>();
    private PricingProvider _pricingProvider;

    public void Checkout() {

    }

    public Checkout(PricingProvider pricingProvider, List<PricingRule> rules) {
        this._pricingProvider = pricingProvider;
        this.rules = rules;
    }
    public List<BasketItem> getBasket() {
        return _basket;
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
                total += this._pricingProvider.getPricingCalculator(item, rule).getTotal();
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

    public void voidItem(char sku) {
        BasketItem item = findItem(sku);
        if(item != null) {
            item.setQuantity(item.getQuantity() - 1);

            if (item.getQuantity() == 0)
                _basket.remove(item);
        }
    }
}
