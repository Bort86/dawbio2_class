package controller;


/** MainWindow.java
 * Example of main window for a generic swing application
 *
 * @author Jose
 */
//esta es la vista, va en la ventana principal
//hago un panel para cada ventana que quiero abrir
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame implements ActionListener {

    public MainWindow() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //no queremos que se acabe la ejecucion al cerrar la ventana
        setSize(400, 300);
        //setVisible(true);
        MainPanel mainPanel = new MainPanel();
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApp();
            }
        });

        buildMenuBar();
        setVisible(true);
    }

    private void exitApp() {
        //int result = JOptionPane.showConfirmDialog(this, "Are you sure?");
        //if (result == JOptionPane.OK_OPTION) {
            System.exit(0);
        //}

    }

    private void buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu mnu;
        JMenuItem mnuItem;
        
        mnu = new JMenu("Form");
        mnuItem = new JMenuItem("Form1");
        mnuItem.setActionCommand("form1");
        mnuItem.addActionListener(this);
        mnu.add(mnuItem);

        mnuItem = new JMenuItem("Form2");
        mnuItem.setActionCommand("form2");
        mnuItem.addActionListener(this);
        mnu.add(mnuItem);

        menuBar.add(mnu);

        mnu = new JMenu("Salir");
        mnuItem = new JMenuItem("Exit");
        mnuItem.setActionCommand("exit");
        mnuItem.addActionListener(this);
        mnu.add(mnuItem);

        menuBar.add(mnu);
        setJMenuBar(menuBar);
    }
//ctrl+e borrar una linea
//windows + space: cambiar idioma teclado
//ctrl+shift+flecha abajo repetir
//ctrl+shift+c comentar linea
//alt + shift +f format

    @Override
    public void actionPerformed(ActionEvent evt) {
        String action = evt.getActionCommand();
        switch (action) {
            case "exit":
                exitApp();
                break;
            case "form1":
                createForm1();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void createForm1() {
        getContentPane().removeAll();
        Form1 form1 = new Form1();
        getContentPane().add(form1, BorderLayout.CENTER);
        setVisible(true);
    }
}
