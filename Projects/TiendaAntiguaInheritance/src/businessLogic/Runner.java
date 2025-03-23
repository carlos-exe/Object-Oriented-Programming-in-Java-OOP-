package businessLogic;

import data.AntiqueShop;
import ui.UserInterface;

public class Runner {
	public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager("items.txt");
        inventory.readingRecords();
        AntiqueShop store = new AntiqueShop(inventory);
        UserInterface ui = new UserInterface(store);
        ui.showMenu();
        ui.readOption();
	}
}
