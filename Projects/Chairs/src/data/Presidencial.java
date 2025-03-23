package data;

public class Presidencial extends Removibles {
    private String origen;

    public Presidencial(String ref, int precio, float calificacion, String origen) {
        super(ref, precio, calificacion);
        this.origen = origen;
    }

    @Override
    public String removerDelCatalogo() {
        if (this.origen.equalsIgnoreCase("si") && (this.calificacion < 3.5 || this.precio > 400000)) {
            return "remove";
        }
        return "keep";
    }

    @Override
    public String toString() {
        return "Presidencial [" + super.toString() + ", origen= " + origen + "]";
    }
}
