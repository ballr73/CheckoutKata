package com.coder73.ui;

import com.coder73.ui.App;

import javax.swing.*;

public class CheckoutApplication {

    public static void main(String[] args){
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
