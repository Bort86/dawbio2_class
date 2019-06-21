package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Main frame for travel time calculator.
 * @author Jose
 */
public class MainFrame extends JFrame{
    public JMenu mnu;
    public JMenuBar menuBar;
    public JMenuItem menuItem1, menuItem2, menuItem3, menuItem4;
    
    public MainFrame(){
        menuBar = new JMenuBar();
        
        mnu = new JMenu("File");
        menuItem1 = new JMenuItem("Exit");
        menuItem1.setActionCommand("exit");
        mnu.add(menuItem1);
        menuBar.add(mnu);
        
        mnu = new JMenu("Menu");
        menuItem2 = new JMenuItem("Configuration Panel");
        menuItem2.setActionCommand("option1");
        mnu.add(menuItem2);
        menuItem3 = new JMenuItem("Calculation Panel");
        menuItem3.setActionCommand("option2");
        mnu.add(menuItem3);
        menuBar.add(mnu);
        
        mnu = new JMenu("Help");
        menuItem4 = new JMenuItem("About");
        menuItem4.setActionCommand("option3");
        mnu.add(menuItem4);
        menuBar.add(mnu);
        
        setJMenuBar(menuBar);
        
        
    }
}
