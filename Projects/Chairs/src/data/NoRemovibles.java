package data;

public class NoRemovibles extends Silla{
	private static boolean removible = false;

	public NoRemovibles(String referencia, int precio, float calificacion) {
		super(referencia, precio, calificacion, removible);
	}
	
}
