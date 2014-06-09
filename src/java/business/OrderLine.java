package business;

import java.io.Serializable;
import java.text.NumberFormat;

public class OrderLine implements Serializable
{
	private int orderlineId;
	private int orderId;
	private Item item;
    private int quantity;
	
	public OrderLine() {}
    
	public OrderLine(Item i, int qty) {
		this.item = i;
		this.quantity = qty;
	}
	
	public OrderLine setOrderlineId(int id) {
		this.orderlineId = id;
		return this;
	}
	
	public int getOrderlineId() {
		return this.orderlineId;
	}
	
	public OrderLine setOrderId(int id) {
		this.orderId = id;
		return this;
	}
	
	public int getOrderId() { 
		return this.orderId;
	}
	
	public OrderLine setItem(Item i) {
       item = i;
	   return this;
	}
   
	public Item getItem() {
       return item;
	}

    public OrderLine setQuantity(int quantity)
    {
        this.quantity = quantity;
		return this;
    }
    
    public int getQuantity()
    { 
        return quantity; 
    }
    
    public double getSubtotal() { 
        double total = item.getPrice() * quantity;
        return total;
    }
    
    public String getTotalCurrencyFormat()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getSubtotal());
    }
}
