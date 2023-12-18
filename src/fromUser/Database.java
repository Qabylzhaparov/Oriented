package fromUser;

import java.util.*;

import research.ResearchPaper;
import research.ResearchProject;
import research.Researcher;
import student.*;


public class Database {
    private Vector <Message> Messages;
    private Vector <Course> Allcourses;
    private Vector <Student> Allstudents;
    private Vector <GraduateStudent> AllstudentMaster;
    private ArrayList<User> users;
    private static Set<ResearchPaper> researchPapers;		
    
    public Database() {
    	
    }    
    public Vector <Message> getMessages() {
        return this.Messages;
    }
    public void setMessages(Vector <Message> Messages) {
        this.Messages = Messages;
    }

    public Vector<Course> getAllcourses() {
        return this.Allcourses;
    }
    public void setAllcourses(Vector<Course> Allcourses) {
        this.Allcourses = Allcourses;
    }

    public Vector<Student> getAllstudents() {
        return this.Allstudents;
    }

    public void setAllstudents(Vector<Student> Allstudents) {
        this.Allstudents = Allstudents;
    }

    public Vector<GraduateStudent> getAllstudentMaster() {
        return this.AllstudentMaster;
    }

    public void setAllstudentMaster(Vector<GraduateStudent> AllstudentMaster) {
        this.AllstudentMaster = AllstudentMaster;
    }
    public ArrayList<User> getUsers(){
		return users;
    }
    public void setUsers(ArrayList<User> users) {
    	this.users = users;
    }
    public static boolean addResearchProject(ResearchProject researchProject) {
    	return true;
    }
	public static Set<ResearchPaper> getResearchPapers() {
		return researchPapers;
	}
}
