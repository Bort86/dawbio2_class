/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pablo Rodriguez
 */
public class WelcomePanel extends JPanel{

    public WelcomePanel() {
        initComponents();
    }
    
    
    
    private void initComponents(){
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Welcome to the show");
        label.setHorizontalAlignment(JLabel.CENTER);
        setBackground(Color.DARK_GRAY);
        label.setForeground(Color.WHITE);
        add(label, BorderLayout.CENTER);
    }
}
