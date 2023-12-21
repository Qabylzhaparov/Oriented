package fromUser;

import java.util.*;
import java.util.stream.Collectors;


public class Admin extends User{
	Scanner in = new Scanner(System.in);
	/// empty constructor
	
	/// constructor with just name
	
	/// constructor with name and users
	
    public Admin(UserType UserType, String ID, String FirstName, String LastName, String Email,
			String Password, int PhoneNumber, ArrayList<User> users) {
		super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber);
		this.users = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
    
//Collection Stream: sorted method
    public List<User> getUsers() {
        List<User> show = users.stream().sorted()
          .collect(Collectors.toList());
     
      return show;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public boolean addUser(User user) {
    	System.out.println("Enter name: ");
        if (!Database.INSTANCE.users.contains(in.next())) {
            Database.INSTANCE.users.add(new User(in.next()));
            System.out.println("Enter password: ");
            Database.INSTANCE
            return true;
        } else {
            System.out.println("User already exists.");
            return false;
        }    	
    	
    	
        // Check if the user already exists before adding

    }

    public boolean removeUser(User user) {
        // Remove the user if it exists
        if (users.contains(user)) {
            users.remove(user);
            return true;
        } else {
            System.out.println("User not found.");
            return false;
        }
    }

    public boolean updateUser(User oldUser, User newUser) {
        // Update the user if it exists
        if (users.contains(oldUser)) {
            int index = users.indexOf(oldUser);
            users.set(index, newUser);
            return true;
        } else {
            System.out.println("User not found.");
            return false;
        }
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Admin admin = (Admin) obj;
        return Objects.equals(users, admin.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

//    @Override
//    public int compareTo(User otherAdmin) {
//        // Compare Admin objects based on the number of users they have
//        return Integer.compare(this.users.size(), otherAdmin.size());
//    }

    @Override
    public Admin clone() throws CloneNotSupportedException {
        // Perform a shallow copy by invoking the Object.clone() method
		Admin clonedAdmin = (Admin) super.clone();
		// Create a new ArrayList to avoid sharing the same reference
		clonedAdmin.users = new ArrayList<>(this.users);
		return clonedAdmin;
    }
}

