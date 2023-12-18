package teacher;
import java.util.Vector;

import fromUser.Message;
import student.SchoolType;


public class Dean extends Teacher implements Heads {
    private SchoolType deanOfSchool;
    
//    public Dean(SchoolType deanOfSchool) {
//        this.deanOfSchool = deanOfSchool;
//    }
    
    
    public SchoolType getDeanOfSchool() {
        return this.deanOfSchool;
    }
    
    public void setDeanOfSchool(School deanOfSchool) {
        this.deanOfSchool = deanOfSchool;
    }

    // Operations 
    public Vector<Message> getComplaints() {
        return Database.getComplaints();
    }

    @Override
    public Vector<String> getSchoolReports() {
        return Database.getSchoolReports();
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
}
