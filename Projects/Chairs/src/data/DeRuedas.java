package data;

public class DeRuedas extends NoRemovibles{
	private String traccion;
	
	public DeRuedas(String ref, int precio, float calificacion, String traccion) {
		super(ref, precio, calificacion);
		this.traccion = traccion;
	}

	@Override
	public String toString() {
		return "DeRuedas [" + super.toString() + " , origen= " + this.traccion + "]";
	}
}
