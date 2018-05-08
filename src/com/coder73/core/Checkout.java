package com.coder73.core;

import com.coder73.service.PricingService;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private List<PricingRule> _rules = new ArrayList<>();
    private List<BasketItem> _basket = new ArrayList<>();
    private PricingProvider _pricingProvider;
    private PricingService _pricingService;

    public void Checkout() { }

    public Checkout(PricingProvider pricingProvider, PricingService pricingService) {
        _pricingProvider = pricingProvider;
        _pricingService = pricingService;
        _rules = _pricingService.getPricingRules();

    }
    public List<BasketItem> getBasket() {
        return _basket;
    }
    public void scan(String sku) {
       BasketItem item =  findItem(sku);
       if(item !=null)
           item.setQuantity(item.getQuantity()+1);
       else
           _basket.add(new BasketItem(sku));
    }

    private BasketItem findItem(String sku) {
        for (BasketItem item: _basket) {
            if(item.getSku().equals(sku))
                return item;
        }
        return null;
    }

    public double total() {
        double total = 0;
        for (BasketItem item: _basket) {
            PricingRule rule = findRule(item);
            if(rule != null) {
                total += this._pricingProvider.getPricingCalculator(item, rule).getTotal();
            }
        }

        return total;
    }

    private PricingRule findRule(BasketItem item) {
        for (PricingRule r: this._rules) {
            if(item.getSku().equals(r.getSku())) {
                return r;
            }
        }
        return null;
    }

    public void voidItem(String sku) {
        BasketItem item = findItem(sku);
        if(item != null) {
            item.setQuantity(item.getQuantity() - 1);

            if (item.getQuantity() == 0)
                _basket.remove(item);
        }
    }
}
