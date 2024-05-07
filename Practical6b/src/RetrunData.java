import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RetrunData {
    public static void main(String[] args) {
        try {
            // Establishing the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher", "root", "root");
            if (con != null) {
                System.out.println("Connected to the database!");


                // Creating a statement
                Statement stmt = con.createStatement();


                // Specify the record ID you want to retrieve
                int recordId = 1;


                // Executing a query to fetch data for the specified record
                ResultSet rs = stmt.executeQuery("SELECT * FROM teachers WHERE id = " + recordId);


                // Printing the data
                if (rs.next()) {
                    System.out.println("Record found:");
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Age: " + rs.getInt("age"));
                    System.out.println("Email: " + rs.getString("email"));
                } else {
                    System.out.println("Record with ID " + recordId + " not found!");
                }


                // Closing the resources
                rs.close();
                stmt.close();
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
        }
    }
}
