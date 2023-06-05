import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class EmployeeLeaveGUI extends JFrame {
    private JList<String> employeeList;
    private DefaultListModel<String> employeeListModel;
    private JTextArea detailsTextArea;
    private JButton applyLeaveButton;

    private List<Employee> employees;

    public EmployeeLeaveGUI() {
        setTitle("Employee Leave Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        employeeListModel = new DefaultListModel<>();
        employeeList = new JList<>(employeeListModel);
        JScrollPane employeeListScrollPane = new JScrollPane(employeeList);
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        detailsTextArea = new JTextArea();
        detailsTextArea.setEditable(false);
        JScrollPane detailsScrollPane = new JScrollPane(detailsTextArea);

        applyLeaveButton = new JButton("Apply Leave");
        applyLeaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyLeave();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(applyLeaveButton);

        add(employeeListScrollPane, BorderLayout.WEST);
        add(detailsScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        employees = ListofEmployees();

        for (Employee employee : employees) {
            employeeListModel.addElement(employee.getEmployeeNumber());
        }

        employeeList.addListSelectionListener(e -> {
            int selectedIndex = employeeList.getSelectedIndex();
            if (selectedIndex >= 0) {
                Employee selectedEmployee = employees.get(selectedIndex);
                String details =
                        "Employee Number: " + selectedEmployee.getEmployeeNumber() + "\n" +
                                "Last Name: " + selectedEmployee.getLastName() + "\n" +
                                "First Name: " + selectedEmployee.getFirstName() + "\n" +
                                "Remaining Vacation Leaves: " + selectedEmployee.getRemainingVacationLeaves() + "\n" +
                                "Remaining Sick Leaves: " + selectedEmployee.getRemainingSickLeaves() + "\n" +
                                "Remaining Emergency Leaves: " + selectedEmployee.getRemainingEmergencyLeaves() + "\n";
                detailsTextArea.setText(details);
            }
        });
    }

    private void applyLeave() {
        int selectedIndex = employeeList.getSelectedIndex();
        if (selectedIndex >= 0) {
            Employee selectedEmployee = employees.get(selectedIndex);

            String startDate = JOptionPane.showInputDialog("Enter start date (MM/DD/YYYY):");
            String endDate = JOptionPane.showInputDialog("Enter end date (MM/DD/YYYY):");
            String leaveType = JOptionPane.showInputDialog("Enter leave type (Vacation/Sick/Emergency):");

            int leaveDays = calculateLeaveDays(startDate, endDate);

            if (leaveType.equalsIgnoreCase("Vacation")) {
                if (leaveDays <= selectedEmployee.getRemainingVacationLeaves()) {
                    selectedEmployee.useVacationLeaves(leaveDays);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient vacation leave days.", "Leave Application", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else if (leaveType.equalsIgnoreCase("Sick")) {
                if (leaveDays <= selectedEmployee.getRemainingSickLeaves()) {
                    selectedEmployee.useSickLeaves(leaveDays);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient sick leave days.", "Leave Application", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else if (leaveType.equalsIgnoreCase("Emergency")) {
                if (leaveDays <= selectedEmployee.getRemainingEmergencyLeaves()) {
                    selectedEmployee.useEmergencyLeaves(leaveDays);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient emergency leave days.", "Leave Application", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid leave type.", "Leave Application", JOptionPane.ERROR_MESSAGE);
                return;
            }

            updateEmployeeList();
            createCSVFile();
            clearLeaveFields();
            JOptionPane.showMessageDialog(this, "Leave application submitted successfully.", "Leave Application", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an employee.", "Leave Application", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateEmployeeList() {
        int selectedIndex = employeeList.getSelectedIndex();
        if (selectedIndex >= 0) {
            Employee selectedEmployee = employees.get(selectedIndex);
            employeeListModel.set(selectedIndex, selectedEmployee.getEmployeeNumber());
        }
    }

    private void clearLeaveFields() {
        employeeList.clearSelection();
        detailsTextArea.setText("");
    }



    private int calculateLeaveDays(String startDate, String endDate) {
    LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    long daysBetween = ChronoUnit.DAYS.between(start, end);
    return (int) daysBetween + 1; // Including the start and end dates
}


    private List<Employee> ListofEmployees() {
        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee("10001", "Crisostomo", "Jose", 10, 5, 5));
        employee.add(new Employee("10002", "Mata", "Christian", 10, 5, 5));
        employee.add(new Employee("10003", "San Jose", "Brad", 10, 5, 5));
        // Add more employees as needed
        return employee;
    }

    private void createCSVFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_leaves.csv"))) {
            // Write CSV header
            writer.write("EmployeeNumber,LastName,FirstName,VacationLeaves,SickLeaves,EmergencyLeaves");
            writer.newLine();

            // Write employee data
            for (Employee employee : employees) {
                writer.write(employee.getEmployeeNumber() + "," +
                        employee.getLastName() + "," +
                        employee.getFirstName() + "," +
                        employee.getRemainingVacationLeaves() + "," +
                        employee.getRemainingSickLeaves() + "," +
                        employee.getRemainingEmergencyLeaves());
                writer.newLine();
            }

            writer.flush();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeLeaveGUI gui = new EmployeeLeaveGUI();
            gui.setVisible(true);
        });
    }
}

class Employee {
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private int remainingVacationLeaves;
    private int remainingSickLeaves;
    private int remainingEmergencyLeaves;

    public Employee(String employeeNumber, String lastName, String firstName, int vacationLeaves, int sickLeaves, int emergencyLeaves) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.remainingVacationLeaves = vacationLeaves;
        this.remainingSickLeaves = sickLeaves;
        this.remainingEmergencyLeaves = emergencyLeaves;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getRemainingVacationLeaves() {
        return remainingVacationLeaves;
    }

    public int getRemainingSickLeaves() {
        return remainingSickLeaves;
    }

    public int getRemainingEmergencyLeaves() {
        return remainingEmergencyLeaves;
    }

    public void useVacationLeaves(int days) {
        remainingVacationLeaves -= days;
    }

    public void useSickLeaves(int days) {
        remainingSickLeaves -= days;
    }

    public void useEmergencyLeaves(int days) {
        remainingEmergencyLeaves -= days;
    }
}
