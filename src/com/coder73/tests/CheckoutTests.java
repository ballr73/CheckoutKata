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
    List<PricingRule> _rules = new ArrayList<>();
    private PricingProvider _pricingProvider;

    @Before
    public void Given() {
        _pricingProvider = new PricingProvider();
        _rules.add(new PricingRule('A', 50, 3, 125));
        _rules.add(new PricingRule('B', 30));
        _rules.add(new PricingRule('C', 15));
    }
    @Test
    public void WhenScanningATotalIs50() {
        Checkout checkout = new Checkout(_pricingProvider, _rules);
        checkout.scan('A');
        int result = checkout.total();
        Assert.assertEquals(50, result);
    }

    @Test
    public void WhenScanningAAATotalIs125() {
        Checkout checkout = new Checkout(_pricingProvider, _rules);
        checkout.scan('A');
        checkout.scan('A');
        checkout.scan('A');
        int result = checkout.total();
        Assert.assertEquals(125, result);
    }

    @Test
    public void WhenScanningBTotalIs30() {
        Checkout checkout = new Checkout(_pricingProvider, _rules);
        checkout.scan('B');
        int result = checkout.total();
        Assert.assertEquals(30, result);
    }

    @Test
    public void WhenScanningABTotalIs80() {
        Checkout checkout = new Checkout(_pricingProvider, _rules);
        checkout.scan('A');
        checkout.scan('B');
        int result = checkout.total();
        Assert.assertEquals(80, result);
    }

    @Test
    public void WhenScanningCTotalIs15() {
        Checkout checkout = new Checkout(_pricingProvider, _rules);
        checkout.scan('C');
        int result = checkout.total();
        Assert.assertEquals(15, result);
    }

    @Test
    public void WhenScanningABCTotalIs95() {
        Checkout checkout = new Checkout(_pricingProvider, _rules);
        checkout.scan('A');
        checkout.scan('B');
        checkout.scan('C');
        int result = checkout.total();
        Assert.assertEquals(95, result);
    }
}
