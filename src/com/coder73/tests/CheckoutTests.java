package com.coder73.tests;

import com.coder73.core.Checkout;
import com.coder73.core.PricingProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckoutTests {
    private Checkout _checkout;

    @Before
    public void Given() {
        _checkout = new Checkout( new PricingProvider(), new MockPricingService());
    }
    @Test
    public void WhenScanningATotalIs50() {
        _checkout.scan("A");
        double result = _checkout.total();
        Assert.assertEquals(0.50, result,0);
    }

    @Test
    public void WhenScanningAAATotalIs125() {
        _checkout.scan("A");
        _checkout.scan("A");
        _checkout.scan("A");
        double result = _checkout.total();
        Assert.assertEquals(1.25, result, 0);
    }

    @Test
    public void WhenScanningBTotalIs30() {
        _checkout.scan("B");
        double result = _checkout.total();
        Assert.assertEquals(0.30, result, 0);
    }

    @Test
    public void WhenScanningABTotalIs80() {
        _checkout.scan("A");
        _checkout.scan("B");
        double result = _checkout.total();
        Assert.assertEquals(0.80, result, 0);
    }

    @Test
    public void WhenScanningCTotalIs25() {
        _checkout.scan("C");
        double result = _checkout.total();
        Assert.assertEquals(0.25, result, 0);
    }

    @Test
    public void WhenScanningABCTotalIs105() {
        _checkout.scan("A");
        _checkout.scan("B");
        _checkout.scan("C");
        double result = _checkout.total();
        Assert.assertEquals(1.05, result, 0);
    }
    public void WhenVoidingATotalIs50 () {
        _checkout.scan("A");
        _checkout.scan("A");
        _checkout.voidItem("A");
        Assert.assertEquals(0.50, _checkout.total(), 0);
    }
}
