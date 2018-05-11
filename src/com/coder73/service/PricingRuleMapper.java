package com.coder73.service;

import com.coder73.core.PricingRule;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PricingRuleMapper {
    public static PricingRule Map(ResultSet rs) {
        try {
            int id = rs.getInt("id");
            String sku = rs.getString("sku");
            double price = rs.getDouble("price");
            int multibuy = rs.getInt("multibuy");
            double multiprice = rs.getDouble("multiprice");

            return new PricingRule(id, sku, price, multibuy, multiprice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
