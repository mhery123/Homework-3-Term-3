import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class EmployeeLoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private Map<String, String> authorizedAccounts;

    public EmployeeLoginGUI() {
        setTitle("Employee Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initializeAuthorizedAccounts();

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Login");

        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        add(loginPanel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (validateLogin(username, password)) {
                    JOptionPane.showMessageDialog(EmployeeLoginGUI.this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    openEmployeeLeaveGUI();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(EmployeeLoginGUI.this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                    clearFields();
                }
            }
        });
    }

    private void initializeAuthorizedAccounts() {
        authorizedAccounts = new HashMap<>();
        authorizedAccounts.put("ceo", "password1");
        authorizedAccounts.put("manager", "password2");
        authorizedAccounts.put("teamleaderr", "password2");
    }

    private boolean validateLogin(String username, String password) {
        String authorizedPassword = authorizedAccounts.get(username);
        return authorizedPassword != null && authorizedPassword.equals(password);
    }

    private void openEmployeeLeaveGUI() {
        EmployeeLeaveGUI employeeLeaveGUI = new EmployeeLeaveGUI();
        employeeLeaveGUI.setVisible(true);
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeLoginGUI loginGUI = new EmployeeLoginGUI();
            loginGUI.setVisible(true);
        });
    }
}

class EmployeeLeaveGUI extends JFrame {
    // Rest of the code for EmployeeLeaveGUI class

    // ...
}
