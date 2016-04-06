// Timothy Dement
// CSC 340-01: Software Engineering
// Andrew Holman
// Employee.java

package POS;

public class Employee {
    
    private String employee_name;
    private String employee_position;
    private String employee_username;
    private String employee_password;
    
    public Employee() {
        this.employee_name = "";
        this.employee_position = "";
        this.employee_username = "";
        this.employee_password = "";
    }
    
    public Employee(String employee_name, String employee_position, String employee_username, String employee_password) {
        this.employee_name = employee_name;
        this.employee_position = employee_position;
        this.employee_username = employee_username;
        this.employee_password = employee_password;
    }
    
    public String get_employee_name() {
        return this.employee_name;
    }
    
    public String get_employee_position() {
        return this.employee_position;
    }
    
    public String get_employee_username() {
        return this.employee_username;
    }
    
    public String get_employee_password() {
        return this.employee_password;
    }
    
    public void set_employee_name(String employee_name) {
        this.employee_name = employee_name;
    }
    
    public void set_employee_position(String employee_position) {
        this.employee_position = employee_position;
    }
    
    public void set_employee_username(String employee_username) {
        this.employee_username = employee_username;
    }
    
    public void set_employee_password(String employee_password) {
        this.employee_password = employee_password;
    }
}