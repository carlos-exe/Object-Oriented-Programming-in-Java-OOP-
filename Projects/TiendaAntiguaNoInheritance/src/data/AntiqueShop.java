package data;

import java.util.ArrayList;

import businessLogic.InventoryManager;

public class AntiqueShop {
	private InventoryManager inventory;
	
	public AntiqueShop(InventoryManager im) {
		this.inventory = im;
	}
	
	public void showAllVases() {
		ArrayList<Vase> vases = this.inventory.getVases();
		for(Vase v: vases) {
			System.out.println(v);
		}
	}
	
	public void showAllStatues() {
		ArrayList<Statue> statues = this.inventory.getStatues();
		for(Statue s: statues) {
			System.out.println(s);
		}
	}
	
	public void showAllPaintings() {
		ArrayList<Painting> paintings = this.inventory.getPaintings();
		for(Painting p: paintings) {
			System.out.println(p);
		}
	}
}
