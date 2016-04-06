// Timothy Dement
// CSC 340-01: Software Engineering
// Andrew Holman
// Item.java

package POS;

public class Item {
    
    private String item_name;
    private int item_price_in_cents;
    private int item_quantity;
    
    public Item() {
        this.item_name = "";
        this.item_price_in_cents = 0;
        this.item_quantity = 0;
    }
    
    public Item(String item_name, int item_price_in_cents, int item_quantity) {
        this.item_name = item_name;
        this.item_price_in_cents = item_price_in_cents;
        this.item_quantity = item_quantity;
    }
    
    public String get_item_name() {
        return this.item_name;
    }
    
    public int get_item_price_in_cents() {
        return this.item_price_in_cents;
    }
    
    // FIX THIS
    
    public String get_item_price_for_display() {
        
        String cents_string = new Integer(this.item_price_in_cents).toString();
        
        String display;
        
        if (this.item_price_in_cents < 10) {
            
            display = "$0.0" + cents_string;
            
        } else if (this.item_price_in_cents < 100) {
            
            display = "$0." + cents_string;
            
        } else {
        
            int length = cents_string.length();
        
            display = "$" + cents_string.substring(0, length - 2) + "." + cents_string.substring(length - 2, length);
            
        }
        
        return display;
    }
    
    public int get_item_quantity() {
        return this.item_quantity;
    }
    
    public void set_item_name(String item_name) {
        this.item_name = item_name;
    }
    
    public void set_item_price_in_cents(int item_price_in_cents) {
        this.item_price_in_cents = item_price_in_cents;
    }
    
    public void set_item_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }
    
    public String toString() {
        
        String display = "[" + this.get_item_quantity() + "] " + this.get_item_name() + " (" + this.get_item_price_for_display() + ")";
        
        return display;
    }
}