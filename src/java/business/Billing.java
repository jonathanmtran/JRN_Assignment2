package business;

public class Billing {
	private int billingId;
	private int orderId;
	private String email;
	private String cardHolderName;
	private String cardNumber;
	private String expirationMonth;
	private String expirationYear;
	private String secureCode;
	
	public Billing() {}
	
	public Billing(int billing, int order, String emailAddress, String name, 
		String number, String month, String year, String code) {
		this.billingId = billing;
		this.orderId = order;
		this.email = emailAddress;
		this.cardHolderName = name;
		this.cardNumber = number;
		this.expirationMonth = month;
		this.expirationYear = year;
		this.secureCode = code;
	}
	
	public Billing setBillingId(int id) { 
		this.billingId = id;
		return this;
	}
	
	public int getBillingId() { return this.billingId; }
	
	public Billing setOrderId(int id) {
		this.orderId = id;
		return this;
	}
	
	public int getOrderId() { return orderId; }
	
	public Billing setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getEmail() { return this.email; }
	
	public Billing setCardHolderName(String name) {
		this.cardHolderName = name;
		return this;
	}
	
	public String getCardHolderName() { return this.cardHolderName; }
	
	public Billing setCardNumber(String cn) {
		this.cardNumber = cn;
		return this;
	}
	
	public String getCardNumber() { return this.cardNumber; }
	
	public Billing setExpirationMonth(String month) {
		this.expirationMonth = month;
		return this;
	}
	
	public String getExpirationMonth() { return this.expirationMonth; }
	
	public Billing setExpirationYear(String year) {
		this.expirationYear = year;
		return this;
	}
	
	public String getExpirationYear() { return this.expirationYear; }
	
	public Billing setSecureCode(String code) {
		this.secureCode = code;
		return this;
	}
	
	public String getSecureCode() { return this.secureCode; }
}
