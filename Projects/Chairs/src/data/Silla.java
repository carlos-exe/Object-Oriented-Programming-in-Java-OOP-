package data;

public abstract class Silla {
	protected String referencia;
	protected int precio;
	protected float calificacion;
	public boolean removible;
	
	public Silla(String referencia, int precio, float calificacion, boolean removible) {
		this.referencia = referencia;
		this.precio = precio;
		this.calificacion = calificacion;
		this.removible = removible;
	}
	@Override
	public String toString() {
		return "referencia= " + referencia + ", precio = " + precio + ", calificacion= " + calificacion;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
}
