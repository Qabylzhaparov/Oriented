package fromUser;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		try {
			(new Admin()).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
