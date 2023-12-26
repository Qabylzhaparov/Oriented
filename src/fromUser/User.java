package fromUser;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import manager.News;
import research.*;
import student.Student;
import teacher.Teacher;

public abstract class User implements Comparable<User>, Cloneable, UserInterface, Serializable {
    private static final long serialVersionUID = -7529410772627156558L;
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

    public User(String name) {
    	this.firstName = name;
    }
    
    public User(String email, String password, UserType userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

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
        return this.email;
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
	public static User login() throws IOException {
	    System.out.println("Enter your Email: ");
	    String enteredEmail = in.next();
	    System.out.println("Enter your password: ");
	    String enteredPassword = in.next();

	    List<User> userList = Database.INSTANCE.getUserList();

	    for (User user : userList) {
	        // Check if the user has the same email and password
	        if (user.getEmail().equals(enteredEmail) && user.getPassword().equals(enteredPassword)) {
	            System.out.println("Login successful!");

	            // Perform type-specific actions based on the user type
	            if (user instanceof Admin) {
	            	Admin admin = (Admin) user;
                    admin.run();	            
                } else if (user instanceof Teacher) {
                	 Teacher teacher = (Teacher) user;
                     teacher.run();
                } else if (user instanceof Student) {
                	 Student student = (Student) user;
                     student.run();
                     } 

	            return user;
	        }
	    }

	    System.out.println("Incorrect email or password. Login failed.");
	    return null;
	}
    
	public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println(" 1) Login \\n 2) Exit");
				int choice = in.nextInt();
				if(choice==1){
					login: while(true){
						login();
						System.out.println("\n 1) login \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue login;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if (choice==2){
					exit();
					break menu;
				}
			}
			}catch (Exception e) {
				System.out.println("Something bad happened... \n Saving resources...");
				e.printStackTrace();
				save();
			}
		finally {
	        // Close the Scanner
	        in.close();
	    }
		}
	public void closeScanner() {
        in.close();
    }
    
    ///public viewNews()

    public void commentNews(News news, String comment) {
         news.addComment(comment);                                  /// navernoe news.addComment(String comment)
    }                                                                       /// a ne return comment
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
        // Placeholder logic for generating a string representation of the user
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
 


//    
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        User user = (User) obj;
//        return PhoneNumber == user.PhoneNumber &&
//                Objects.equals(ID, user.ID) &&
//                Objects.equals(FirstName, user.FirstName) &&
//                Objects.equals(LastName, user.LastName) &&
//                Objects.equals(Email, user.Email) &&
//                Objects.equals(Password, user.Password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(ID, FirstName, LastName, Email, Password, PhoneNumber);
//    }

    @Override
    public int compareTo(User otherUser) {
        // Compare users based on their ID (you can customize this based on your requirements)
        return this.ID.compareTo(otherUser.ID);
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        try {
            // Perform a shallow copy by invoking the Object.clone() method
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            // This should not happen since User implements Cloneable
            throw new InternalError(e);
        }
    }
}
    
    

