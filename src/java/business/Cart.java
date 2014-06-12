package business;

import java.util.ArrayList;

public class Cart
{
    private ArrayList<OrderLine> items;
    
    public Cart()
    {
        items = new ArrayList<>();
    }
    
    public ArrayList<OrderLine> getItems()
    { 
        return items;
    }
    
    public int getCount()
    { 
        return items.size();
    }
    
    public void addItem(OrderLine item)
    {
        int quantity = item.getQuantity();
		
        for (OrderLine lineItem : this.items) {
			if(lineItem.getItem().getItemID() == item.getItem().getItemID()) {
				int qty = lineItem.getQuantity() + quantity;
				
				if(qty > 0)
					lineItem.setQuantity(qty);
				else
					this.removeItem(lineItem);
				
				return;
			}
        }
		
		if(quantity < 0)
			return;
		
        items.add(item);
    }
    
	public void updateItem(OrderLine item) {
		for(OrderLine lineItem : items) {
			if(lineItem.getItem().getItemID() == item.getItem().getItemID()) {
				lineItem.setQuantity(item.getQuantity());
				return; 
			}
		}
	}
	
    public void removeItem(OrderLine item)
    {
		for(OrderLine lineItem : this.items) {
			if(lineItem.getItem().getItemID() == item.getItem().getItemID()) {
				this.items.remove(lineItem);
				return;
			}
		}
    }

	public double getTotal() {
		double total = 0.0;
		
		for(OrderLine orderLine : items)
			total += orderLine.getSubtotal();
		
		return total;
	}
}