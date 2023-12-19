package fromUser;

import java.util.*;

import manager.News;
import research.ResearchPaper;
import research.ResearchProject;
import research.Researcher;
import student.*;


public class Database {
    private Vector <Message> Messages;
    private static Map <Integer, Course> allcourses;   /// id, course
    private static Vector<Student> allstudents;
    private Vector <GraduateStudent> AllstudentMaster;
    private ArrayList<User> users;
    private static Set<ResearchPaper> researchPapers;	
    private Vector<News> news;
    
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

    public static Vector<Student> getAllstudents() {
        return allstudents;
    }

    public void setAllstudents(Vector<Student> Allstudents) {
        this.allstudents = Allstudents;
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
	public static Vector<Message> getComplaints() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void addMessage(Message m) {
		// TODO Auto-generated method stub
		
	}
	public static void write() {
		// TODO Auto-generated method stub
		
	}
	public static Course getCourseAtID(Integer choice) {
		return allcourses.get(choice-1);
	}
	public static Vector<Student> getStudents() {
		return allstudents;
	}
	public static Student getStudentbyID(String schoice) {
		for(Student s: allstudents) {
			if(s.getID().equals(schoice)) {
				return s;
			}
		}
		return null;
	}
}
