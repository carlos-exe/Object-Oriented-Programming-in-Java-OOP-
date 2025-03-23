package data;

public class Masajeadora extends NoRemovibles {
	private int modo_uso;
	private String calefaccion;
	
	public Masajeadora(String ref, int precio, float calificacion, int modo_uso, String calefaccion) {
        super(ref, precio, calificacion);
        this.modo_uso = modo_uso;
        this.calefaccion = calefaccion;
    }
	
    @Override
    public String toString() {
        return "Secretarial [" + super.toString() + " modos de uso= " + modo_uso + " calefaccion= " + calefaccion +"]";
    }
}
