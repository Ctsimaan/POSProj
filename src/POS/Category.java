// Timothy Dement
// CSC 340-01: Software Engineering
// Andrew Holman
// Category.java

package POS;

public class Category {
    
    private String category_name;
    private Item[] item_array;
    
    public Category() {
        this.category_name = "";
        this.item_array = null;
    }
    
    public Category(String category_name, Item[] item_array) {
        this.category_name = category_name;
        this.item_array = item_array;
    }
    
    public String get_category_name() {
        return this.category_name;
    }
    
    public Item[] get_item_list() {
        return this.item_array;
    }
    
    public void set_category_name(String category_name) {
        this.category_name = category_name;
    }
    
    public void set_item_list(Item[] item_array) {
        this.item_array = item_array;
    }
}