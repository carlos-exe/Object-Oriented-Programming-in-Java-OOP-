package businessLogic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import data.Item;
import data.Painting;
import data.Statue;
import data.Vase;

public class InventoryManager {
	private String fileName = "items.txt";
	private ArrayList<Item> items;
	
	public InventoryManager(String filename) {
		this.fileName = filename;
		this.items = new ArrayList<Item>();
	}
	
	public void readingRecords() {
	    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.fileName);
	            Scanner in = new Scanner(inputStream)) {
	
	           if (inputStream == null) {
	               throw new FileNotFoundException("Archivo no encontrado en resources: " + this.fileName);
	           }
	
	           readItem(in);
	
	       } catch (FileNotFoundException e) {
	           System.out.println("Archivo no encontrado: " + this.fileName);
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	}
	
	private void readItem(Scanner sc) {
		while(sc.hasNext()) {
			String line = sc.nextLine();
			processLine(line);
		}
	}
	
	private void processLine(String line) {
		Scanner sc = new Scanner(line);
		sc.useDelimiter(",");
		String category = sc.next().trim().toLowerCase();
		
		switch(category) {
		case "vase":
			this.createVase(sc);
			break;
		case "statue":
			this.createStatue(sc);
			break;
		case "painting":
			this.createPainting(sc);
			break;
		default:
			System.out.println("Uknown Category" + category);
			System.exit(1);
		}
		sc.close();
	}
	
	private void createStatue(Scanner sc) {
		String creator = sc.next().trim();
		int value = Integer.parseInt(sc.next().trim());
		int weight = Integer.parseInt(sc.next().trim());
		String colour = sc.next().trim();
		Statue newStatue = new Statue(value,creator,weight,colour);
		this.items.add(newStatue);
	}
	
	private void createVase(Scanner sc) {
		String creator = sc.next().trim();
		int value = Integer.parseInt(sc.next().trim());
		int height = Integer.parseInt(sc.next().trim());
		String material = sc.next().trim();
		Vase newVase = new Vase(value,creator,height,material);
		this.items.add(newVase);
	}
	
	private void createPainting(Scanner sc) {
		String creator = sc.next().trim();
		int value = Integer.parseInt(sc.next().trim());
		int height = Integer.parseInt(sc.next().trim());
		int width = Integer.parseInt(sc.next().trim());
		boolean isWaterColour = Boolean.parseBoolean(sc.next().trim());
		boolean isFramed = Boolean.parseBoolean(sc.next().trim());
		Painting newPainting = new Painting(value,creator,height,width,isWaterColour,isFramed);
		this.items.add(newPainting);
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}

}
