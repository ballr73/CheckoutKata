package com.coder73.service;

import com.coder73.core.PricingRule;
import com.coder73.service.PricingService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbPricingService implements PricingService {
    private Connection conn;

    @Override
    public List<PricingRule> getPricingRules() {
        List<PricingRule> rules = new ArrayList<>();
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Checkout?user=guest&password=Pa55w0rd&autoReconnect=true&useSSL=false");
            Statement st =  conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from PricingRules");

            if(rs!=null) {
                while(rs.next()) {
                    int id = rs.getInt("id");
                    String sku = rs.getString("sku");
                    double price = rs.getDouble("price");
                    int multibuy = rs.getInt("multibuy");
                    double multiprice = rs.getDouble("multiprice");

                    rules.add(new PricingRule(id, sku, price, multibuy, multiprice));

                }
                rs.close();
            }
            return rules;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rules;
    }
}