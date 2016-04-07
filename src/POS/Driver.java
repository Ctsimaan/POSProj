// Timothy Dement
// CSC 340-01: Software Engineering
// Andrew Holman
// Driver.java

/*
 * I am adding this comment to see if I can push it to the master branch.
 */

package POS;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Driver {
        
    public static void main(String[] args) throws IOException {
        
        Inventory inventory = initialize_inventory();
                        
        Employee employee = new Employee("Timothy Dement", "CASHIER", "username", "password");
        
        create_and_display_ui(employee, inventory);

        inventory.close();

    }
    
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
    
    public static Inventory initialize_inventory() throws IOException {
        
       Inventory inv = new Inventory();
       inv.initialize();
        
        // Initialize clothes.   
        Item hat = new Item("Hat", inv.ip[0][0].get_item_price_in_cents(), inv.ip[0][0].get_item_quantity());
        Item pants = new Item("Pants", inv.ip[0][1].get_item_price_in_cents(), inv.ip[0][1].get_item_quantity());
        Item shirt = new Item("Shirt", inv.ip[0][2].get_item_price_in_cents(), inv.ip[0][2].get_item_quantity());
        Item shoes = new Item("Shoes", inv.ip[0][3].get_item_price_in_cents(), inv.ip[0][3].get_item_quantity());
        Item socks = new Item("Socks", inv.ip[0][4].get_item_price_in_cents(), inv.ip[0][4].get_item_quantity());
        
        Item[] clothes_array = new Item[5];
        
        clothes_array[0] = hat;
        clothes_array[1] = pants;
        clothes_array[2] = shirt;
        clothes_array[3] = shoes;
        clothes_array[4] = socks;
        
        Category clothes = new Category("CLOTHES", clothes_array);
        
        // Initialize electronics.
        
        Item batteries = new Item("Batteries", inv.ip[1][0].get_item_price_in_cents(), inv.ip[1][0].get_item_quantity());
        Item charger = new Item("Charger", inv.ip[1][1].get_item_price_in_cents(), inv.ip[1][1].get_item_quantity());
        Item cord = new Item("Cord", inv.ip[1][2].get_item_price_in_cents(), inv.ip[1][2].get_item_quantity());
        Item headphones = new Item("Headphones", inv.ip[1][3].get_item_price_in_cents(), inv.ip[1][3].get_item_quantity());
        Item speaker = new Item("Speaker", inv.ip[1][4].get_item_price_in_cents(), inv.ip[1][4].get_item_quantity());
        
        Item[] electronics_array = new Item[5];
        
        electronics_array[0] = batteries;
        electronics_array[1] = charger;
        electronics_array[2] = cord;
        electronics_array[3] = headphones;
        electronics_array[4] = speaker;
        
        Category electronics = new Category("ELECTRONICS", electronics_array);
        
        // Initialize food.
        
        Item bread = new Item("Bread", inv.ip[2][0].get_item_price_in_cents(), inv.ip[2][0].get_item_quantity());
        Item eggs = new Item("Eggs",inv.ip[2][1].get_item_price_in_cents(), inv.ip[2][1].get_item_quantity());
        Item fruit = new Item("Fruit", inv.ip[2][2].get_item_price_in_cents(), inv.ip[2][2].get_item_quantity());
        Item meat = new Item("Meat", inv.ip[2][3].get_item_price_in_cents(), inv.ip[2][3].get_item_quantity());
        Item milk = new Item("Milk", inv.ip[2][4].get_item_price_in_cents(), inv.ip[2][4].get_item_quantity());
        
        Item[] food_array = new Item[5];
        
        food_array[0] = bread;
        food_array[1] = eggs;
        food_array[2] = fruit;
        food_array[3] = meat;
        food_array[4] = milk;
        
        Category food = new Category("FOOD", food_array);
        
        // Initialize hygiene.
       
        Item deodorant = new Item("Deodorant", inv.ip[3][0].get_item_price_in_cents(), inv.ip[3][0].get_item_quantity());
        Item razors = new Item("Razors", inv.ip[3][1].get_item_price_in_cents(), inv.ip[3][1].get_item_quantity());
        Item soap = new Item("Soap", inv.ip[3][2].get_item_price_in_cents(), inv.ip[3][2].get_item_quantity());
        Item toothbrush = new Item("Toothbrush", inv.ip[3][3].get_item_price_in_cents(), inv.ip[3][3].get_item_quantity());
        Item toothpaste = new Item("Toothpaste", inv.ip[3][4].get_item_price_in_cents(), inv.ip[3][4].get_item_quantity());
        
        Item[] hygiene_array = new Item[5];
        
        hygiene_array[0] = deodorant;
        hygiene_array[1] = razors;
        hygiene_array[2] = soap;
        hygiene_array[3] = toothbrush;
        hygiene_array[4] = toothpaste;
        
        Category hygiene = new Category("HYGIENE", hygiene_array);
        
        // Initialize office.
        
        Item folder = new Item("Folder", inv.ip[4][0].get_item_price_in_cents(), inv.ip[4][0].get_item_quantity());
        Item notebook = new Item("Notebook", inv.ip[4][1].get_item_price_in_cents(), inv.ip[4][1].get_item_quantity());
        Item paper = new Item("Paper", inv.ip[4][2].get_item_price_in_cents(), inv.ip[4][2].get_item_quantity());
        Item pencils = new Item("Pencils", inv.ip[4][3].get_item_price_in_cents(), inv.ip[4][3].get_item_quantity());
        Item stapler = new Item("Stapler", inv.ip[4][4].get_item_price_in_cents(), inv.ip[4][4].get_item_quantity());
        
        Item[] office_array = new Item[5];
        
        office_array[0] = folder;
        office_array[1] = notebook;
        office_array[2] = paper;
        office_array[3] = pencils;
        office_array[4] = stapler;
        
        Category office = new Category("OFFICE", office_array);
        
        // Initialize inventory.
        
        Category[] category_array = new Category[5];

        category_array[0] = clothes;
        category_array[1] = electronics;
        category_array[2] = food;
        category_array[3] = hygiene;
        category_array[4] = office;

        Inventory inventory = new Inventory(category_array, inv.ip);
        
        return inventory;
        
        }
    }
