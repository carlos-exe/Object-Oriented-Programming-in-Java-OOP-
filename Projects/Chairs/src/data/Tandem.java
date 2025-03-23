package data;

public class Tandem extends NoRemovibles{
	private int puestos;
	
	public Tandem(String ref, int precio, float calificacion, int puestos) {
		super(ref, precio, calificacion);
		this.puestos = puestos;
	}
	@Override
	public String toString() {
		return "Tandem [" + super.toString() + " , puestos= " + this.puestos + "]";
	}
}
