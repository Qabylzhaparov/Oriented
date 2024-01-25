package fromEmployee;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fromUser.Database;
import fromUser.User;
import fromUser.UserType;
/**
 * The class representing a Technical Support Specialist in the system.
 * Extends the Employee class.
 */
public class TechSupportSpecialist extends Employee {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3963695342035015844L;
	/**
	 * 
	 */
//	private static final long serialVersionUID = -6176455409045254173L; old
//	                         
    private transient Scanner in;
    public TechSupportSpecialist() {
		super();
		// TODO Auto-generated constructor stub
	}
    /**
     * Constructor for creating a TechSupportSpecialist during login.
     *
     * @param email     The email of the technical support specialist.
     * @param password  The password of the technical support specialist.
     * @param userType  The type of user (TECHSUPPORTSPECIALIST).
     */
	public TechSupportSpecialist(String email, String password, UserType userType) {
		super(email, password, userType);
		// TODO Auto-generated constructor stub
	}
	/**
     * Constructor for creating a TechSupportSpecialist with detailed information.
     *
     * @param userType     The type of user (TECHSUPPORTSPECIALIST).
     * @param ID           The unique identifier for the technical support specialist.
     * @param firstName    The first name of the technical support specialist.
     * @param lastName     The last name of the technical support specialist.
     * @param email        The email of the technical support specialist.
     * @param password     The password of the technical support specialist.
     * @param phoneNumber  The phone number of the technical support specialist.
     */
	public TechSupportSpecialist(UserType userType, String ID, String firstName, String lastName, String email,
			String password, int phoneNumber) {
		super(userType, ID, firstName, lastName, email, password, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	 /**
     * Initializes the Scanner for input.
     */
    private void initScanner() {
        this.in = new Scanner(System.in);
    }
    /**
     * Saves the data to the database.
     *
     * @throws IOException If an I/O error occurs.
     */
	private void save() throws IOException {
		Database.write();
	}
	/**
     * Exits the system.
     */
	private void exit() {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
     * Displays the order list for the technical support specialist.
     */
    public void orderList() {
        List<TechSupportSpecialist> orderList = Database.INSTANCE.getOrders();

        if (orderList.isEmpty()) {
            System.out.println("There are no orders. You can rest for now");
        } else {
            System.out.println("Order List:");
            for (TechSupportSpecialist order : orderList) {
                System.out.println("Orders:" + order);
            }
        }
    }
    	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		
	}    
    	/**
         * Displays the menu for the technical support specialist.
         */
    public void displayMenu() {
		System.out.println("--------TechSupportSpecialist menu----------------");
		System.out.println("====================================");
		System.out.println("*	1) Show orders             *");
		System.out.println("*	2) Send message            *");
		System.out.println("*	3) Return back             *");
		System.out.println("*	4) Exit    	               *");
		System.out.println("====================================");
    }
    /**
     * Runs the technical support specialist menu.
     *
     * @throws IOException If an I/O error occurs.
     */
	public void run() throws IOException {
		try {
			initScanner();
			menu : while(true){
				displayMenu();
				int choice = in.nextInt();
				if(choice==1){
					orderList: while(true){
						orderList();
						Database.write();
						System.out.println("\n 1) Show orders \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue orderList;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if(choice==2){
					sendMessage: while(true){
						sendMessage();
						Database.write();
						System.out.println("\n 1) Send message \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue sendMessage;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				
				else if (choice==4){
						exit();
						break menu;
					}
				}
			} catch (Exception e) {
				System.out.println("Something bad happened... \n Saving resources...");
				e.printStackTrace();
				save();
			}
		finally {
			if(in != null) in.close();
	        // Close the Scanner
	      
	    }
	}

	@Override
	public void sendOrder() {
		// TODO Auto-generated method stub
		
	}
}

