package data;

public class Item {
	protected int value;
	protected String creator;
	
	public Item(int value, String creator) {
		this.value = value;
		this.creator = creator;
	}
	
	@Override
	public String toString() {
		return "Value: " + this.value + "Creator: " + this.creator;
	}

}
