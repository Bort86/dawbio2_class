/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pablo Rodriguez
 */
public class MainPanel extends JPanel implements ActionListener {

    public MainPanel() {
        setLayout(new GridLayout(1, 1));
        JLabel lbHello = new JLabel("Hello everybody!");
        add(lbHello);
        /*
                JButton btOk = new JButton("Ok");
		btOk.addActionListener(this);
		add(btOk);
         */
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Button clicked");
    }
}
