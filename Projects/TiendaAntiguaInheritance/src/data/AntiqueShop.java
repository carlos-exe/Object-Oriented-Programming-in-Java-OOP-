package data;

import java.util.ArrayList;

import businessLogic.InventoryManager;

public class AntiqueShop {
	private InventoryManager inventory;
	
	public AntiqueShop(InventoryManager im) {
		this.inventory = im;
	}
	
	public void showAllItems() {
		ArrayList<Item> items = this.inventory.getItems();
		for(Item i: items) {
			System.out.println(i);
		}
	}
}
