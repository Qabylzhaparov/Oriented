package fromUser;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

import fromEmployee.TechSupportSpecialist;
import manager.Manager;
import manager.News;
import research.*;
import student.Student;
import teacher.Teacher;

//The User class serves as the base class for all users in the KBTU system.
public abstract class User implements Comparable<User>, Cloneable, UserInterface, Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 3993260915863513245L;
//    private static final long serialVersionUID = -7529410772627156558L; old
	
    protected transient static Scanner in = new Scanner(System.in);
    protected UserType userType;
    private String ID;
    private String firstName;
    private String lastName;
    protected String email;
    protected String password;
    private int phoneNumber;

    public User() {
    }
    /**
     * Constructor for the login to the system.
     *
     * @param email    The user's email.
     * @param password The user's password.
     * @param userType The user's type (Admin, Researcher, Manager, etc.).
     */
    public User(String email, String password, UserType userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
    /**
     * Detailed constructor with user information.
     *
     * @param userType     The user's type.
     * @param ID           The user's ID.
     * @param firstName    The user's first name.
     * @param lastName     The user's last name.
     * @param email        The user's email.
     * @param password     The user's password.
     * @param phoneNumber  The user's phone number.
     */
    public User(UserType userType, String ID, String firstName, String lastName, String email, String password,
                int phoneNumber) {
        this.userType = userType;
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public UserType getUserType() {
        return userType;
    }
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    public String getID() {
        return this.ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String LastName) {
        this.lastName = LastName;
    }
    public String getEmail() {
    	return (email != null) ? email : "";
    }
    public void setEmail(String Email) {
        this.email = Email;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String Password) {
        this.password = Password;
    }
    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(Integer PhoneNumber) {
        this.phoneNumber = PhoneNumber;
    }
    
    /**
     * Saves the user data to the database. 
     *
     * @throws IOException 
     */
    private void save() throws IOException {
		Database.write();
	}
    /**
     * Exits the system and prints a farewell message. 
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
     * Login method prompts the user to enter their email and password for login.
     * Returns the logged-in user instance.
     *
     * @return The logged-in User instance.
     * @throws IOException.
     */
	public static User login() throws IOException {
	    System.out.println("Enter your Email: ");
	    String enteredEmail = in.next();
	    System.out.println("Enter your password: ");
	    String enteredPassword = in.next();

	    List<User> userList = Database.INSTANCE.getUserList();
	    Iterator<User> iterator = userList.iterator();

	    while (iterator.hasNext()) {
	        User user = iterator.next();
	        if (user.getEmail().equals(enteredEmail) && user.getPassword().equals(enteredPassword)) {
	            System.out.println("Login successful!");
	            System.out.println("************Welcome to KBTU system***************");

	            if (user instanceof Researcher) {
	                Researcher researcher = (Researcher) user;
	                researcher.Researcherrun();
	            }
	            else if (user instanceof Admin) {
	            	Admin admin = (Admin) user;
	            	admin.run();}
	            else if (user instanceof Manager) {
           	 		Manager manager = (Manager) user;
           	 		manager.run();
            }
	            else if (user instanceof Teacher) {
               	 Teacher teacher = (Teacher) user;
                    teacher.run();
               } else if (user instanceof Student) {
               	 Student student = (Student) user;
                    student.run();
               }  else if(user instanceof TechSupportSpecialist) {
               	 TechSupportSpecialist techSupportSpecialist = (TechSupportSpecialist) user;
               	 techSupportSpecialist.run();
               } 

	            return user;
	        }
	    }


	    System.out.println("Incorrect email or password. Try again!!!.");
	    return login();
	}
	/**
     * Abstract method representing the main functionality of a user. 
     * Subclasses will implement it.
     *
     * @throws IOException .
     */
	public abstract void run() throws IOException;
	
	/**
     * Abstract method for displaying the menu specific to each type of user. 
     */
    public abstract void displayMenu();


/** 
 *  for write comments to news
 * */
    public void commentNews(News news, String comment) {
         news.addComment(comment);                                  
    }                                                           
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
    @Override
    public String toString() {

        return "User{" +
                "userType=" + userType +
                ", ID='" + ID + '\'' +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", Email='" + email + '\'' +
                ", Password='" + password + '\'' +
                ", PhoneNumber=" + phoneNumber +
                '}';
    }
 
    /**
     * Compares this user with another user based on their ID.
     *
     * @param otherUser The user to compare with.
     */
    @Override
    public int compareTo(User otherUser) {
        return this.ID.compareTo(otherUser.ID);
    }

    /**
     * Clones the current user. 
     *
     * @return A clone of the current user.
     */
    @Override
    public User clone() throws CloneNotSupportedException {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
    
    

