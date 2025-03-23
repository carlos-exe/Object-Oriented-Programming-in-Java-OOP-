// Carlos Andrés Ordóñez Cerón

package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import businessLogic.FileLoader;
import data.Character;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Character> characters;

        try {
            characters = FileLoader.loadFile("characters.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            scanner.close();
            return;
        }

        while (true) {
        	
        	showOutput(characters);
            
            System.out.println("Presione 1 para terminar");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 1:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        }
    }

    private static void showOutput(List<Character> characters) {
    	List<Character> newCharacters = sortList(characters);
        for (Character character : newCharacters) {
            System.out.println(character);
        }
        System.out.println();
    }
    
    private static List<Character> sortList(List<Character> characters){
        List<Character> customerCopy = new ArrayList<>(characters);
        customerCopy.sort(Comparator.comparingInt(Character::getGold).reversed());
        
    	return customerCopy;
    }
}
