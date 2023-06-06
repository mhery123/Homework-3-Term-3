import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComputeGradesGUIHomework3 extends JFrame {
    private JLabel milestone1Label, milestone2Label, terminalLabel;
    private JTextField milestone1Field, milestone2Field, terminalField;
    private JButton calculateButton;

    private final double MILESTONE1_MAX = 25.0;
    private final double MILESTONE2_MAX = 40.0;
    private final double TERMINAL_MAX = 35.0;

    public ComputeGradesGUIHomework3() {
        setTitle("Grade Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        milestone1Label = new JLabel("Milestone 1 (25%):");
        milestone1Field = new JTextField();
        milestone2Label = new JLabel("Milestone 2 (40%):");
        milestone2Field = new JTextField();
        terminalLabel = new JLabel("Terminal Assessment (35%):");
        terminalField = new JTextField();
        calculateButton = new JButton("Calculate");

        add(milestone1Label);
        add(milestone1Field);
        add(milestone2Label);
        add(milestone2Field);
        add(terminalLabel);
        add(terminalField);
        add(new JLabel()); // Empty label for spacing
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });
    }

    private void calculateGrade() {
        try {
            double milestone1 = Double.parseDouble(milestone1Field.getText());
            double milestone2 = Double.parseDouble(milestone2Field.getText());
            double terminal = Double.parseDouble(terminalField.getText());

            if (milestone1 < 0 || milestone1 > MILESTONE1_MAX || milestone2 < 0 || milestone2 > MILESTONE2_MAX || terminal < 0 || terminal > TERMINAL_MAX) {
                throw new IllegalArgumentException("Invalid input. Please enter values between 0 and the maximum points per milestone.");
            }

            double totalGrade = (milestone1 / MILESTONE1_MAX) * 25 + (milestone2 / MILESTONE2_MAX) * 40 + (terminal / TERMINAL_MAX) * 35;

            if (totalGrade < 0 || totalGrade > 100) {
                throw new IllegalArgumentException("Invalid calculation. Please check your inputs.");
            }

            JOptionPane.showMessageDialog(this, "Your grade is: " + totalGrade, "Grade", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ComputeGradesGUIHomework3().setVisible(true);
            }
        });
    }
}
