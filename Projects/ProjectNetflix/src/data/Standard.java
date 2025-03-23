package data;

public class Standard extends TypePaid{
	public Standard(String customerID, int daysLeft, int months) {
		super(customerID, daysLeft, months);
	}
	
	@Override
	public String recomendation() {
		if(this.state > 0) {
			return "siga suscrito";
		} else {
			return check_months();
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + recomendation(); 
	}
	
	public String check_months() {
		if(this.months >= 3) {
			return "adquiera el plan Premium";
		} else {
			return "renueve su plan";
		}
	}
}
