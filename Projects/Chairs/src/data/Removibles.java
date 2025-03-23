package data;

public abstract class Removibles extends Silla{
	public static boolean removible = true;
	
	public Removibles(String referencia, int precio, float calificacion) {
		super(referencia, precio, calificacion, removible);
	}

	public abstract String removerDelCatalogo();
}
