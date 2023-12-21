package fromUser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import manager.News;
import research.ResearchPaper;
import research.ResearchProject;
import research.Researcher;
import student.*;
import fromUser.*;


public class Database {
    private static Vector <Message> Messages;
    private static Map <Integer, Course> allcourses;   /// id, course
    private static Vector<Student> allstudents;
    private Vector <GraduateStudent> AllstudentMaster;
    Vector<User> users  = new Vector<User>();
//    private List <User> users;
    private static Set<ResearchPaper> researchPapers;	
    private Vector<News> news;
    
    private static Vector<String> strategicGoals;
    
    public static Database INSTANCE;
	static {
		if(new File("data").exists()) {
			try {
				INSTANCE = read();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else INSTANCE = new Database();
	}
    
    public Database() {
    	
    }
    
    public static Database read() throws IOException, ClassNotFoundException{
    	FileInputStream fis = new FileInputStream("Database");
    	ObjectInputStream ois = new ObjectInputStream(fis);
    	return (Database) ois.readObject();
 
    }
    
	public static void write()throws IOException{
		FileOutputStream fos = new FileOutputStream("Database");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(INSTANCE);
		oos.close();
	}
	
    public Vector <Message> getMessages() {
        return this.Messages;
    }
    public void setMessages(Vector <Message> Messages) {
        this.Messages = Messages;
    }

    public Map<Integer, Course> getAllcourses() {
        return this.allcourses;
    }
    public void setAllcourses(Map<Integer, Course> Allcourses) {
        this.allcourses = allcourses;
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
    public List<User> getUsers(){
		return users;
    }
    public void setUsers(List<User> users) {
    	this.users = users;
    }
    public static boolean addResearchProject(ResearchProject researchProject) {
    	return true;
    }
	public static Set<ResearchPaper> getResearchPapers() {
		return researchPapers;
	}
	
	public static void addMessage(Message m) {
		// TODO Auto-generated method stub
		
	}

	/// Астындагынын бари меники
	public static Vector<Message> getComplaints() {
		// TODO Auto-generated method stub
		return null;
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
	public static int getReceiverId(int id) {
		for(Message m: Messages) {
			if(m.getReceiverId()==id) {
				return m.getReceiverId();
			}
		}
		return -1;
	}
	public static void addStrategicGoal(String goal) {
		strategicGoals.add(goal);
	}
	public static void removeStrategicGoal(String goal) {
		if(strategicGoals.contains(goal)) {
			strategicGoals.remove(goal);
	        System.out.println("Strategic goal '" + goal + "' removed");
		} else System.out.println("No such goal");
	}
	
	
}
