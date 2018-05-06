package com.coder73;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class App {
    private JButton closeButton;
    private JButton scanButton;
    private JPanel panelMain;
    private JTextField textField1;
    private JTextArea textArea1;
    private JLabel label1;
    private JButton voidButton;
    private Checkout checkout;

    public App() {
        PricingProvider pricingProvider = new PricingProvider();
        List<PricingRule> pricingRules = new ArrayList<>();
        pricingRules.add(new PricingRule('A', 50, 3, 125));
        pricingRules.add(new PricingRule('B', 30));
        pricingRules.add(new PricingRule('C', 15));

        checkout = new Checkout(pricingProvider, pricingRules);

        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                checkout.scan(textField1.getText().toCharArray()[0]);

                textArea1.setText("");
                for (BasketItem item: checkout.getBasket()) {
                    textArea1.setText(textArea1.getText() + item.getSku() + " " + item.getQuantity() + "\n");
                }

                label1.setText(String.valueOf(checkout.total()));
            }
        });
        voidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkout.voidItem(textField1.getText().toCharArray()[0]);
                label1.setText(String.valueOf(checkout.total()));
                textArea1.setText("");
                for (BasketItem item: checkout.getBasket()) {
                    textArea1.setText(textArea1.getText() + item.getSku() + " " + item.getQuantity() + "\n");
                }
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
