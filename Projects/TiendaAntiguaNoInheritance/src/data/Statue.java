package data;

public class Statue {
	private int value;
	private String creator;
	private int weight;
	private String colour;
	
	public Statue(int value, String creator, int weight, String colour) {
		this.value = value;
		this.creator = creator;
		this.weight = weight;
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Statue [value=" + this.value + ", creator=" + this.creator + ", weight=" + this.weight + ", color=" + this.colour + "]";
	}
}
