package business;

import java.io.Serializable;
import java.text.NumberFormat;

public class LineItem implements Serializable
{
    private CellPhone cellPhone;
    private int quantity;
    
    public LineItem() {}
    
   public void setCellPhone(CellPhone c){
       cellPhone = c;
   }
   
   public CellPhone getCellPhone(){
       return cellPhone;
   }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public int getQuantity()
    { 
        return quantity; 
    }
    
    public double getTotal()
    { 
        double total = cellPhone.getPrice() * quantity;
        return total;
    }
    
    public String getTotalCurrencyFormat()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}