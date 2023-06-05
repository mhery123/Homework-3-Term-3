/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorph.term.pkg3;


import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author admin
 */
public class Employee {
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String birthday;
    private String address;
    private String phoneNumber;
    private String sssNumber;
    private String philhealthNumber;
    private String tinNumber;
    private String pagibigNumber;
    private String status;
    private String position;
    private String immediateSupervisor;
   

    // Constructor
    public Employee(String employeeNumber, String lastName, String firstName, String birthday, String address, String phoneNumber, String sssNumber, String philhealthNumber, String tinNumber, String pagibigNumber, String status, String position, String immediateSupervisor) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagibigNumber = pagibigNumber;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        // Create an instance of Employee
        

        Employee employee1 = new Employee("10001", "Crisostomo", "Jose", "02/14/1988", "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands", "918-621-603",	"49-1632020-8",	"382189453145",	"317-674-022-000", "441093369646", "Regular", "HR Manager", "N/A");
        Employee employee2 = new Employee("10002", "Mata", "Christian",	"10/21/1987", "90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu", "783-776-744", "49-2959312-6",	"824187961962", "103-100-522-000", "631052853464", "Regular",  " Account Team Leader", "Romualdez Fredrick");
        Employee employee3 = new Employee("10003", "San Jose",	"Brad", "03/15/1996",	"99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi",	"797-009-261",	"40-2400714-1",	"239192926939",	"672-474-690-000", "210850209964", "Regular", "HR Team Leader", "Crisostomo, Jose");
        
        
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        
        // Access and display the attributes
        for (Employee employee : employeeList) {
        System.out.println("Employee Number: " + employee.getEmployeeNumber());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("First Name: " + employee.getFirstName());
        System.out.println("Birthday: " + employee.getBirthday());
        System.out.println("Address: " + employee.getAddress());
        System.out.println("Phone Number: " + employee.getPhoneNumber());
        System.out.println("SSS Number: " + employee.getSssNumber());
        System.out.println("Philhealth Number: " + employee.getPhilhealthNumber());
        System.out.println("TIN Number: " + employee.getTinNumber());
        System.out.println("Pag-ibig Number: " + employee.getPagibigNumber());
        System.out.println("Status: " + employee.getStatus());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Immediate Supervisor: " + employee.getImmediateSupervisor());
        }
    }
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    public String getPhilhealthNumber() {
        return philhealthNumber;
    }

    public void setPhilhealthNumber(String philhealthNumber) {
        this.philhealthNumber = philhealthNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getPagibigNumber() {
        return pagibigNumber;
    }

    public void setPagibigNumber(String pagibigNumber) {
        this.pagibigNumber = pagibigNumber;
        
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImmediateSupervisor() {
        return immediateSupervisor;
    }

    public void setImmediateSupervisor(String immediateSupervisor) {
        this.immediateSupervisor = immediateSupervisor;
    }

   
}