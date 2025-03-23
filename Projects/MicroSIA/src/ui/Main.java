package ui;
import data.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Course course = new Course("Object-Oriented Programming");
        Teacher teacher = new Teacher("Carlos", course);

        System.out.println("Welcome, Professor " + teacher.getName() + "!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese el número de notas: ");
        int gradeQuantity = scanner.nextInt();
        course.updateGradesQuantity(gradeQuantity);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar Estudiantes");
            System.out.println("2. Añadir Notas");
            System.out.println("3. Cambiar Notas");
            System.out.println("4. Mostrar Notas ");
            System.out.println("5. Calcular Nota Final");
            System.out.println("6. Mostrar Notas Finales");
            System.out.println("7. Crear Lista Inicial con el archivo");
            System.out.println("8. Mostrar Lista de Estudiantes");
            System.out.println("9. Actualizar el número de notas");
            System.out.println("10. Salir");
            System.out.print("Por favor, escoja una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el número de estudiantes: ");
                    int quantity = scanner.nextInt();
                    course.addStudents(quantity);
                    System.out.println("Estudiantes registrados de forma satisfactoria.");
                    break;
                case 2:
                    System.out.print("¿Para todos los estudiantes? [Y/n]: ");
                    String ans = scanner.next();
                    if (ans.toLowerCase().equals("n")) {
                        System.out.print("Ingrese el número de estudiantes: ");
                        int quantity1 = scanner.nextInt();
                        for (int i = 0; i < quantity1; i++) {
                            System.out.print("Ingrese el nombre completo del estudiante: ");
                            String name = scanner.next();
                            Student stu = course.findStudentByName(name);
                            if (stu != null) {
                                if (stu.confirmGradesQuantity(course)) {
                                    System.out.print("Ingrese la descripcion de la nota: ");
                                    String description = scanner.next();
                                    System.out.print("Ingrese el porcentaje de la nota: ");
                                    float percentage = scanner.nextFloat();
                                    System.out.print("Ingrese la nota: ");
                                    float gradeScanned = scanner.nextFloat();
                                    Grade grade = new Grade(description, gradeScanned, percentage);
                                    stu.addGrade(grade);
                                } else {
                                    System.out.println("El estudiante " + stu.getName() + " ya tiene " + course.getGradesQuantity() + " notas.");
                                }
                            } else {
                                System.out.println("Estudiante no encontrado");
                            }
                        }
                        break;
                    } else if (ans.toLowerCase().equals("y")) {
                        List<Student> students = course.getStudents();
                        for (Student student : students) {
                            if (student.confirmGradesQuantity(course)) {
                                System.out.print("Ingrese la descripcion de la nota para " + student.getName() + ": ");
                                String description = scanner.next();
                                System.out.print("Ingrese el porcentaje de la nota: ");
                                float percentage = scanner.nextFloat();
                                System.out.print("Ingrese la nota: ");
                                float gradeScanned = scanner.nextFloat();
                                Grade grade = new Grade(description, gradeScanned, percentage);
                                student.addGrade(grade);
                            } else {
                                System.out.println("El estudiante " + student.getName() + " ya tiene " + course.getGradesQuantity() + " notas.");
                            }
                        }
                        break;
                    } else {
                        System.out.println("Opción Inválida!");
                        break;
                    }
                case 3:
                    System.out.print("Enter student name: ");
                    String studentNameToUpdate = scanner.nextLine();
                    Student studentToUpdate = course.findStudentByName(studentNameToUpdate);
                    if (studentToUpdate == null) {
                        System.out.println("Student not found.");
                    } else {
                    	List<String> descriptions = studentToUpdate.getDescriptions();
                    	System.out.println("The posible descriptions are: " + descriptions);
                        System.out.print("Enter grade description to update: ");
                        String descriptionToUpdate = scanner.nextLine();
            			System.out.print("Ingrese el porcentaje de la nota: ");//
            			float percentage = scanner.nextFloat();//
                        System.out.print("Enter new grade value: ");
                        double newGradeValue = scanner.nextDouble();
                        boolean updated = studentToUpdate.updateGrade(descriptionToUpdate, newGradeValue, percentage);//
                        if (updated) {
                            System.out.println("Grade updated successfully.");
                        } else {
                            System.out.println("Grade description error.");
                        }
                    }
                    break;

                case 4:
                    System.out.print("¿Mostrar las notas para todos los estudiantes? [Y/n]: ");
                    String ans1 = scanner.next();
                    scanner.nextLine();

                    System.out.println("\n" + course.getCourseName() + " - " + teacher.getName());
                    System.out.println("=".repeat(50));

                    if (ans1.equalsIgnoreCase("y")) {

                        List<Student> students = course.getStudents();
                        System.out.printf("%-20s %-20s %-10s%n", "Nombre Estudiante", "Descripcion", "Nota");
                        System.out.println("-".repeat(50));

                        for (Student student : students) {
                            for (Grade grade : student.getGrades()) {
                                System.out.printf("%-20s %-20s %-10.2f%n",
                                        student.getName(),
                                        grade.getDescription(),
                                        grade.getValue());
                            }
                        }
                    } else if (ans1.equalsIgnoreCase("n")) {

                        System.out.print("Ingresar el número de estudiantes: ");
                        int numStudents = scanner.nextInt();
                        scanner.nextLine();

                        System.out.printf("%-20s %-20s %-10s%n", "Nombre de Estudiantes", "Descripciones", "Notas");
                        System.out.println("-".repeat(50));

                        for (int i = 0; i < numStudents; i++) {
                            System.out.print("Ingrese el nombre completo del estudiante: ");
                            String name = scanner.nextLine();
                            Student student = course.findStudentByName(name);

                            if (student != null) {
                                for (Grade grade : student.getGrades()) {
                                    System.out.printf("%-20s %-20s %-10.2f%n",
                                            student.getName(),
                                            grade.getDescription(),
                                            grade.getValue());
                                }
                            } else {
                                System.out.println("Estudiante no encontrado: " + name);
                            }
                        }
                    } else {
                        System.out.println("Opción Inválida!");
                    }
                    System.out.println("=".repeat(50));
                    break;

                case 5:
                    System.out.print("¿Calcular las notas finales para todos los estudiantes? [Y/n]: ");
                    String ans3 = scanner.next();

                    if (ans3.equalsIgnoreCase("y")) {
                        List<Student> students = course.getStudents();
                        System.out.println(course.getCourseName() + " - " + teacher.getName());
                        for (Student student : students) {
                            System.out.println(student.getName() + ": Notal Final = " + student.getFinalGrade());
                        }
                    } else if (ans3.equalsIgnoreCase("n")) {
                        System.out.print("Ingrese el número de estudiantes: ");
                        int numStudents = scanner.nextInt();
                        scanner.nextLine();

                        for (int i = 0; i < numStudents; i++) {
                            System.out.print("Ingrese el nombre complete del estudiante: ");
                            String name = scanner.nextLine();
                            Student student = course.findStudentByName(name);

                            if (student != null) {
                                System.out.println(student.getName() + ": Nota Final = " + student.getFinalGrade());
                            } else {
                                System.out.println("Estudiante no encontrado: " + name);
                            }
                        }
                    } else {
                        System.out.println("Opción Inválida!");
                    }
                    break;

                case 6:
                    System.out.println("Notas finales de todos los estudiantes:");
                    List<Student> studentsWithFinalGrades = course.getStudents();
                    for (Student student : studentsWithFinalGrades) {
                        System.out.println(student.getName() + ": Nota Final = " + student.getFinalGrade());
                    }
                    break;

                case 7:
                	System.out.print("Ingrese el nombre del archivo: ");
                	String filename = scanner.next();
                	course.createInitialList(filename);
                	break;


                case 8:
                    System.out.println("Lista de estudiantes registrados:");
                    List<Student> registeredStudents = course.getStudents();
                    if (registeredStudents.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        for (Student student : registeredStudents) {
                            System.out.println("- " + student.getName());
                        }
                    }
                    break;

                case 9:
                    System.out.print("Ingrese el nuevo número de notas: ");
                    int newGradeQuantity = scanner.nextInt();
                    course.updateGradesQuantity(newGradeQuantity);
                    System.out.println("El número de notas se ha actualizado a " + newGradeQuantity + ".");
                    break;

                case 10:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}

