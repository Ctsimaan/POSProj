// Timothy Dement
// CSC 340-01: Software Engineering
// Andrew Holman
// Inventory.java

package POS;

import java.io.*;

public class Inventory{
    
    private Category[] category_array;
    public Item[][] ip;
    
    public Inventory() {
        this.category_array = null;
    }
    
    public Inventory(Category[] category_array) {
        this.category_array = category_array;
        
    }
    public Inventory(Category[] category_array, Item[][] ip){
        this.category_array = category_array;
        this.ip = ip;
    }
    
    public Item[][] initialize() throws IOException{
   
        BufferedReader in = new BufferedReader(new FileReader(new File("p.txt")));
        int row = 0;
        int col = 0;
        ip = new Item[5][5];
        while (row < 5){
            col = 0;
            while(col < 5){
                ip[row][col] = new Item();
                String input = in.readLine();
                ip[row][col].set_item_name(input);
                System.out.println("" + ip[row][col].get_item_name());
                input = in.readLine();
                ip[row][col].set_item_quantity(Integer.parseInt(input));
                input = in.readLine();
                ip[row][col].set_item_price_in_cents(Integer.parseInt(input));
                col++;
            }
            row++;      
        }
    return ip;
    }
    
    public void close() throws IOException{        
        this.ip = ip;
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("p.txt")));
        int row = 0;
        int col = 0;
        while (row < 5){
            col = 0;
            while(col < 5){
                String ref = "";
                out.write(ip[row][col].get_item_name());
                out.newLine();
                out.write(ip[row][col].get_item_quantity() + "");
                out.newLine();
                out.write(ip[row][col].get_item_price_in_cents() + "");
                out.newLine();
                col++;
            }
            row++;      
        }
        out.close();
    }
    
   
    public Category[] get_category_array() {
        return this.category_array;
    }
    
    public void set_category_list(Category[] category_array) {
        this.category_array = category_array;
    }
    
    // NEED TO IMPLEMENT THIS -- should it take more than one Item?
    public void sell_item(Item item) {
        
    }
    
    // NEED TO IMPLEMENT THIS -- should it take more than one Item?
    public void return_item(Item item) {
        
    }
    
    // NEED TO IMPLEMENT THIS -- should it take more than one Item?
    public void order_item(Item item) {
        
    }
}