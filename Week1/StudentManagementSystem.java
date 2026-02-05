import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String id;
    String name;
    int age;
    String course;

    // Constructor to initialize a student object
    Student(String id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Display method
    void display() {
        System.out.println("--------------------------------");
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Course : " + course);
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. search student by ID");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();// For read user choice
            sc.nextLine();

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
                    searchStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Exiting Program...");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // ADD
    static void addStudent() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
                sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, age, course));
        System.out.println("Student Added Successfully!");
    }

    // VIEW
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // UPDATE
    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        String id = sc.nextLine();

        for (Student s : students) {
            if (s.id.equals(id)) {

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course: ");
                s.course = sc.nextLine();

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // SEARCH BY ID
    static void searchStudent() {
        if (students.isEmpty()) {
            System.out.println("No Students Available.");
            return;
        }

        System.out.print("Enter ID to search: ");
        String id = sc.nextLine();

        boolean found = false;

        for (Student s : students) {
            if (s.id.equals(id)) {
                System.out.println("Student Found:");
                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }

    //DELETE
    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        String id = sc.nextLine();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id.equals(id)) {
                students.remove(i);
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }
}
