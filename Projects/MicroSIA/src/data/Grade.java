
package data;

public class Grade {
    private String description;
    private double value;
    private float percentage;//

    public Grade(String description, double value, float percentage) {
        this.description = description;
        this.percentage = percentage;
        this.value = value;
    }
    
    public float getPercentage() {
    	return percentage;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }
    
    public void setValue(double value) {
        this.value = value;
    }
}