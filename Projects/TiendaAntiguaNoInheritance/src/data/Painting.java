package data;

public class Painting {
	private float value;
	private String creator;
	private int height;
	private int width;
	private boolean isWaterColour;
	private boolean isFramed;
	
	public Painting(float value, String creator, int height, int width, boolean isWaterColour, boolean isFramed) {
		this.value = value;
		this.creator = creator;
		this.height = height;
		this.width = width;
		this.isWaterColour = isWaterColour;
		this.isFramed = isFramed;
	}
	
	@Override
	public String toString() {
		return "Painting [value=" + this.value + ", creator=" + this.creator + ", height=" + this.height + ", width=" + this.width + ", Water Colour=" + this.isWaterColour + ", Framed=" + this.isFramed + "]";
	}
}
