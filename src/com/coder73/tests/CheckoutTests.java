package com.coder73.tests;

import com.coder73.Checkout;
import com.coder73.PricingProvider;
import com.coder73.PricingRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckoutTests {
    private Checkout _checkout;

    @Before
    public void Given() {
        PricingProvider pricingProvider = new PricingProvider();
        List<PricingRule> pricingRules = new ArrayList<>();
        pricingRules.add(new PricingRule('A', 50, 3, 125));
        pricingRules.add(new PricingRule('B', 30));
        pricingRules.add(new PricingRule('C', 15));

        _checkout = new Checkout(pricingProvider, pricingRules);
    }
    @Test
    public void WhenScanningATotalIs50() {
        _checkout.scan('A');
        int result = _checkout.total();
        Assert.assertEquals(50, result);
    }

    @Test
    public void WhenScanningAAATotalIs125() {
        _checkout.scan('A');
        _checkout.scan('A');
        _checkout.scan('A');
        int result = _checkout.total();
        Assert.assertEquals(125, result);
    }

    @Test
    public void WhenScanningBTotalIs30() {
        _checkout.scan('B');
        int result = _checkout.total();
        Assert.assertEquals(30, result);
    }

    @Test
    public void WhenScanningABTotalIs80() {
        _checkout.scan('A');
        _checkout.scan('B');
        int result = _checkout.total();
        Assert.assertEquals(80, result);
    }

    @Test
    public void WhenScanningCTotalIs15() {
        _checkout.scan('C');
        int result = _checkout.total();
        Assert.assertEquals(15, result);
    }

    @Test
    public void WhenScanningABCTotalIs95() {
        _checkout.scan('A');
        _checkout.scan('B');
        _checkout.scan('C');
        int result = _checkout.total();
        Assert.assertEquals(95, result);
    }
}
