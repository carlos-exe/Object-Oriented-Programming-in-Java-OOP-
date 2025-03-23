package businessLogic;

import data.*;
import java.io.*;
import java.util.*;

public class CatalogoSillas {
	
	public static List<Silla> cargarSillas(String archivo) throws IOException {
        List<Silla> sillas = new ArrayList<>();
        InputStream input = CatalogoSillas.class.getClassLoader().getResourceAsStream(archivo);

        if (input == null) {
            throw new FileNotFoundException("No se encontró el archivo: " + archivo);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(", ");
            String tipo = partes[1];
            String ref = partes[0];
            int precio = Integer.parseInt(partes[2]);
            float calificacion = Float.parseFloat(partes[3]);

            switch (tipo.toLowerCase()) {
                case "gerencial":
                    sillas.add(new Gerencial(ref, precio, calificacion));
                    break;
                case "presidencial":
                    String origen = partes[4];
                    sillas.add(new Presidencial(ref, precio, calificacion, origen));
                    break;
                case "secretarial":
                    sillas.add(new Secretarial(ref, precio, calificacion));
                    break;
                case "de ruedas":
                    String traccion = partes[4];
                    sillas.add(new DeRuedas(ref, precio, calificacion, traccion));
                    break;
                case "tandem":
                    int puestos = Integer.parseInt(partes[4]);
                    sillas.add(new Tandem(ref, precio, calificacion, puestos));
                    break;
                case "masajeadora":
                    int modos_uso = Integer.parseInt(partes[4]);
                    String calefaccion = partes[5];
                    sillas.add(new Masajeadora(ref, precio, calificacion, modos_uso, calefaccion));
                    break;
            }
        }

        br.close();
        return sillas;
    }
}