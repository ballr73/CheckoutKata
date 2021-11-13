package com.coder73.core;

import com.coder73.service.PricingService;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private List<PricingRule> _rules = new ArrayList<>();
    private List<BasketItem> _basket = new ArrayList<>();
    private PricingProvider _pricingProvider;
    private PricingService _pricingService;

    public Checkout() { }

    public Checkout(PricingProvider pricingProvider, PricingService pricingService) {
        _pricingProvider = pricingProvider;
        _pricingService = pricingService;
        _rules = _pricingService.getPricingRules();

    }

    public List<BasketItem> getBasket() {
        return _basket;
    }

    public boolean scan(String sku) {
        PricingRule rule = findRule(sku);

        if(rule == null)
            return false;

        BasketItem item =  findItem(sku);

        if(item !=null)
           item.setQuantity(item.getQuantity()+1);
        else
           _basket.add(new BasketItem(sku));

        return true;
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
            PricingRule rule = findRule(item.getSku());
            if(rule != null) {
                total += this._pricingProvider.getPricingCalculator(item, rule).getTotalPrice();
            }
        }

        return total;
    }

    private PricingRule findRule(String sku) {
        for (PricingRule r: this._rules) {
            if(sku.equals(r.getSku())) {
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
