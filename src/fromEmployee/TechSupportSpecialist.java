package fromEmployee;

import java.util.Date;
import java.util.List;

public class TechSupportSpecialist extends Employee {
	private List<Employee> Orders;                          /// hranit' v DB
	
	/// empty cons
	
	/// cons with just name
	
	public TechSupportSpecialist(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email,
			String Password, int PhoneNumber, double salary, Date hireDate) {
		super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber, salary, hireDate);
		// TODO Auto-generated constructor stub
	}
	

    public List<Employee> getOrders() {                     
        return this.Orders;                                 /// DB.getOrders()
    }
                                                            /// deleted setOrders(he cant set orders)
    public decide(String order, String decision) {
    	Send(order + decision)
    }
    
    private void sendOrder() {
    	super.sentOrder("djklsjs");
    }
}
