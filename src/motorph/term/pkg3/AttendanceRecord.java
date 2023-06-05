/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorph.term.pkg3;

/**
 *
 * @author admin
 */
public class AttendanceRecord {
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String date;
    private String timeIn;
    private String timeOut;

    // Constructor
    public AttendanceRecord(String employeeNumber, String lastName, String firstName, String date, String timeIn,
            String timeOut) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    // Getter and Setter methods
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public static void main(String[] args) {
        // Create an instance of AttendanceRecord
        AttendanceRecord record = new AttendanceRecord("12345", "Doe", "John", "2023-06-05", "09:00", "17:00");

        // Get and display the attributes
        System.out.println("Employee Number: " + record.getEmployeeNumber());
        System.out.println("Last Name: " + record.getLastName());
        System.out.println("First Name: " + record.getFirstName());
        System.out.println("Date: " + record.getDate());
        System.out.println("Time In: " + record.getTimeIn());
        System.out.println("Time Out: " + record.getTimeOut());

        // Update the attributes
        record.setTimeOut("18:00");
        System.out.println("Updated Time Out: " + record.getTimeOut());
    }
}

