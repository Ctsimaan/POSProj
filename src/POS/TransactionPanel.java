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
    private final Color LIGHT_STEEL_BLUE = new Color(176, 196, 222);

    private String transaction_name;

    private JPanel main_panel = new JPanel();
    private JPanel item_panel = new JPanel();
    private JPanel button_panel = new JPanel();

    private JButton review_button = new JButton();
    private ReviewButtonHandler review_button_handler = new ReviewButtonHandler();

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

        review_button.setText("REVIEW " + this.transaction_name);
        review_button.addActionListener(review_button_handler);

        clear_button.setText("CLEAR " + this.transaction_name);
        clear_button.addActionListener(clear_button_handler);

        button_panel.setBackground(DARK_SLATE_BLUE);
        button_panel.add(clear_button);
        button_panel.add(review_button);

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

    public int[][] get_all_spinner_values() {

        int[][] all_spinner_values = new int[5][5];

        for (int i = 0; i < 5; i++) {

            all_spinner_values[i] = this.category_panel_array[i].get_spinner_values();
        }

        return all_spinner_values;
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

    public class ReviewButtonHandler implements ActionListener {

        private JDialog confirmation_dialog;
        
        private int[][] all_spinner_values;

        @Override

        public void actionPerformed(ActionEvent e) {

            all_spinner_values = get_all_spinner_values();

            int number_of_transaction_items = 0;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (all_spinner_values[i][j] != 0) {
                        number_of_transaction_items++;
                    }
                }
            }

            if (number_of_transaction_items > 0) {

                confirmation_dialog = new JDialog();
                JPanel main_panel = new JPanel();

                main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));

                JPanel total_panel = new JPanel();

                total_panel.setBackground(LIGHT_STEEL_BLUE);
                total_panel.setLayout(new GridLayout(3, 2, 10, 10));
                total_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                JPanel title_panel = new JPanel();
                title_panel.setBackground(DARK_SLATE_BLUE);

                JPanel items_panel = new JPanel();

                JPanel buttons_panel = new JPanel();
                buttons_panel.setBackground(DARK_SLATE_BLUE);
                buttons_panel.setLayout(new BoxLayout(buttons_panel, BoxLayout.X_AXIS));
                buttons_panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                items_panel.setLayout(new GridLayout(number_of_transaction_items, 2, 10, 10));
                items_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                JButton cancel_button = new JButton("CANCEL " + transaction_name);
                cancel_button.addActionListener(new CancelButtonHandler());

                JButton confirm_button = new JButton("CONFIRM " + transaction_name);
                confirm_button.addActionListener(new ConfirmButtonHandler());

                buttons_panel.add(cancel_button);
                buttons_panel.add(Box.createHorizontalGlue());
                buttons_panel.add(confirm_button);

                JLabel transaction_label = new JLabel("<html><b>" + transaction_name + " ITEMS</b>");
                transaction_label.setForeground(Color.WHITE);
                transaction_label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                title_panel.add(transaction_label);

                int subtotal = 0;
                int tax = 0;
                int total = 0;

                for (int category_index = 0; category_index < 5; category_index++) {

                    for (int item_index = 0; item_index < 5; item_index++) {

                        if (all_spinner_values[category_index][item_index] != 0) {

                            JLabel quantity_and_name_label = new JLabel("("
                                    + all_spinner_values[category_index][item_index]
                                    + ") "
                                    + inventory.get_category_array()[category_index].get_item_array()[item_index].get_item_name());

                            JLabel price_label = new JLabel(inventory.get_category_array()[category_index].get_item_array()[item_index].get_item_price_for_display()
                                    + " (each)");

                            price_label.setHorizontalAlignment(JLabel.RIGHT);

                            items_panel.add(quantity_and_name_label);
                            items_panel.add(price_label);

                            subtotal += all_spinner_values[category_index][item_index] * inventory.get_category_array()[category_index].get_item_array()[item_index].get_item_price_in_cents();

                        }
                    }
                }

                tax = (int) (subtotal * 0.05);

                total = subtotal + tax;

                String subtotal_string = new Integer(subtotal).toString();
                String formatted_subtotal_string;

                if (subtotal < 10) {
                    formatted_subtotal_string = "$0.0" + subtotal_string;
                } else if (subtotal < 100) {
                    formatted_subtotal_string = "$0." + subtotal_string;
                } else {
                    formatted_subtotal_string = "$"
                            + subtotal_string.substring(0, subtotal_string.length() - 2)
                            + "."
                            + subtotal_string.substring(subtotal_string.length() - 2);
                }

                String tax_string = new Integer(tax).toString();
                String formatted_tax_string;

                if (tax < 10) {
                    formatted_tax_string = "$0.0" + tax_string;
                } else if (tax < 100) {
                    formatted_tax_string = "$0." + tax_string;
                } else {
                    formatted_tax_string = "$"
                            + tax_string.substring(0, tax_string.length() - 2)
                            + "."
                            + tax_string.substring(tax_string.length() - 2);
                }

                String total_string = new Integer(total).toString();
                String formatted_total_string;

                if (total < 10) {
                    formatted_total_string = "$0.0" + total_string;
                } else if (total < 100) {
                    formatted_total_string = "$0." + total_string;
                } else {
                    formatted_total_string = "$"
                            + total_string.substring(0, total_string.length() - 2)
                            + "."
                            + total_string.substring(total_string.length() - 2);
                }

                JLabel subtotal_name_label = new JLabel("<html><b>" + transaction_name + " SUBTOTAL</b>");
                JLabel tax_name_label = new JLabel("<html><b>" + transaction_name + " TAX</b>");
                JLabel total_name_label = new JLabel("<html><b>" + transaction_name + " TOTAL</b>");

                JLabel subtotal_amount_label = new JLabel(formatted_subtotal_string);
                subtotal_amount_label.setHorizontalAlignment(JLabel.RIGHT);

                JLabel tax_amount_label = new JLabel(formatted_tax_string);
                tax_amount_label.setHorizontalAlignment(JLabel.RIGHT);

                JLabel total_amount_label = new JLabel(formatted_total_string);
                total_amount_label.setHorizontalAlignment(JLabel.RIGHT);

                total_panel.add(subtotal_name_label);
                total_panel.add(subtotal_amount_label);
                total_panel.add(tax_name_label);
                total_panel.add(tax_amount_label);
                total_panel.add(total_name_label);
                total_panel.add(total_amount_label);

                main_panel.add(title_panel);
                main_panel.add(items_panel);
                main_panel.add(total_panel);
                main_panel.add(buttons_panel);

                confirmation_dialog.getContentPane().add(main_panel);

                confirmation_dialog.pack();
                confirmation_dialog.setLocationRelativeTo(null);
                confirmation_dialog.setResizable(false);
                confirmation_dialog.setModal(true);
                confirmation_dialog.setVisible(true);
                confirmation_dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }

        }

        public class CancelButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                confirmation_dialog.removeAll();
                confirmation_dialog.dispose();

            }
        }

        // FINISH IMPLEMENTING THIS
        public class ConfirmButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (transaction_name.equals("SALE")) {
                    
                    inventory.sell_items(all_spinner_values);
                    
                } else if (transaction_name.equals("RETURN")) {
                    
                    inventory.return_items(all_spinner_values);
                    
                } else if (transaction_name.equals("ORDER")) {
                    
                    inventory.order_items(all_spinner_values);
                    
                }
            }
        }

    }

}
