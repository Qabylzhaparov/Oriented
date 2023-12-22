package fromUser;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Admin extends User{
	Scanner in = new Scanner(System.in);
	/// empty constructor
	
	/// constructor with just name
	
	/// constructor with name and users
	public Admin() {
		
	}
	
//    public Admin(UserType UserType, String ID, String FirstName, String LastName, String Email,
//			String Password, int PhoneNumber, ArrayList<User> users) {
//		super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber);
//		// TODO Auto-generated constructor stub
//	}
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
    	Email = in.next();
        if (!Database.INSTANCE.users.contains(new User(Email, ""))) {
            System.out.println("Enter new user's password: ");
            Password = in.next();
            Database.INSTANCE.users.add(new User(Email, Password));
            System.out.println("New user added successfully!");
        } else {
            System.out.println("User already exists.");
        }
    }

    public void closeScanner() {
        in.close();
    
    }

    
	public void run() throws IOException {
		try {
			System.out.println("Welcome!");
			menu : while(true){
				System.out.println("What do you want to do?\n 1) Add student \n 2) Exit");
				int choice = in.nextInt();
				if(choice==1){
					addStudent: while(true){
						addUser();
						System.out.println("\n 1) Add new user  \n 2) Return back \n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addStudent;
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
			} catch (Exception e) {
				System.out.println("Something bad happened... \n Saving resources...");
				e.printStackTrace();
				save();
			}
	}
				
				
	
}
    
//Collection Stream: sorted method
//    public List<User> getUsers() {
//        List<User> show = users.stream().sorted()
//          .collect(Collectors.toList());
//     
//      return show;
//    }
//
//    public void setUsers(ArrayList<User> users) {
//        this.users = users;
//    }



//    public boolean removeUser(User user) {
//        // Remove the user if it exists
//        if (users.contains(user)) {
//            users.remove(user);
//            return true;
//        } else {
//            System.out.println("User not found.");
//            return false;
//        }
//    }

//    public boolean updateUser(User oldUser, User newUser) {
//        // Update the user if it exists
//        if (users.contains(oldUser)) {
//            int index = users.indexOf(oldUser);
//            users.set(index, newUser);
//            return true;
//        } else {
//            System.out.println("User not found.");
//            return false;
//        }
//    }
    
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Admin admin = (Admin) obj;
//        return Objects.equals(users, admin.users);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(users);
//    }

//    @Override
//    public int compareTo(User otherAdmin) {
//        // Compare Admin objects based on the number of users they have
//        return Integer.compare(this.users.size(), otherAdmin.size());
//    }

//    @Override
//    public Admin clone() throws CloneNotSupportedException {
//        // Perform a shallow copy by invoking the Object.clone() method
//		Admin clonedAdmin = (Admin) super.clone();
//		// Create a new ArrayList to avoid sharing the same reference
//		clonedAdmin.users = new ArrayList<>(this.users);
//		return clonedAdmin;
//    }
//}

