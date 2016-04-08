// Timothy Dement
// CSC 340-01: Software Engineering
// Andrew Holman
// CategoryPanel.java

package POS;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends JPanel {
    
    // Create standard Color values for use in the UI.
    
    private final Color DARK_SLATE_BLUE = new Color(72, 61, 139);
    private final Color LIGHT_STEEL_BLUE = new Color(176, 196, 222);
    
    private Category category;
    
    private JPanel main_panel = new JPanel();
    
    private JPanel title_panel = new JPanel();
    
    private JPanel items_panel = new JPanel();
    
    private JPanel summary_panel_one = new JPanel();
    private JPanel summary_panel_two = new JPanel();
    private JPanel summary_panel_three = new JPanel();
    private JPanel summary_panel_four = new JPanel();
    private JPanel summary_panel_five = new JPanel();
    
    private JLabel category_label = new JLabel();
    
    private JLabel name_label_one = new JLabel();
    private JLabel name_label_two = new JLabel();
    private JLabel name_label_three = new JLabel();
    private JLabel name_label_four = new JLabel();
    private JLabel name_label_five = new JLabel();
    
    private JLabel price_label_one = new JLabel();
    private JLabel price_label_two = new JLabel();
    private JLabel price_label_three = new JLabel();
    private JLabel price_label_four = new JLabel();
    private JLabel price_label_five = new JLabel();
    
    private JLabel quantity_label_one = new JLabel();
    private JLabel quantity_label_two = new JLabel();
    private JLabel quantity_label_three = new JLabel();
    private JLabel quantity_label_four = new JLabel();
    private JLabel quantity_label_five = new JLabel();
    
    // NOTE:
    //
    // WE CAN ADJUST THE VALUES OF THESE SPINNERS SO THAT THE "MAX" VALUE THEY
    // CAN REACH IS LIMITED TO THE NUMBER OF AN ITEM WE HAVE IN STOCK.
    
    private JSpinner spinner_one;
    private JSpinner spinner_two;
    private JSpinner spinner_three;
    private JSpinner spinner_four;
    private JSpinner spinner_five;
    
    /**
     * Constructor that takes one argument and sets category.
     * 
     * @param category 
     */
    public CategoryPanel(Category category) {
        
        this.category = category;
        
        spinner_one = new JSpinner(new SpinnerNumberModel(0, 0, this.category.get_item_array()[0].get_item_quantity(), 1));
        spinner_two = new JSpinner(new SpinnerNumberModel(0, 0, this.category.get_item_array()[1].get_item_quantity(), 1));
        spinner_three = new JSpinner(new SpinnerNumberModel(0, 0, this.category.get_item_array()[2].get_item_quantity(), 1));
        spinner_four = new JSpinner(new SpinnerNumberModel(0, 0, this.category.get_item_array()[3].get_item_quantity(), 1));
        spinner_five = new JSpinner(new SpinnerNumberModel(0, 0, this.category.get_item_array()[4].get_item_quantity(), 1));

        
        // Set border and color of the title_panel.
        // The title_panel simply displays the title of the category.
        
        title_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        title_panel.setBackground(DARK_SLATE_BLUE);
        
        // Set the text and the color of the category_label.
        
        category_label.setText("<html><b>" + category.get_category_name() + "</b>");
        category_label.setForeground(Color.WHITE);
        
        // Add the category_label to the title_panel.
        
        title_panel.add(category_label);
        
        // Set the layout, color, and border of the items_panel.
        // The item_panel contains a summary of each of the five items
        // (quantity, name, and price) and a spinner associated with each item.
        
        items_panel.setLayout(new GridLayout(5, 2, 5, 5));
        items_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        items_panel.setBackground(LIGHT_STEEL_BLUE);

        // Set the layout, color, and border of the summary_panel_one.
        
        summary_panel_one.setLayout(new GridLayout(3, 1, 5, 5));
        summary_panel_one.setBackground(LIGHT_STEEL_BLUE);
        summary_panel_one.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        // Set the text and color for the labels in the summary_panel_one.
        
        name_label_one.setText("<html><font color = #ffffff><b>N </b></font>" + category.get_item_array()[0].get_item_name());
        price_label_one.setText("<html><font color = #ffffff><b>P </b></font>" + category.get_item_array()[0].get_item_price_for_display());
        quantity_label_one.setText("<html><font color = #ffffff><b>S </b></font>" + category.get_item_array()[0].get_item_quantity());
        
        // Add the labels to the summary_panel_one.
        
        summary_panel_one.add(name_label_one);
        summary_panel_one.add(price_label_one);
        summary_panel_one.add(quantity_label_one);
        
        // Set the layout, color, and border of the summary_panel_two.
        
        summary_panel_two.setLayout(new GridLayout(3, 1, 5, 5));
        summary_panel_two.setBackground(LIGHT_STEEL_BLUE);
        summary_panel_two.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        // Set the text and color for the labels in the summary_panel_two.
        
        name_label_two.setText("<html><font color = #ffffff><b>N </b></font>" + category.get_item_array()[1].get_item_name());
        price_label_two.setText("<html><font color = #ffffff><b>P </b></font>" + category.get_item_array()[1].get_item_price_for_display());
        quantity_label_two.setText("<html><font color = #ffffff><b>S </b></font>" + category.get_item_array()[1].get_item_quantity());

        // Add the labels to the summary_two_panel.
        
        summary_panel_two.add(name_label_two);
        summary_panel_two.add(price_label_two);
        summary_panel_two.add(quantity_label_two);
        
        // Set the layout, color, and border of the summary_panel_three.
        
        summary_panel_three.setLayout(new GridLayout(3, 1, 5, 5));
        summary_panel_three.setBackground(LIGHT_STEEL_BLUE);
        summary_panel_three.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        // Set the text and color for the labels in the summary_panel_three.
        
        name_label_three.setText("<html><font color = #ffffff><b>N </b></font>" + category.get_item_array()[2].get_item_name());
        price_label_three.setText("<html><font color = #ffffff><b>P </b></font>" + category.get_item_array()[2].get_item_price_for_display());
        quantity_label_three.setText("<html><font color = #ffffff><b>S </b></font>" + category.get_item_array()[2].get_item_quantity());

        // Add the labels to the summary_three_panel.
        
        summary_panel_three.add(name_label_three);
        summary_panel_three.add(price_label_three);
        summary_panel_three.add(quantity_label_three);
        
        // Set the layout, color, and border of the summary_panel_four.
        
        summary_panel_four.setLayout(new GridLayout(3, 1, 5, 5));
        summary_panel_four.setBackground(LIGHT_STEEL_BLUE);
        summary_panel_four.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        // Set the text and color for the labels in the summary_panel_four.
        
        name_label_four.setText("<html><font color = #ffffff><b>N </b></font>" + category.get_item_array()[3].get_item_name());
        price_label_four.setText("<html><font color = #ffffff><b>P </b></font>" + category.get_item_array()[3].get_item_price_for_display());
        quantity_label_four.setText("<html><font color = #ffffff><b>S </b></font>" + category.get_item_array()[3].get_item_quantity());

        // Add the labels to the summary_four_panel.
        
        summary_panel_four.add(name_label_four);
        summary_panel_four.add(price_label_four);
        summary_panel_four.add(quantity_label_four);        
        
        // Set the layout, color, and border of the summary_panel_five.

        summary_panel_five.setLayout(new GridLayout(3, 1, 5, 5));
        summary_panel_five.setBackground(LIGHT_STEEL_BLUE);
        summary_panel_five.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        
        // Set the text and color for the labels in the summary_panel_five.
        
        name_label_five.setText("<html><font color = #ffffff><b>N </b></font>" + category.get_item_array()[4].get_item_name());
        price_label_five.setText("<html><font color = #ffffff><b>P </b></font>" + category.get_item_array()[4].get_item_price_for_display());
        quantity_label_five.setText("<html><font color = #ffffff><b>S </b></font>" + category.get_item_array()[4].get_item_quantity());
        
        // Add the labels to the summary_five_panel.
        
        summary_panel_five.add(name_label_five);
        summary_panel_five.add(price_label_five);
        summary_panel_five.add(quantity_label_five);        
        
        // Add the summary panel and spinner for each of the five items to the items_panel.
        
        items_panel.add(summary_panel_one);
        items_panel.add(spinner_one);
        
        items_panel.add(summary_panel_two);
        items_panel.add(spinner_two);
        
        items_panel.add(summary_panel_three);
        items_panel.add(spinner_three);
        
        items_panel.add(summary_panel_four);
        items_panel.add(spinner_four);
        
        items_panel.add(summary_panel_five);
        items_panel.add(spinner_five);
        
        // Set the layout of the main_panel.
        
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
        
        // Add the title_panel and the items_panel to the main_panel.
        
        main_panel.add(title_panel);
        main_panel.add(items_panel);
    }
    
    /**
     * Returns category.
     * 
     * @return 
     */
    public Category get_category() {
        return this.category;
    }
    
    /**
     * Returns main_panel.
     * 
     * @return 
     */
    public JPanel get_main_panel() {
        return this.main_panel;
    }
    
    /**
     * Returns spinner_values as an integer array (quantities are listed in order).
     * 
     * @return 
     */
    public int[] get_spinner_values() {
        
        int[] spinner_values = {(int) this.spinner_one.getValue(),
                                (int) this.spinner_two.getValue(),
                                (int) this.spinner_three.getValue(),
                                (int) this.spinner_four.getValue(),
                                (int) this.spinner_five.getValue()};
        
        return spinner_values;
    }
    
    public JPanel get_items_panel() {
        return this.items_panel;
    }
}