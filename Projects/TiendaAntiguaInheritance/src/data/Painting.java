package data;

public class Painting extends Item{
	private int height;
	private int width;
	private boolean isWaterColour;
	private boolean isFramed;
	
	public Painting(int value, String creator, int height, int width, boolean isWaterColour, boolean isFramed) {
		super(value, creator);
		this.height = height;
		this.width = width;
		this.isWaterColour = isWaterColour;
		this.isFramed = isFramed;
	}
	
	@Override
	public String toString() {
		String info1, info2;
		if(this.isWaterColour) {
			info1 = " it is WaterColour";
		} else {
			info1 = " it is not WaterColour";
		}
		if(this.isFramed) {
			info2 = " it is framed";
		} else {
			info2 = " it is not framed";
		}
		return "Painting --\t" + super.toString() + ", Height=" + this.height + ", width=" + this.width + info1 + info2;
	}
}
