package ui;

import java.util.Scanner;

import data.AntiqueShop;

public class UserInterface {
	private AntiqueShop store;
	
	public UserInterface(AntiqueShop store1) {
		this.store = store1;
	}
	public void showMenu() {
		System.out.println("=========================");
		System.out.println("           Menu          ");
		System.out.println("=========================");
		System.out.println("1. Mostrar Items");
		System.out.println("2. Salir");
		System.out.println("=========================");
	}
	
	public void readOption() {
	    System.out.print("Seleccione una opción: ");
	    Scanner s = new Scanner(System.in);
	    
	    switch(s.nextLine()) {
	    	case "1":
	    		this.showItems(this.store);
	    	case "2":
	    		System.exit(1);
    		default:
    			this.wrongOption();
	    }
	    s.close();
	}
	
	public void wrongOption() {
		System.out.println("Opción no válida");
		System.exit(1);
	}
	
	public void showItems(AntiqueShop store) {
		System.out.println("=========================");
		System.out.println("          Items          ");
		System.out.println("=========================");
		store.showAllVases();
		store.showAllStatues();
		store.showAllPaintings();
	}
}
