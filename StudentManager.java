import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    static class Student {
        String name;
        int id;

        Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String toString() {
            return "ID: " + id + ", Name: " + name;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                students.add(new Student(name, id));
            } else if (choice == 2) {
                for (Student s : students) {
                     System.out.println(s);
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option!");
            }
          
        }
        scanner.close();
    }
}
