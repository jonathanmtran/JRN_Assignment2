package business;

import java.io.Serializable;
import java.text.NumberFormat;

public class LineItem implements Serializable
{
    private Item item;
    private int quantity;
    
	public LineItem() {}
    
	public LineItem setCellPhone(Item i){
       item = i;
	   return this;
	}
   
	public Item getItem(){
       return item;
	}

    public LineItem setQuantity(int quantity)
    {
        this.quantity = quantity;
		return this;
    }
    
    public int getQuantity()
    { 
        return quantity; 
    }
    
    public double getTotal()
    { 
        double total = item.getPrice() * quantity;
        return total;
    }
    
    public String getTotalCurrencyFormat()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}