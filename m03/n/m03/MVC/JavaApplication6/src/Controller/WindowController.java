/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Vista;
import View.WelcomePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pablo Rodriguez
 */
public class WindowController implements ActionListener{
    
    Vista v;

    public WindowController(Vista v) {
        this.v = v;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch(action) {
            case "hello-dolly":
                displayInputForm();
                break;
            case "exit":
                System.out.println("action= "+action);
                break;
            default:
                break;
        }
    }

    private void displayInputForm() {
        WelcomePanel welcome = new WelcomePanel();
        
        v.setContentPane(welcome);
        v.validate();
    }
}
