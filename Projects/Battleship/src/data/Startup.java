package data;

import java.util.ArrayList;

public class Startup {
	private ArrayList<String> locationCells;
	private String name;
	private HelperOfHelper helper = new HelperOfHelper();
	private String alphabet = helper.getAlphabet();
	private int intLimit = helper.getGridLength();

	public void setLocationCells(ArrayList<String> loc) {
		locationCells = loc;
	}

	public void setName(String n) {
		name = n;
	}

	public String checkYourself(String userInput) {
		String letter = userInput.replaceAll("[^a-zA-Z]", ""); // Mantiene solo letras
        String number = userInput.replaceAll("[^0-9]", "");   // Mantiene solo números
        if((alphabet.contains(letter)) && (Integer.parseInt(number) >= 1) && (Integer.parseInt(number) <= intLimit )) {
    		String result = "Fallo";
    		int index = locationCells.indexOf(userInput);
    		if (index >= 0) {
    			locationCells.remove(index);
    			if (locationCells.isEmpty()) {
    				result = "Destruido";
    				System.out.println("Ouch! Hundiste a " + name + " : ( ");
    			} else {
    				result = "Acierto";
    			} // end if
    		} // end outer if
    		return result;
        } else {
        	String result = "Ingrese un dato válido";
        	return result;
        }
	} // end method
} // close class
