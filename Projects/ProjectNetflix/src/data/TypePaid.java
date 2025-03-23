package data;

public abstract class TypePaid extends Customer{
	protected int months;
	
	public TypePaid(String customerID, int daysLeft, int months) {
		super(customerID, daysLeft);
		this.months = months;
	}
}
