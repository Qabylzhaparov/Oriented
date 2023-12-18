package fromUser;

public class Test {
    public static void main(String[] args) {
    	User user2 = new User(null, "Aane", null, null, null, null, 0);
        User user1 = new Admin(null, "John", null, null, null, null, 0, null);
       
        Admin admin = new Admin(null, null, null, null, null, null, 0, null);
        
        admin.addUser(user1);
        admin.addUser(user2);
        
//        Message m = new Message(null, null, null, user1, null, null, null, null);
//        Message m2 = new Message(null, null, null, user1, null, null, null, null);
//        
//        Message mm = new Message();
//        mm.addMessage(m);
//        mm.addMessage(m2);
//        
//        System.out.println(mm.showMessage());
//        
//        
        
        
//        System.out.println("Users: " + admin.getUsers());
//        admin.removeUser(user1);
//        System.out.println("Updated Users: " + admin.getUsers());
//
//        User newUser = new User(null, "NewUser", null, null, null, null, 0);
//        admin.updateUser(user2, newUser);
//        System.out.println("Final Users: " + admin.getUsers());
        
        System.out.println(admin.getUsers());
        
        
        
    }
}
