package data;

public class Vase extends Item{
	private int height;
	private String material;
	
	public Vase(int value, String creator, int height, String material) {
		super(value,creator);
		this.height = height;
		this.material = material;
	}	
	
	@Override
	public String toString() {
		return "VASE -- \t" + super.toString() + "  Height:" + this.height +
				"  Material:" + this.material;
	}
}
