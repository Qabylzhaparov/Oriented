package fromUser;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import fromEmployee.TechSupportSpecialist;
import manager.Manager;
import research.Researcher;
import student.Student;
import teacher.Teacher;

/**
 * this class controls the system. Adds, removes and updates users
 * */
public class Admin extends User {
/**
	 * 
	 */
	private static final long serialVersionUID = -6314193802692272885L;
	//	private static final long serialVersionUID = -5092781539768232544L; old
    private transient Scanner in;
    /**
     * Constructor for the Admin class.
     *
     * @param userType     The type of user (ADMIN).
     * @param ID           The unique identifier for the user.
     * @param firstName    The first name of the user.
     * @param lastName     The last name of the user.
     * @param email        The email of the user.
     * @param password     The password of the user.
     * @param phoneNumber  The phone number of the user.
     */
    public Admin(UserType userType, String ID, String firstName, String lastName, String email, String password,
                 int phoneNumber) {
        super(userType, ID, firstName, lastName, email, password, phoneNumber);
    }

    public Admin() {
    }
    /**
     * Constructor for creating an Admin in login.
     *
     * @param email     The email of the user.
     * @param password  The password of the user.
     * @param userType  The type of user (ADMIN).
     */
    public Admin(String email, String password, UserType userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
    /**
     * Initializes the scanner for user input.
     */
    private void initScanner() {
        this.in = new Scanner(System.in);
    }
    /**
     * Saves the changes made by the Admin to the database.
     *
     * @throws IOException 
     */
	private void save() throws IOException {
		Database.write();
	}
	 /**
     * Exits the system and also saves the changes.
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
     * Adds a new user to the system.
     */
    public void addUser() {
        System.out.println("Enter new user's email: ");
        String email = in.next();

        // Check if the user already exists
        List<User> userList = Database.INSTANCE.getUserList();
        Optional<User> userOptional = userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
        if (!userOptional.isPresent()) {
            System.out.println("Enter new user's password: ");
            String password = in.next();

            System.out.println("Enter new user's UserType (STUDENT, TEACHER, MANAGER, TECHSUPPORTSPECIALIST, ADMIN, RESEARCHER): ");
            UserType userType = UserType.valueOf(in.next().toUpperCase());
            User newUser;
            switch (userType) {
                case ADMIN:
                    newUser = new Admin(email, password, userType);

                    break;
                case RESEARCHER:
                	newUser = new Researcher(email, password, userType);
                    break;
                case STUDENT:
                    newUser = new Student(email, password, userType);
                    break;
                case TECHSUPPORTSPECIALIST:
                	newUser = new TechSupportSpecialist(email, password, userType);
                	break;
                case TEACHER:
                	newUser = new Teacher(email, password, userType);
                	break;
                case MANAGER:
                	newUser = new Manager(email, password, userType);
                	break;
                // Add cases for other user types as needed
                default:
                    System.out.println("Unsupported user type.");
                    return;
            }

            // Add the new user to the database
            Database.INSTANCE.getUserList().add(newUser);
            Database.write();
            System.out.println("New user added successfully!");
        } else {
            System.out.println("User already exists.");
        }
    }

    /**
     * Removes a user from the system.
     */
    public void removeUser() {
        System.out.println("Enter user's email you want to delete: ");
        String emailToRemove = in.next();

        List<User> userList = Database.INSTANCE.getUserList();

        Optional<User> userOptional = userList.stream()
                .filter(user -> user.getEmail().equals(emailToRemove))
                .findFirst();
        if (userOptional.isPresent()) {
            User userToRemove = userOptional.get();
            userList.remove(userToRemove);
			Database.write();
            System.out.println("User removed successfully!");
        } else {
            System.out.println("User not found.");
        }
    }

    /**
     * Updates the information of an existing user.
     */
    public void updateUser() {
        System.out.println("Enter user's email you want to update: ");
        String emailToUpdate = in.next();

        List<User> userList = Database.INSTANCE.getUserList();

        Optional<User> userOptional = userList.stream()
                .filter(user -> user.getEmail().equals(emailToUpdate))
                .findFirst();

        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();

            System.out.println("Enter new email: ");
            String newEmail = in.next();

            System.out.println("Enter new password: ");
            String newPassword = in.next();

            existingUser.setEmail(newEmail);
            existingUser.setPassword(newPassword);
			Database.write();


            System.out.println("User updated successfully!");
        } else {
            System.out.println("User not found.");
        }
    }
    /**
     * Displays the list of users in the system.
     */
    public void userList() {
        List<User> userList = Database.INSTANCE.getUserList();

        if (userList.isEmpty()) {
            System.out.println("User list is empty.");
        } else {
            System.out.println("User List:");
            for (User user : userList) {
                System.out.println("Email: " + user.getEmail() + ", UserType: " + user.getUserType());
            }
        }
    }
    /**
     * Displays the menu options for the Admin user.
     */
    public void displayMenu() {
		System.out.println("--------Admin's menu----------------");
		System.out.println("====================================");
		System.out.println("*	1) Add new user            *");
		System.out.println("*	2) Remove user             *");
		System.out.println("*	3) Update user             *");
		System.out.println("*	4) Show a list of users    *");
		System.out.println("*	5) Return back             *");
		System.out.println("*	6) Exit                    *");
		System.out.println("====================================");
    }
    /**
     * Runs the Admin user's menu and actions.
     *
     * @throws IOException if an I/O error occurs.
     */
	public void run() throws IOException {
		try {
			initScanner();
			menu : while(true){
				displayMenu();
//				System.out.println("What do you want to do?\n 1) Add new user \\n 2) Remove user \\n 3) Update user \\n 4) Show a list of users \\n 5) Return back \\n 6) Exit");
				int choice = in.nextInt();
				if(choice==1){
					addUser: while(true){
						addUser();
						Database.write();
						System.out.println("\n 1) Add new user \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addUser;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if(choice==2){
					removeUser: while(true){
						removeUser();
						Database.write();
						System.out.println("\n 1) Remove user \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue removeUser;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if(choice==3){
					updateUser: while(true){
						updateUser();
						Database.write();
						System.out.println("\n 1) Update user \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue updateUser;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if(choice==4){
					userList: while(true){
						userList();
						Database.write();
						System.out.println("\n 1) Show a users list \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue userList;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if (choice==6){
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
	      
	    }
	}
				
				
	
}
   