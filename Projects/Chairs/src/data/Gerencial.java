package data;

public class Gerencial extends Removibles{
	public Gerencial(String ref, int precio, float calificacion) {
		super(ref, precio, calificacion);
	}
	@Override
	public String removerDelCatalogo() {
		if (this.calificacion < 4 || this.precio > 300000)
			return "remove";
		return "keep";
	}
	@Override
	public String toString() {
		return "Gerencial [" + super.toString() + "]";
	}
}
