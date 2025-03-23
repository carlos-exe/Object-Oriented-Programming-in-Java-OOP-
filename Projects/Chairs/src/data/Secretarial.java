package data;

public class Secretarial extends Removibles {
    public Secretarial(String ref, int precio, float calificacion) {
        super(ref, precio, calificacion);
    }

    @Override
    public String removerDelCatalogo() {
        if (this.calificacion < 3 || this.precio > 200000) {
            return "remove";
        }
        return "keep";
    }

    @Override
    public String toString() {
        return "Secretarial [" + super.toString() + "]";
    }
}
