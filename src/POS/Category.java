// Timothy Dement
// CSC 340-01: Software Engineering
// Andrew Holman
// Category.java

package POS;

public class Category {
    
    private String category_name;
    private Item[] item_array;
    
    /**
     * Constructor that takes no arguments, creates a "blank" Category.
     */
    public Category() {
        this.category_name = "EMPTY CATEGORY";
        this.item_array = new Item[5];
        this.item_array[0] = new Item();
        this.item_array[1] = new Item();
        this.item_array[2] = new Item();
        this.item_array[3] = new Item();
        this.item_array[4] = new Item();
    }
    
    /**
     * Constructor that takes two arguments and sets category_name and item_array.
     * 
     * @param category_name
     * @param item_array 
     */
    public Category(String category_name, Item[] item_array) {
        this.category_name = category_name;
        this.item_array = item_array;
    }
    
    /**
     * Returns category_name.
     * 
     * @return 
     */
    public String get_category_name() {
        return this.category_name;
    }
    
    /**
     * Returns item_array.
     * 
     * @return 
     */
    public Item[] get_item_array() {
        return this.item_array;
    }
    
    /**
     * Sets category_name to the given argument.
     * 
     * @param category_name 
     */
    public void set_category_name(String category_name) {
        this.category_name = category_name;
    }
    
    /**
     * Sets item_array to the given argument.
     * 
     * @param item_array 
     */
    public void set_item_list(Item[] item_array) {
        this.item_array = item_array;
    }
}