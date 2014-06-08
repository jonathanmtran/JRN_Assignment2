package business;

import java.sql.Date;
import java.text.NumberFormat;

public class Order {
	private int orderId;
	private double total;
	private Date date;
	
	public Order() {}
	
	public Order(int id, double t, Date d) {
		orderId = id;
		total = t;
		date = d;
	}
	
	public Order setOrderId(int id) {
		orderId = id;
		return this;
	}
	
	public int getOrderId() { return orderId; }
	
	public Order setTotal(double t) {
		total = t;
		return this;
	}
	
	public double getTotal() { return total; }
	
	public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
	
	public Order setDate(Date d) {
		date = d;
		return this;
	}
	
	public Date getDate() { return date; }
}
