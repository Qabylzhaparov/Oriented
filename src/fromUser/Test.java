package fromUser;

import java.io.IOException;
import java.util.List;

import student.Student;

public class Test {
    public static void main(String[] args) {
        try {

            Database.getInstance();
            Database.read();
            fromUser.User.login();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Database.write();
        }
    }
}

//package fromUser;
//
//import java.io.IOException;
//
//public class Test {
//    public static void main(String[] args) {
//        try {
//            // Ensure that the Database is properly initialized
//            Database.getInstance();
//            Database.read();
//
//            // Create an instance of Admin to invoke run()
//            Admin admin = new Admin();
//            admin.run();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//        	Database.write();
//        }
//    }
//}
