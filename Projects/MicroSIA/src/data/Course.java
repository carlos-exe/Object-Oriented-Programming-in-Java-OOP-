package data;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName; //String course name
    private List<Student> students; // List of students
    private int gradesQuantity;


// Create constructor    
    
    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    
// Creating methods
    

    
    public void updateGradesQuantity(int quantity) {
    	gradesQuantity = quantity;
    }
    
    public int getGradesQuantity() {
    	return gradesQuantity;
    }

    public void createInitialList(String filename) {
    	try (InputStream inputStream = Course.class.getResourceAsStream("/"+filename);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
    		
	    String line;
	    while ((line = reader.readLine()) != null) {
	        students.add(new Student(line));
	    	}
		} catch (IOException e) {
		    System.err.println("Error reading " + filename + " " + e.getMessage());
		} 	
    }
    
    public void showOnlyList() {
        if (!students.isEmpty()) {
            students.forEach(student -> System.out.println(student.getName()));
        } else {
            System.out.println("List is empty");
        }
    }

    
    public String getCourseName() {
        return courseName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(int quantity) {
    	Scanner scanner = new Scanner(System.in);
    	for(int i = 0; i<quantity; i++) {
    		System.out.print("Enter student name: ");
            String name = scanner.nextLine(); // Save student name in the variable "name"
            Student student = new Student(name); //Create a new object of Student class
            this.students.add(student); // Add Student object to students list in Course class
    	}
    }
    
    public Student findStudentByName(String name) {
        return students.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    } // Finding a student by its name using lamda function 
}