// Timothy Dement
// CSC 340-01: Software Engineering
// Andrew Holman
// Inventory.java

package POS;

import java.io.*;

public class Inventory{
    
    private Category[] category_array;
//    public Item[][] ip;
    
    public Inventory() {
        this.category_array = new Category[5];
        this.category_array[0] = new Category();
        this.category_array[1] = new Category();
        this.category_array[2] = new Category();
        this.category_array[3] = new Category();
        this.category_array[4] = new Category();
    }
    
    public Inventory(Category[] category_array) {
        this.category_array = category_array;
        
    }

//    public Inventory(Category[] category_array, Item[][] ip){
//        this.category_array = category_array;
//        this.ip = ip;
//    }
    
    public void initialize_from_file() throws IOException{
   
        BufferedReader in = new BufferedReader(new FileReader(new File("inventory.txt")));
        
        String input;
        
        for (int category_index = 0; category_index < 5; category_index++) {
            
            input = in.readLine();
            this.category_array[category_index].set_category_name(input);
            
            for (int item_index = 0; item_index < 5; item_index++) {
                
                input = in.readLine();
                this.category_array[category_index].get_item_array()[item_index].set_item_name(input);
                
                input = in.readLine();
                this.category_array[category_index].get_item_array()[item_index].set_item_price_in_cents(Integer.parseInt(input));
                
                input = in.readLine();
                this.get_category_array()[category_index].get_item_array()[item_index].set_item_quantity(Integer.parseInt(input));
                
            }
        }
        
        in.close();
    }

    
    public void save_to_file() throws IOException{        

        BufferedWriter out = new BufferedWriter(new FileWriter(new File("inventory.txt")));

        for (int category_index = 0; category_index < 5; category_index++) {
            
            out.write(this.category_array[category_index].get_category_name());
            out.newLine();
            
            for (int item_index = 0; item_index < 5; item_index++) {
                
                out.write(this.category_array[category_index].get_item_array()[item_index].get_item_name());
                out.newLine();
                
                out.write("" + this.category_array[category_index].get_item_array()[item_index].get_item_price_in_cents());
                out.newLine();
                
                out.write("" + this.category_array[category_index].get_item_array()[item_index].get_item_quantity());
                out.newLine();
            }
            
            
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
    public void sell_items(int[][] items_to_be_sold) {
        
        // IDEA — take a 5x5 INTEGER array representing what should be sold (get this from the spinners), and update the inventory accordingly.
        // Make sure to refresh the UI and save this new info to the file.
        
    }
    
    // NEED TO IMPLEMENT THIS -- should it take more than one Item?
    public void return_items(int[][] items_to_be_returned) {
        
        // SEE ABOVE
        
    }
    
    // NEED TO IMPLEMENT THIS -- should it take more than one Item?
    public void order_items(int[][] items_to_be_ordered) {
        
        // SEE ABOVE
        
    }
}