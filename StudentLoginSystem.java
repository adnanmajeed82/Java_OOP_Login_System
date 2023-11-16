import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Student class representing a student with a username and password
class Student {
    private String username;
    private String password;

    // Constructor to initialize the student's credentials
    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter method for the username
    public String getUsername() {
        return username;
    }

    // Method to check if the provided password matches the stored password
    public boolean isValidPassword(String inputPassword) {
        return password.equals(inputPassword);
    }
}

// LoginSystem class for managing student logins
class LoginSystem {
    private Map<String, Student> studentDatabase;

    // Constructor to initialize the student database
    public LoginSystem() {
        this.studentDatabase = new HashMap<>();
    }

    // Method to add a new student to the database
    public void addStudent(Student student) {
        studentDatabase.put(student.getUsername(), student);
    }

    // Method to authenticate a student based on username and password
    public boolean authenticateStudent(String username, String password) {
        Student student = studentDatabase.get(username);
        return student != null && student.isValidPassword(password);
    }
}

// Main class for testing the student login system
public class StudentLoginSystem {
    public static void main(String[] args) {
        // Creating instances of students
        Student student1 = new Student("danish", "123");
        Student student2 = new Student("adnan", "securePass");
        Student student3 = new Student("iftikhar", "manawala");
        Student student4 = new Student("shaheen", "abcd");

        // Creating an instance of the login systems
        LoginSystem loginSystem = new LoginSystem();

        // Adding students to the login system
        loginSystem.addStudent(student1);
        loginSystem.addStudent(student2);
        loginSystem.addStudent(student3);
        loginSystem.addStudent(student4);

        // Simulating user input for login
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        // Authenticating the student
        if (loginSystem.authenticateStudent(enteredUsername, enteredPassword)) {
            System.out.println("Login successful! Welcome, " + enteredUsername + ".");
        } else {
            System.out.println("Invalid username or password. Login failed.");
        }

        scanner.close();
    }
}
