package ui;

import data.*;
import businessLogic.*;
import java.util.*;
import java.io.*;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Silla> sillas;
        List<Removibles> sillasToRemove;

        try {
            sillas = CatalogoSillas.cargarSillas("sillas.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            scanner.close();
            return;
        }
        
        sillasToRemove = removerSillas(sillas);

        while (true) {
            System.out.println("\nMenú principal:");
            System.out.println("1. Ver sillas por categoría");
            System.out.println("2. Ver qué sillas salen del catálogo");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    verSillasPorCategoria(sillas, scanner);
                    break;
                case 2:
                    verSillasARemover(sillasToRemove);
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        }
    }

    private static void verSillasPorCategoria(List<Silla> sillas, Scanner scanner) {
    	String categoria = "";
    	
        System.out.println("\nCategorías:");
        System.out.println("1. Presidencial");
        System.out.println("2. Gerencial");
        System.out.println("3. Secretarial");
        System.out.println("4. De Ruedas");
        System.out.println("5. Tandem");
        System.out.println("6. Masajeadora");
        System.out.println("t. Volver al menú principal");

        String option = scanner.nextLine().toLowerCase();
        
        switch(option) {
        	case "1":
        		categoria = "presidencial";
        		break;
        	case "2":
        		categoria = "gerencial";
        		break;
        	case "3":
        		categoria = "secretarial";
        		break;
        	case "4":
        		categoria = "de ruedas";
        		break;
        	case "5":
        		categoria = "tandem";
        		break;
        	case "6":
        		categoria = "masajeadora";
        		break;
        	default:
                System.out.println("Opción no válida, por favor intente nuevamente.");
        }

        for (Silla silla : sillas) {
            if (silla.getClass().getSimpleName().equalsIgnoreCase(categoria)) {
                System.out.println(silla);
            }
        }
    }

    private static void verSillasARemover(List<Removibles> sillas) {
        System.out.println("\nSillas a evaluar:");
        for (Removibles b : sillas) {
            System.out.println(b.getReferencia() + ", " + b.removerDelCatalogo());
        }
    }
    
    private static List<Removibles> removerSillas(List<Silla> sillas){
    	List<Removibles> remove = new ArrayList<>();
    	
    	for (Silla silla : sillas) {
            if(silla.removible)
            	remove.add((Removibles) silla);
        }
    	
    	return remove;
    }
}
