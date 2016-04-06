// Timothy Dement
// CSC 340-01: Software Engineering
// Andrew Holman
// TransactionPanel.java

package POS;

import javax.swing.*;
import java.awt.*;

public class TransactionPanel {
    
    private final Color DARK_SLATE_BLUE = new Color(72, 61, 139);
    
    private String transaction_name;
    
    private JPanel main_panel = new JPanel();
    private JPanel item_panel = new JPanel();
    private JPanel button_panel = new JPanel();
    
    private JButton transaction_button = new JButton();
    
    private Inventory inventory;
    
    public TransactionPanel(String transaction_name, Inventory inventory) {
        
        this.transaction_name = transaction_name;
        
        this.inventory = inventory;
        
        item_panel.setLayout(new GridLayout(1, 5, 1, 1));
        item_panel.add(new CategoryPanel(inventory.get_category_array()[0]).get_main_panel());
        item_panel.add(new CategoryPanel(inventory.get_category_array()[1]).get_main_panel());
        item_panel.add(new CategoryPanel(inventory.get_category_array()[2]).get_main_panel());
        item_panel.add(new CategoryPanel(inventory.get_category_array()[3]).get_main_panel());
        item_panel.add(new CategoryPanel(inventory.get_category_array()[4]).get_main_panel());
        
        transaction_button.setText("COMPLETE " + this.transaction_name);
        button_panel.setBackground(DARK_SLATE_BLUE);
        button_panel.add(transaction_button);
        
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
        main_panel.add(item_panel);
        main_panel.add(button_panel);
    }
    
    public JPanel get_main_panel() {
        return this.main_panel;
    }
    
    public String get_transaction_name() {
        return this.transaction_name;
    }
}