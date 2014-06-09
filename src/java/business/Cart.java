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
		
        for (OrderLine lineItem : items) {
			if(lineItem.getItem().getItemID() == item.getItem().getItemID()) {
				lineItem.setQuantity(lineItem.getQuantity() + quantity);
				return;
			}
        }
		
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
}