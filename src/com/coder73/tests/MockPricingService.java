package com.coder73.tests;

import com.coder73.service.PricingService;
import com.coder73.core.PricingRule;

import java.util.ArrayList;
import java.util.List;

public class MockPricingService implements PricingService {
    @Override
    public List<PricingRule> getPricingRules() {
        List<PricingRule> pricingRules = new ArrayList<>();

        pricingRules.add(new PricingRule("A", 0.50, 3, 1.25));
        pricingRules.add(new PricingRule("B", 0.30));
        pricingRules.add(new PricingRule("C", 0.25));

        return pricingRules;
    }
}
