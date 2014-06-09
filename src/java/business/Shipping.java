package business;

public class Shipping {
	private int shippingId;
	private int orderId;
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Shipping() {}
	
	public Shipping(int shipping, int order, String n, String s, String c, String st, String z) {
		this.shippingId = shipping;
		this.orderId = order;
		this.name = n;
		this.street = s;
		this.city = c;
		this.state = st;
		this.zip = z;
	}
	
	public Shipping setShippingId(int id) {
		this.shippingId = id;
		return this;
	}
	
	public int getShippingId() { return this.shippingId; }
	
	public Shipping setOrderId(int id) {
		this.orderId = id;
		return this;
	}
	
	public int getOrderId() { return this.orderId; }
	
	public Shipping setName(String n) {
		this.name = n;
		return this;
	}
	
	public String getName() { return this.name; }
	
	public Shipping setStreet(String street) {
		this.street = street;
		return this;
	}
	
	public String getStreet() { return this.street; }
	
	public Shipping setCity(String c) {
		this.city = c;
		return this;
	}
	
	public String getCity() { return this.city; }
	
	public Shipping setState(String s) {
		this.state = s;
		return this;
	}
	
	public String getState() { return this.state; }
	
	public Shipping setZip(String z) {
		this.zip = z;
		return this;
	}
	
	public String getZip() { return this.zip; }
}
