package fromUser;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            // Ensure that the Database is properly initialized
            Database.getInstance();
            Database.read();

            // Create an instance of Admin to invoke run()
            Admin admin = new Admin();
            admin.run();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	Database.write();
        }
    }
}
