package com.coder73.ui;

import com.coder73.core.BasketItem;
import com.coder73.core.Checkout;
import com.coder73.service.DbPricingService;
import com.coder73.core.PricingProvider;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        checkout = new Checkout(new PricingProvider(), new DbPricingService());

        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                checkout.scan(textField1.getText());

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
                checkout.voidItem(textField1.getText());
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
