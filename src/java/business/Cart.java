package business;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable
{
    private ArrayList<LineItem> items;
    
    public Cart()
    {
        items = new ArrayList<LineItem>();
    }
    
    public ArrayList<LineItem> getItems()
    { 
        return items;
    }
    
    public int getCount()
    { 
        return items.size();
    }
    
    public void addItem(LineItem item)
    {
        String code = item.getCellPhone().getCode();
        int quantity = item.getQuantity();
        for (LineItem lineItem : items) {
            if (lineItem.getCellPhone().getCode().equals(code))
            {
                lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }
    
    public void removeItem(LineItem item)
    {
        String code = item.getCellPhone().getCode();
        for (int i = 0; i < items.size(); i++)
        {
            LineItem lineItem = items.get(i);
            if (lineItem.getCellPhone().getCode().equals(code))
            {
                items.remove(i);
                return;
            }
        }
    }
}