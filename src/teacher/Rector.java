package teacher;

import java.util.Vector;

public class Rector extends Teacher implements Heads {
    
	private static Rector rector;
	
	private Rector() {
		
	}

    //                          Operations                                  
    public static Rector getInstance() {
    	return rector;
    }
    public void setStrageticGoals(Vector<String> goals) {
        return Database.setStrategicGoals();
    }

	@Override
	public Vector<String> getSchoolReports() {
		return Database.getSchoolReports();
	}

	@Override
	public void signToRequest(Message message) {
		super.sendMessage(); // "Message *message* approved;		
	}

    
}