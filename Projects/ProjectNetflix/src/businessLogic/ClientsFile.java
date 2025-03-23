package businessLogic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import data.Basic;
import data.Customer;
import data.FreeTrial;
import data.Premium;
import data.Standard;


public class ClientsFile {
	public static List<Customer> loadFile(String file) throws IOException {
        List<Customer> customers = new ArrayList<>();
        InputStream input = ClientsFile.class.getClassLoader().getResourceAsStream(file);

        if (input == null) {
            throw new FileNotFoundException("No se encontró el archivo: " + file);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line;

        while ((line = br.readLine()) != null) {
        	try {
	            String[] parts = line.split(", ");
	            String ID = parts[0];
	            String type = parts[1];
	            int daysLeft = Integer.parseInt(parts[2]);
	
	            switch (type.toLowerCase()) {
	                case "freetrial":
	                    customers.add(new FreeTrial(ID,daysLeft));
	                    break;
	                case "basic":
	                    int months_b = Integer.parseInt(parts[3]);
	                    customers.add(new Basic(ID,daysLeft,months_b));
	                    break;
	                case "standard":
	                    int months_s = Integer.parseInt(parts[3]);
	                    customers.add(new Standard(ID,daysLeft,months_s));
	                    break;
	                case "premium":
	                    int months_p = Integer.parseInt(parts[3]);
	                    customers.add(new Premium(ID,daysLeft,months_p));
	                    break;
	            }
        	}catch (Exception e) {
                System.err.println("Línea mal formateada: " + line);
        	}
        }

        br.close();
        return customers;
    }
}
