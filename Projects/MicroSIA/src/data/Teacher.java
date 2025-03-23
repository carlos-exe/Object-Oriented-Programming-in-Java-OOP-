package data;

public class Teacher {
    private String name;
    private Course course;

    public Teacher(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }
}