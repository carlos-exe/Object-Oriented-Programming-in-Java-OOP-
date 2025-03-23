package data;

public class Vase {
	private int value;
	private String creator;
	private int height;
	private String material;
	
	public Vase(int value, String creator, int height, String material) {
		this.value = value;
		this.creator = creator;
		this.height = height;
		this.material = material;
	}	
	
	@Override
	public String toString() {
		return "VASE -- \t" + "Value:" + this.value + "  Creator:" + this.creator + "  Height:" + this.height +
				"  Material:" + this.material;
	}
}
