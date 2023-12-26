package fromUser;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import fromEmployee.TechSupportSpecialist;
import manager.Manager;
import student.Student;
import teacher.Teacher;


public class Admin extends User {
/**
	 * 
	 */
	private static final long serialVersionUID = -6314193802692272885L;
	//	private static final long serialVersionUID = -5092781539768232544L; old
    private transient Scanner in;

    public Admin(UserType userType, String ID, String firstName, String lastName, String email, String password,
                 int phoneNumber) {
        super(userType, ID, firstName, lastName, email, password, phoneNumber);
    }

    public Admin() {
    }

    public Admin(String email, String password, UserType userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
    
    private void initScanner() {
        this.in = new Scanner(System.in);
    }

	private void save() throws IOException {
		Database.write();
	}
	private void exit() {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public void addUser() {
        System.out.println("Enter new user's email: ");
        String email = in.next();

        // Check if the user already exists
        if (!Database.INSTANCE.getUserList().stream().anyMatch(user -> user instanceof Admin && user.getEmail().equals(email))) {
            System.out.println("Enter new user's password: ");
            String password = in.next();

            System.out.println("Enter new user's UserType (STUDENT, TEACHER, MANAGER, TECHSUPPORTSPECIALIST, ADMIN): ");
            UserType userType = UserType.valueOf(in.next().toUpperCase());

            // Create an instance of the appropriate subclass based on UserType
            User newUser;
            switch (userType) {
                case ADMIN:
                    newUser = new Admin(email, password, userType);
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

   
    public void removeUser() {
        System.out.println("Enter user's email you want to delete: ");
        String emailToRemove = in.next();

        // Assuming Admin is a concrete subclass of User
        List<User> userList = Database.INSTANCE.getUserList();

        // Use a stream to find the user with the specified email
        Optional<User> userOptional = userList.stream()
                .filter(user -> user instanceof Admin && user.getEmail().equals(emailToRemove))
                .findFirst();

        // If the user is found, remove it from the list
        if (userOptional.isPresent()) {
            User userToRemove = userOptional.get();
            userList.remove(userToRemove);
			Database.write();
            System.out.println("User removed successfully!");
        } else {
            System.out.println("User not found.");
        }
    }


    public void updateUser() {
        System.out.println("Enter user's email you want to update: ");
        String emailToUpdate = in.next();

        // Assuming Admin is a concrete subclass of User
        List<User> userList = Database.INSTANCE.getUserList();

        // Search for the user based on email
        Optional<User> userOptional = userList.stream()
                .filter(user -> user.getEmail().equals(emailToUpdate))
                .findFirst();

        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();

            System.out.println("Enter new email: ");
            String newEmail = in.next();

            System.out.println("Enter new password: ");
            String newPassword = in.next();

            // Update the fields of the existing user
            existingUser.setEmail(newEmail);
            existingUser.setPassword(newPassword);
			Database.write();


            System.out.println("User updated successfully!");
        } else {
            System.out.println("User not found.");
        }
    }
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
	        // Close the Scanner
	      
	    }
	}
				
				
	
}
   