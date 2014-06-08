package business;

import java.text.NumberFormat;

public class Item
{
    private int itemID;
    private String name;
    private String description;
    private String specs;
    private String imageLoc;	
    private Double price;
    
    public Item() {}
	
    public Item(String n, String i, String d, String s, Double p)
    {
        this.name = n;
        this.imageLoc = i;
        this.description = d;
        this.specs = s;
        this.price = p;
    }
    
    public int getItemID() {
        return itemID;
    }
    
    public Item setItemID(int c) {
        itemID = c;
		return this;
    }
    
    public String getName() {
        return name;
    }
	
    public Item setName(String n) {
        name = n;
		return this;
    }
	
    public String getImageLoc() {
        return imageLoc;
    }
	
    public Item setImageLoc(String i) {
        imageLoc = i;
		return this;
    }
	
    public String getDescription() {
        return description;
    }
	
    public Item setDescription(String d) {
        description = d;
		return this;
    }
    
    public String getSpecs() {
        return specs;
    }
    
    public Item setSpecs(String s) {
        specs = s;
		return this;
    }
    
    public Double getPrice() {
        return price;
    }
	
    public Item setPrice(Double p) {
        price = p;
		return this;
    }
    
    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }   
}
