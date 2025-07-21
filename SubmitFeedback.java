import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SubmitFeedback {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = sc.nextLine();

        System.out.println("Enter feedback:");
        String feedback = sc.nextLine();

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO feedback (name, feedback) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, feedback);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Feedback submitted!");
            } else {
                System.out.println("Failed to submit feedback.");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
