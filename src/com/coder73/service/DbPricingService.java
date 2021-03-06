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
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Checkout?user=checkoutuser&password=Pa55w0rd1!&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            Statement st =  conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from pricing_rules");

            if(rs!=null) {
                while(rs.next()) {
                    PricingRule rule = new PricingRuleMapper().Map(rs);
                    rules.add(rule);

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
