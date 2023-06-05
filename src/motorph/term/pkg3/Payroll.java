import java.util.ArrayList;
import java.util.List;

public class Payroll {
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private double hourlyRate;

    public Payroll() {
        // Default constructor
    }

    public Payroll(String employeeNumber, String lastName, String firstName, double basicSalary, double riceSubsidy, double phoneAllowance, double clothingAllowance, double grossSemiMonthlyRate, double hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
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

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public void setRiceSubsidy(double riceSubsidy) {
        this.riceSubsidy = riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public void setPhoneAllowance(double phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }

    public void setClothingAllowance(double clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

    public double getGrossSemiMonthlyRate() {
        return grossSemiMonthlyRate;
    }

    public void setGrossSemiMonthlyRate(double grossSemiMonthlyRate) {
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public static void main(String[] args) {
        List<Payroll> payrollList = new ArrayList<>();

        payrollList.add(new Payroll("E001", "Crisostomo", "Jose", 62670,	1500,	1000,	1000,	31335,	373.04));
        payrollList.add(new Payroll("E002", "Mata", "Christian", 42975,	1500,	800,	800,	21488,	255.80));
        payrollList.add(new Payroll("E003", "San Jose", "Brad", 42975,	1500,	800,	800,	21488,	255.80));

        
    for (Payroll payroll : payrollList) {
        System.out.println("Employee Number: " + payroll.getEmployeeNumber());
        System.out.println("Last Name: " + payroll.getLastName());
        System.out.println("First Name: " + payroll.getFirstName());
        System.out.println("Basic Salary: " + payroll.getBasicSalary());
        System.out.println("Rice Subsidy: " + payroll.getRiceSubsidy());
        System.out.println("Phone Allowance: " + payroll.getPhoneAllowance());
        System.out.println("Clothing Allowance: " + payroll.getClothingAllowance());
        System.out.println("Gross Semi-Monthly Rate: " + payroll.getGrossSemiMonthlyRate());
        System.out.println("Hourly Rate: " + payroll.getHourlyRate());
    } 
    }
}

