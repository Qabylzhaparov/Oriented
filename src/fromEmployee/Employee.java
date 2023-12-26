package fromEmployee;

import java.util.Date;
import java.util.Vector;
import fromUser.Message;
import fromUser.User;
import fromUser.UserType;

/**
 * The abstract class representing an Employee in the system.
 * Extends the User class.
 */
public abstract class Employee extends User {
    private double salary;
    private Date hireDate;
	
    public Employee() {
    	
    }
    
    public Employee(String name) {
    	super(name);
    }
    
    /**
     * Constructor for creating an Employee during login.
     * But Employee is an abstract, so we will create for child classes
     * @param email     The email of the employee.
     * @param password  The password of the employee.
     * @param userType  The type of user (EMPLOYEE).
     */
    public Employee(String email, String password, UserType userType) {
		super(email, password, userType);
		// TODO Auto-generated constructor stub
	}

    /**
     * Constructor for creating an Employee with detailed information.
     *
     * @param userType     The type of user (EMPLOYEE).
     * @param ID           The unique identifier for the employee.
     * @param firstName    The first name of the employee.
     * @param lastName     The last name of the employee.
     * @param email        The email of the employee.
     * @param password     The password of the employee.
     * @param phoneNumber  The phone number of the employee.
     */
	public Employee(UserType userType, String ID, String firstName, String lastName, String email, String password,
			int phoneNumber) {
		super(userType, ID, firstName, lastName, email, password, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	 /**
     * Gets the salary of the employee.
     *
     * @return The salary of the employee.
     */
	public Double getSalary() {
        return this.salary;
    }
	 /**
     * Sets the salary of the employee.
     *
     * @param salary The salary to set.
     */
    public void setSalary(Double Salary) {
        this.salary = Salary;
    }
    /**
     * Gets the hire date of the employee.
     *
     * @return The hire date of the employee.
     */
    public Date getHireDate() {
        return this.hireDate;
    }
    /**
     * Sets the hire date of the employee.
     *
     * @param hireDate The hire date to set.
     */
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * Abstract method for an employee to send a message.
     */
    public abstract void sendMessage();
    /**
     * Abstract method for an employee to send an order.
     */
    public abstract void sendOrder();
}

