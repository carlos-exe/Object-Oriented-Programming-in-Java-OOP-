package data;

public class FreeTrial extends TypeFree{
	public FreeTrial(String customerID, int daysLeft) {
		super(customerID, daysLeft);
	}
	
	@Override
	public String recomendation() {
		if(this.state > 0) {
			return "en periodo de prueba";
		} else {
			return "periodo de prueba finalizado";
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + recomendation(); 
	}
}
