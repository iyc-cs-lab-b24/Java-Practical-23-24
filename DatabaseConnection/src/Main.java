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

                // Executing a query to fetch data from the table
                ResultSet rs = stmt.executeQuery("SELECT * FROM teachers");

                // Printing the column names
                int columnCount = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rs.getMetaData().getColumnName(i);
                    System.out.print(padRight(columnName, 15)); // Adjust the width as needed
                }
                System.out.println();

                // Printing the data
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        String columnValue = rs.getString(i);
                        System.out.print(padRight(columnValue, 15)); // Adjust the width as needed
                    }
                    System.out.println();
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

    // Function to pad a string with spaces to the right to achieve a fixed width
    private static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
