import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }

    public void updateProfile(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
        System.out.println("Profile updated successfully!");
    }
}

class MCQK {
    private String question;
    private String[] options;

    public MCQK(String question, String[] options) {
        this.question = question;
        this.options = options;
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public void selectAnswer(int answerIndex) {
        System.out.println("Selected answer: " + options[answerIndex - 1]);
    }
}

public class OnlineExamination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = new User("exampleUser", "password123");

        if (user.authenticate(password)) {
            System.out.println("Login successful!");

            // Update Profile and Password
            System.out.print("Enter new username: ");
            String newUsername = scanner.nextLine();
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();

            user.updateProfile(newUsername, newPassword);

            // Selecting answers for MCQK
            String question = "What is the capital of France?";
            String[] options = {"Berlin", "Paris", "London", "Rome"};
            MCQK mcqk = new MCQK(question, options);

            mcqk.displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int answerIndex = scanner.nextInt();
            mcqk.selectAnswer(answerIndex);

            // Timor and auto submit
            System.out.println("Time's up! Auto-submitting...");

            // Closing session and tag out
            System.out.println("Closing session and tagging out.");

        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }

        scanner.close();
    }
}