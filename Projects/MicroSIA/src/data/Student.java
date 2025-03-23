package data;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name; 
    private List<Grade> grades;
    
    

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
        
    }

    
    public boolean updateGrade(String description, double newValue, float percentage) {
        for (Grade grade : grades) {
            if (grade.getDescription().equalsIgnoreCase(description)) {
                grades.remove(grade);
                grades.add(new Grade(description, newValue, percentage));
                return true;
                }
    	}
        return false;
    }
    public String getName() {
        return name;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }

    public double getFinalGrade() {
        double finalGrade = 0;
        double totalPercentage = 0;

        for (Grade grade : grades) {
            finalGrade += (grade.getValue() * grade.getPercentage()) / 100;
            totalPercentage += grade.getPercentage();
        }

        if (totalPercentage != 100) {
            System.out.println("Warning: Total percentage does not equal 100%");
        }

        return finalGrade;
    }

    
    public List<String> getDescriptions() {
    	List<String> descriptions = new ArrayList<>();
    	for (Grade grade: grades) {
    		String description = grade.getDescription();
    		descriptions.add(description);
    	}
    	return descriptions; //Entrega lista con las descripciones de las notas
    }
    
    public boolean confirmGradesQuantity(Course course) {
    	return grades.size() <= course.getGradesQuantity();
    }
    
    
  
    
    public List<Double> showGradesValues(){
    	List<Double> totalGrades = new ArrayList<>();
    	for(Grade grade: grades) {
    		totalGrades.add(grade.getValue());
    	}
    	return totalGrades;
    }

}