package teacher;
import java.util.Vector;

import fromUser.Database;
import fromUser.Message;
import manager.SchoolType;


public class Dean extends Teacher implements Heads {
	private SchoolType deanOfSchool;
	
	public Dean() {
    	super();
    }
	
	public Dean(String name) {
		super(name);
	}

    public Dean(String name, SchoolType deanOfSchool) {
        super(name);
    	this.deanOfSchool = deanOfSchool;
    }
    
    
    public SchoolType getDeanOfSchool() {
        return this.deanOfSchool;
    }
    
    public void setDeanOfSchool(SchoolType deanOfSchool) {
        this.deanOfSchool = deanOfSchool;
    }

    // Operations 
    public Vector<Message> getComplaints() {
        return Database.getComplaints();
    }

    @Override
    public void signToRequest(Message message) {
        super.sendMessage(); // "Message *message* approved;
    }

	@Override
	public void signToRequest(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signToRequest(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<String> getSchoolReports() {
		// TODO Auto-generated method stub
		return null;
	}
}
