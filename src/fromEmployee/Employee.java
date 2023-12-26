package fromEmployee;

import java.util.Date;
import java.util.Vector;
import fromUser.Message;
import fromUser.User;
import fromUser.UserType;

public abstract class Employee extends User {
    private double salary;
    private Date hireDate;
	
    public Employee() {
    	
    }
    
    public Employee(String name) {
    	super(name);
    }
    

    public Employee(String email, String password, UserType userType) {
		super(email, password, userType);
		// TODO Auto-generated constructor stub
	}


	public Employee(UserType userType, String ID, String firstName, String lastName, String email, String password,
			int phoneNumber) {
		super(userType, ID, firstName, lastName, email, password, phoneNumber);
		// TODO Auto-generated constructor stub
	}


	public Double getSalary() {
        return this.salary;
    }
    public void setSalary(Double Salary) {
        this.salary = Salary;
    }
    public Date getHireDate() {
        return this.hireDate;
    }
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    
    public abstract void sendMessage();
    
    public abstract void sendOrder();
}

//
//Employee
//1 send
//enter content
//urgency
//open/close
//Employee.SendMessage(new Message(content, open, high))
