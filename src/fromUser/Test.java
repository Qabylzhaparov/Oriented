package fromUser;

import java.io.IOException;

import student.Student;

public class Test {
    public static void main(String[] args) {
//    		try {
//    			(new Admin()).run();
//    		} catch (IOException e) {
//    			e.printStackTrace();
//    		}
//    		
//    	}
        try {
            User user = new User();
            User currentUser = user.login();
            
            if (currentUser != null) {
                switch (currentUser.getUserType()) {
                    case ADMIN:
                        new Admin().run();
                        break;
                    case STUDENT:
                        new Student(null, null, null, null, null, null, 0).run();
                        break;
                       
                    // Add more cases for other user types if needed
                    default:
                        System.out.println("Unsupported user type.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
