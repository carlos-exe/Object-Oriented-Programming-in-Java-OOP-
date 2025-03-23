package data;

public class Statue extends Item{
	private int weight;
	private String colour;
	
	public Statue(int value, String creator, int weight, String colour) {
		super(value,creator);
		this.weight = weight;
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Statue -- \\t" + super.toString() + ", weight=" + this.weight + ", color=" + this.colour;
	}
}
