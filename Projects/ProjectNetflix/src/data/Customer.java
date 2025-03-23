package data;

public abstract class Customer {
	protected String customerID;
	protected int state;
	protected int daysLeft;
	
	public Customer(String customerID, int daysLeft) {
		this.customerID = customerID;
		this.daysLeft = daysLeft;
		this.expiredVerifier(daysLeft);
	}
	
	public void expiredVerifier(int daysLeft) {
		if(daysLeft > 0) {
			this.state = 1;
		} else {
			this.state = 0;
		}
	}
	
	@Override
	public String toString() {
		return customerID + ", " +  state + ", ";
	}
	
	public int getDaysLeft() {
		return daysLeft;
	}
	
	public abstract String recomendation();
}
