package data;

public class Premium extends TypePaid{
	public Premium(String customerID, int daysLeft, int months) {
		super(customerID, daysLeft, months);
	}
	
	@Override
	public String recomendation() {
		if(this.state > 0) {
			return "siga suscrito";
		} else {
			return "renueve su plan";
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + recomendation(); 
	}
}
