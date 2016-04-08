// Timothy Dement
// CSC 340-01: Software Engineering
// Andrew Holman
// Driver.java

package POS;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Driver {
        
    public static void main(String[] args) throws IOException {
        
        Inventory inventory = new Inventory();
        
        inventory.initialize_from_file();
                        
        Employee employee = new Employee("Timothy Dement", "CASHIER", "username", "password");
        
        create_and_display_ui(employee, inventory);

        inventory.save_to_file();

    }
    
    // Eventually this code will be moved to a separate method that specifically
    // handles the UI windows for the transactions (the "main" window).
    // We'll want to start with the login window when the program opens.
    
    public static void create_and_display_ui(Employee employee, Inventory inventory) {
        
        JFrame frame = new JFrame();
        
        TransactionPanel sales_panel = new TransactionPanel("SALE", inventory);
        TransactionPanel return_panel = new TransactionPanel("RETURN", inventory);
        TransactionPanel order_panel = new TransactionPanel("ORDER", inventory);
        
        JTabbedPane transaction_panes = new JTabbedPane();
        
        transaction_panes.addTab(sales_panel.get_transaction_name(), sales_panel.get_main_panel());
        transaction_panes.addTab(return_panel.get_transaction_name(), return_panel.get_main_panel());
        transaction_panes.addTab(order_panel.get_transaction_name(), order_panel.get_main_panel());
        
        JPanel main_panel = new JPanel();
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
        
        JPanel employee_panel = new JPanel();
        employee_panel.setLayout(new BoxLayout(employee_panel, BoxLayout.X_AXIS));
        employee_panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JButton signout_button = new JButton("SIGN OUT");
        
        JLabel employee_label = new JLabel(employee.get_employee_position() + ": " + employee.get_employee_name());
        employee_label.setForeground(Color.GRAY);
        
        employee_panel.add(signout_button);
        employee_panel.add(Box.createRigidArea(new Dimension(15, 0)));
        employee_panel.add(employee_label);
        employee_panel.add(Box.createHorizontalGlue());
        
        main_panel.add(employee_panel);
        main_panel.add(transaction_panes);
        
        frame.getContentPane().add(main_panel);
        
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
