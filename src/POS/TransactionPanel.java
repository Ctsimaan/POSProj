// Timothy Dement
// CSC 340-01: Software Engineering
// Andrew Holman
// TransactionPanel.java

package POS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionPanel {
    
    private final Color DARK_SLATE_BLUE = new Color(72, 61, 139);
    
    private String transaction_name;
    
    private JPanel main_panel = new JPanel();
    private JPanel item_panel = new JPanel();
    private JPanel button_panel = new JPanel();
    
    private JButton transaction_button = new JButton();
    //private TransactionButtonHandler transaction_button_handler;
    
    private JButton clear_button = new JButton();
    private ClearButtonHandler clear_button_handler = new ClearButtonHandler();
    
    private Inventory inventory;
    
    private CategoryPanel[] category_panel_array = new CategoryPanel[5];
    
    public TransactionPanel(String transaction_name, Inventory inventory) {
        
        this.transaction_name = transaction_name;
        
        this.inventory = inventory;
        
        category_panel_array[0] = new CategoryPanel(inventory.get_category_array()[0]);
        category_panel_array[1] = new CategoryPanel(inventory.get_category_array()[1]);
        category_panel_array[2] = new CategoryPanel(inventory.get_category_array()[2]);
        category_panel_array[3] = new CategoryPanel(inventory.get_category_array()[3]);
        category_panel_array[4] = new CategoryPanel(inventory.get_category_array()[4]);
        
        item_panel.setLayout(new GridLayout(1, 5, 1, 1));
        
        item_panel.add(category_panel_array[0].get_main_panel());
        item_panel.add(category_panel_array[1].get_main_panel());
        item_panel.add(category_panel_array[2].get_main_panel());
        item_panel.add(category_panel_array[3].get_main_panel());
        item_panel.add(category_panel_array[4].get_main_panel());
        
        transaction_button.setText("COMPLETE " + this.transaction_name);
        clear_button.setText("CLEAR " +this.transaction_name);
        clear_button.addActionListener(clear_button_handler);
        
        button_panel.setBackground(DARK_SLATE_BLUE);
        button_panel.add(clear_button);
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
    
    public CategoryPanel[] get_category_panel_array() {
        return this.category_panel_array;
    }
    
    public class ClearButtonHandler implements ActionListener {
        
        @Override
        
        public void actionPerformed(ActionEvent e) {
            
            for (int category_index = 0; category_index < 5; category_index++) {
                
                category_panel_array[category_index].get_spinner_one().setValue(0);
                category_panel_array[category_index].get_spinner_two().setValue(0);
                category_panel_array[category_index].get_spinner_three().setValue(0);
                category_panel_array[category_index].get_spinner_four().setValue(0);
                category_panel_array[category_index].get_spinner_five().setValue(0);
                
            }
        }
    }
}