package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import businessLogic.ClientsFile;
import data.Customer;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers;

        try {
            customers = ClientsFile.loadFile("clients.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("\nMenú principal:");
            System.out.println("1. Ver clientes y recomendaciones");
            System.out.println("2. Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 1:
                    clientsRecomendations(customers, scanner);
                    break;
                case 2:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        }
    }

    private static void clientsRecomendations(List<Customer> customers, Scanner scanner) {
    	List<Customer> newCustomers = sortList(customers);
        for (Customer customer : newCustomers) {
            System.out.println(customer);
        }
    }
    
    private static List<Customer> sortList(List<Customer> customers){
        List<Customer> customerCopy = new ArrayList<>(customers);
        customerCopy.sort(Comparator.comparingInt(Customer::getDaysLeft).reversed());
        
    	return customerCopy;
    }
}
