import java.util.ArrayList;
import java.util.Scanner;

// Student class to represent student details
class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Display student details
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

// Main class for the student management system
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add a new student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        students.add(new Student(id, name, age, grade));
        System.out.println("Student added successfully!");
    }

    // View all students
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n=== Student List ===");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Update an existing student
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter New Name (leave blank to keep unchanged): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    student.setName(name);
                }

                System.out.print("Enter New Age (0 to keep unchanged): ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (age != 0) {
                    student.setAge(age);
                }

                System.out.print("Enter New Grade (leave blank to keep unchanged): ");
                String grade = scanner.nextLine();
                if (!grade.isEmpty()) {
                    student.setGrade(grade);
                }

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Delete a student
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}
