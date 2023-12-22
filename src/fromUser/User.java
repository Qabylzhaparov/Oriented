package fromUser;

import java.io.Serializable;
import java.util.Objects;

import manager.News;

public class User implements Comparable<User>, Cloneable, UserInterface, Serializable{
    private UserType UserType;
    private String ID;
    private String FirstName;
    private String LastName;
    protected String Email;
    protected String Password;
    private int PhoneNumber;   /// kishi arip
  
    public User() {
    	
    }
    public User(String Email, String Password) {
    	this.Email = Email;
    	this.Password = Password;
    }
    public User(String name) {
    	this.FirstName = name;
    }
    
    /// constructor with firstname, lastname
    
    public User(UserType UserType,String ID,String FirstName,String LastName, String Email, String Password, int PhoneNumber) {
    	this.UserType = UserType;
    	this.Email = Email;
    	this.FirstName = FirstName;
    	this.ID = ID;
    	this.LastName = LastName;
    	this.Password = Password;
    	this.PhoneNumber = PhoneNumber;
    }
    
    public UserType getUserType() {
        return this.UserType;
    }
    public void setUserType(UserType UserType) {
        this.UserType = UserType;
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
    


    public boolean login(String enteredPassword, String enteredEmail) {
        // Check if the entered password matches the user's password
        if (enteredPassword.equals(Password) && enteredEmail.equals(Email)) {
            System.out.println("Login successful!");
            return true;                                                    /// logica logina
        } else {                                                            /// s sessiei shto nibud'
            System.out.println("Incorrect password. Login failed.");        /// kak assylzhan skazal
            return false;
        }
    }

    public boolean logout(int exit) {
        // Placeholder logic for logout
    	if(exit == 0) {
    		System.out.println("Logout successful!");
    		return true;                                                    /// navernoe ubrat s sessii
    	}else {
    		
    		return false;
    	}
    }
    
    ///public viewNews()

    public void commentNews(News news, String comment) {
         news.addComment(comment);                                  /// navernoe news.addComment(String comment)
    }                                                                       /// a ne return comment

    @Override
    public String toString() {
        // Placeholder logic for generating a string representation of the user
        return "User{" +
                "userType=" + UserType +
                ", ID='" + ID + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                '}';
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Email, user.Email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Email);
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
    
    

