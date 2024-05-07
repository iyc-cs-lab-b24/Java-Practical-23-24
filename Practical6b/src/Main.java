import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            // Establishing the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher", "root", "root");
            if (con != null) {
                System.out.println("Connected to the database!");

                // Creating a statement
                Statement stmt = con.createStatement();

                // Print values before update
                System.out.println("Values before update:");
                displayRecord(stmt, "Modi Ji");

                // Update the record
                int rowsAffected = stmt.executeUpdate("UPDATE teachers SET age = 50, email = 'modiji@pm.in' WHERE name = 'Modi Ji'");

                if (rowsAffected > 0) {
                    System.out.println("Record updated successfully!");
                } else {
                    System.out.println("Failed to update record!");
                }

                // Print values after update
                System.out.println("Values after update:");
                displayRecord(stmt, "Modi Ji");

                // Closing the resources
                stmt.close();
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
        }
    }

    // Function to display the record for a given name
    private static void displayRecord(Statement stmt, String name) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM teachers WHERE name = '" + name + "'");
        if (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Email: " + rs.getString("email"));
        } else {
            System.out.println("Record with name '" + name + "' not found!");
        }
        rs.close();
    }
}
