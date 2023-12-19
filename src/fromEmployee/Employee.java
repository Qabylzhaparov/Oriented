package fromEmployee;

import java.util.Date;
import java.util.Vector;
import fromUser.Message;
import fromUser.User;
///heyy
/// hey I'm heres
/// lez go
public class Employee extends User {
	private Vector<Message> receiveMessages;         /// needs to get from DB(delete it)
    private double salary;
    private Date hireDate;
	///dkdkdkdk
    /// empty constr
    
    /// constr with just name
    
    public Employee(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email,
			String Password, int PhoneNumber, double salary, Date hireDate) {
		super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber);
			this.hireDate = new Date();
			this.salary = salary;
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

    
    public void SendMessage(Message message) {  
    	/// DB.addMessage(message);
    	/// syso sended
    }
    
    public void sentOrder(String order) {
    	/// DB.addOrder(order)
    }
    
}


Employee
1 send
enter content
urgency
open/close
Employee.SendMessage(new Message(content, open, high))
