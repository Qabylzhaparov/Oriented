package fromUser;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import manager.News;

// Wellcome!!!
// Enter your Email and password
// if Admin thenn open Admin's display, if Student then open Students display
public class User implements Comparable<User>, Cloneable, UserInterface, Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = -7529410772627156558L;
static Scanner in = new Scanner(System.in);
	private UserType userType;
    private String ID;
    private String FirstName;
    private String LastName;
    protected String Email;
    protected String Password;
    private int PhoneNumber;   /// kishi arip
  
    public User() {
    	
    }
    public User(String Email, String Password, UserType userType) {
    	this.Email = Email;
    	this.Password = Password;
    	this.userType = userType;
    }
    public User(String name) {
    	this.FirstName = name;
    }
    
    /// constructor with firstname, lastname
    
    public User(UserType userType,String ID,String FirstName,String LastName, String Email, String Password, int PhoneNumber) {
    	this.userType = userType;
    	this.Email = Email;
    	this.FirstName = FirstName;
    	this.ID = ID;
    	this.LastName = LastName;
    	this.Password = Password;
    	this.PhoneNumber = PhoneNumber;
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
        return this.FirstName;
    }
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    public String getLastName() {
        return this.LastName;
    }
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    public String getEmail() {
        return this.Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getPassword() {
        return this.Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public Integer getPhoneNumber() {
        return this.PhoneNumber;
    }
    public void setPhoneNumber(Integer PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
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
	public static User login() {
	    System.out.println("Enter your Email: ");
	    String enteredEmail = in.next();
	    System.out.println("Enter your password: ");
	    String enteredPassword = in.next();
	    User enteredUser = new User(enteredEmail, enteredPassword, null);

	    List<User> userList = Database.INSTANCE.getUserList();

	    for (User user : userList) {
	        if (user.equals(enteredUser)) {
	            System.out.println("Login successful!");
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
		}
	
    
    ///public viewNews()

    public void commentNews(News news, String comment) {
         news.addComment(comment);                                  /// navernoe news.addComment(String comment)
    }                                                                       /// a ne return comment
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Email, user.Email) && Objects.equals(Password, user.Password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Email, Password);
    }
    @Override
    public String toString() {
        // Placeholder logic for generating a string representation of the user
        return "User{" +
                "userType=" + userType +
                ", ID='" + ID + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", PhoneNumber=" + PhoneNumber +
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
    
    

