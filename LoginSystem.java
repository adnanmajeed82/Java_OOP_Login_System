import java.util.HashMap;
import java.util.Map;

// LoginSystem class for managing student logins
public class LoginSystem {
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
