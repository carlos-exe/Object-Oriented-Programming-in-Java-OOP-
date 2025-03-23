// Carlos Andrés Ordóñez Cerón

package businessLogic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import data.*;
import data.Character;


public class FileLoader {
	public static List<Character> loadFile(String file) throws IOException {
        List<Character> characters = new ArrayList<>();
        InputStream input = FileLoader.class.getClassLoader().getResourceAsStream(file);

        if (input == null) {
            throw new FileNotFoundException("No se encontró el archivo: " + file);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line;

        while ((line = br.readLine()) != null) {
        	try {
	            String[] parts = line.split(", ");
	            String characterID = parts[0];
	            String characterType = parts[1];
	            int level = Integer.parseInt(parts[2]);
	            int gold = Integer.parseInt(parts[3]);
	
	            switch (characterType.toLowerCase()) {
	                case "wizard":
	                    characters.add(new Wizard(characterID,level,gold));
	                    break;
	                case "warrior":
	                    characters.add(new Warrior(characterID,level,gold));
	                    break;
	                case "support":
	                    characters.add(new Support(characterID,level,gold));
	                    break;
                    }
        	}catch (Exception e) {
                System.err.println("Línea mal formateada: " + line);
        	}
        }

        br.close();
        return characters;
    }
}
