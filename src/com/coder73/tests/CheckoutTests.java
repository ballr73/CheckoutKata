package com.coder73.tests;

import com.coder73.Checkout;
import com.coder73.PricingRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckoutTests {
    List<PricingRule> _rules = new ArrayList<PricingRule>();

    @Before
    public void Given() {
        _rules.add(new PricingRule('A', 50));
        _rules.add(new PricingRule('B', 30));
    }
    @Test
    public void WhenScanningATotalIs50() {
        Checkout checkout = new Checkout(_rules);
        checkout.scan('A');
        int result = checkout.total();
        Assert.assertEquals(50, result);
    }

    @Test
    public void WhenScanningBTotalIs30() {
        Checkout checkout = new Checkout(_rules);
        checkout.scan('B');
        int result = checkout.total();
        Assert.assertEquals(30, result);
    }

    @Test
    public void WhenScanningABTotalIs80() {
        Checkout checkout = new Checkout(_rules);
        checkout.scan('A');
        checkout.scan('B');
        int result = checkout.total();
        Assert.assertEquals(80, result);
    }
}
