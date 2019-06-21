package controller;

/** MainPanel.java
 * Example of main panel for a generic swing application
 * @author Jose
 */
import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JPanel implements ActionListener {
	public MainPanel() {
		setLayout(new GridLayout(1,1));
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
