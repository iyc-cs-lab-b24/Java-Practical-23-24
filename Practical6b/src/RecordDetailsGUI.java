import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RecordDetailsGUI extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField emailField;
    private JButton submitButton;

    public RecordDetailsGUI() {
        setTitle("Record Details");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        panel.add(new JLabel(" Name:"), gbc);
        gbc.gridy++;
        nameField = new JTextField(20);
        panel.add(nameField, gbc);

        gbc.gridy++;
        panel.add(new JLabel(" Age:"), gbc);
        gbc.gridy++;
        ageField = new JTextField(20);
        panel.add(ageField, gbc);

        gbc.gridy++;
        panel.add(new JLabel(" Email:"), gbc);
        gbc.gridy++;
        emailField = new JTextField(20);
        panel.add(emailField, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        panel.add(submitButton, gbc);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RecordDetailsGUI gui = new RecordDetailsGUI();
            gui.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String email = emailField.getText();

            try {
                // Establishing the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher", "root", "root");
                if (con != null) {
                    System.out.println("Connected to the database!");

                    // Creating a statement
                    Statement stmt = con.createStatement();

                    // Executing an INSERT query to insert a new record
                    int rowsAffected = stmt.executeUpdate("INSERT INTO teachers (name, age, email) VALUES ('" + name + "', " + age + ", '" + email + "')");

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Record inserted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to insert record!");
                    }

                    // Closing the resources
                    stmt.close();
                    con.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Connection failed! Check output console");
                ex.printStackTrace();
            }
        }
    }
}
