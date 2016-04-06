// Timothy Dement
// CSC 340-01: Software Engineering
// Andrew Holman
// CategoryPanel.java

package POS;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends JPanel {
    
    private final Color DARK_SLATE_BLUE = new Color(72, 61, 139);
    private final Color LIGHT_STEEL_BLUE = new Color(176, 196, 222);
    
    private JPanel main_panel = new JPanel();
    
    private Category category;
    
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
    
    private JSpinner spinner_one = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
    private JSpinner spinner_two = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
    private JSpinner spinner_three = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
    private JSpinner spinner_four = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
    private JSpinner spinner_five = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
    
    public CategoryPanel(Category category) {
        
        this.category = category;
        
        JPanel title_panel = new JPanel();
        title_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        title_panel.setBackground(DARK_SLATE_BLUE);
        
        category_label.setText(category.get_category_name());
        category_label.setForeground(Color.WHITE);
        
        title_panel.add(category_label);
        
        JPanel items_panel = new JPanel();
        items_panel.setLayout(new GridLayout(5, 3, 5, 5));
        items_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        items_panel.setBackground(LIGHT_STEEL_BLUE);

        name_label_one.setText(category.get_item_list()[0].get_item_name());
        price_label_one.setText(category.get_item_list()[0].get_item_price_for_display());
        price_label_one.setHorizontalAlignment(JLabel.CENTER);
        
        name_label_two.setText(category.get_item_list()[1].get_item_name());
        price_label_two.setText(category.get_item_list()[1].get_item_price_for_display());
        price_label_two.setHorizontalAlignment(JLabel.CENTER);

        name_label_three.setText(category.get_item_list()[2].get_item_name());
        price_label_three.setText(category.get_item_list()[2].get_item_price_for_display());
        price_label_three.setHorizontalAlignment(JLabel.CENTER);

        name_label_four.setText(category.get_item_list()[3].get_item_name());
        price_label_four.setText(category.get_item_list()[3].get_item_price_for_display());
        price_label_four.setHorizontalAlignment(JLabel.CENTER);

        name_label_five.setText(category.get_item_list()[4].get_item_name());
        price_label_five.setText(category.get_item_list()[4].get_item_price_for_display());
        price_label_five.setHorizontalAlignment(JLabel.CENTER);
        
        items_panel.add(name_label_one);
        items_panel.add(price_label_one);
        items_panel.add(spinner_one);
        
        items_panel.add(name_label_two);
        items_panel.add(price_label_two);
        items_panel.add(spinner_two);
        
        items_panel.add(name_label_three);
        items_panel.add(price_label_three);
        items_panel.add(spinner_three);
        
        items_panel.add(name_label_four);
        items_panel.add(price_label_four);
        items_panel.add(spinner_four);
        
        items_panel.add(name_label_five);
        items_panel.add(price_label_five);
        items_panel.add(spinner_five);
        
        main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
        
        main_panel.add(title_panel);
        main_panel.add(items_panel);
    }
    
    public Category get_category() {
        return this.category;
    }
    
    public JPanel get_main_panel() {
        return this.main_panel;
    }
    
    public int[] get_spinner_values() {
        
        int[] spinner_values = {(int) this.spinner_one.getValue(),
                                (int) this.spinner_two.getValue(),
                                (int) this.spinner_three.getValue(),
                                (int) this.spinner_four.getValue(),
                                (int) this.spinner_five.getValue()};
        
        return spinner_values;
    }
}