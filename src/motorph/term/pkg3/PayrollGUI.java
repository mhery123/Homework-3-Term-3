import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class PayrollGUI extends JFrame {
    private JList<String> payrollList;
    private DefaultListModel<String> payrollListModel;
    private JTextArea detailsTextArea;

    private List<Payroll> payrolls;

    public PayrollGUI() {
        setTitle("Payroll of Employee Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        payrollListModel = new DefaultListModel<>();
        payrollList = new JList<>(payrollListModel);
        JScrollPane payrollListScrollPane = new JScrollPane(payrollList);
        payrollList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        detailsTextArea = new JTextArea();
        detailsTextArea.setEditable(false);
        JScrollPane detailsScrollPane = new JScrollPane(detailsTextArea);

        add(payrollListScrollPane, BorderLayout.WEST);
        add(detailsScrollPane, BorderLayout.CENTER);

        payrolls = new ArrayList<>();
        payrolls.add(new Payroll("E001", "Crisostomo", "Jose", 62670, 1500, 1000, 1000, 31335, 373.04));
        payrolls.add(new Payroll("E002", "Mata", "Christian", 42975, 1500, 800, 800, 21488, 255.80));
        payrolls.add(new Payroll("E003", "San Jose", "Brad", 42975, 1500, 800, 800, 21488, 255.80));

        for (Payroll payroll : payrolls) {
            payrollListModel.addElement(payroll.getEmployeeNumber());
        }

        payrollList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = payrollList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Payroll selectedEmployee = payrolls.get(selectedIndex);
                    String details =  
                            "Employee Number: " + selectedEmployee.getEmployeeNumber() + "\n" +
                            "Last Name: " + selectedEmployee.getLastName() + "\n" +
                            "Basic Salary: " + selectedEmployee.getBasicSalary() + "\n" +
                            "Rice Subsidy: " + selectedEmployee.getRiceSubsidy() + "\n" +
                            "Phone Allowance: " + selectedEmployee.getPhoneAllowance() + "\n" +
                            "Clothing Allowance: " + selectedEmployee.getClothingAllowance() + "\n" +
                            "Gross Semi-Monthly Rate: " + selectedEmployee.getGrossSemiMonthlyRate() + "\n" +
                            "Hourly Rate: " + selectedEmployee.getHourlyRate() + "\n" ;
                    detailsTextArea.setText(details);
                }
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PayrollGUI payrollGUI = new PayrollGUI();
                payrollGUI.setVisible(true);
            }
        });
    }
    }


