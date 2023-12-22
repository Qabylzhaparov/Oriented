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
import research.ResearchJournal;
import research.ResearchPaper;
import research.ResearchProject;
import research.Researcher;
import student.*;
import fromUser.*;


public class Database implements Serializable {
    /**
	 * 
	 */
//	private static final long serialVersionUID = 1087290420221856411L;
	private static Vector <Message> Messages;
    private static Map <Integer, Course> allcourses;   /// id, course
    private static Vector<Student> allstudents;
    private Vector <GraduateStudent> AllstudentMaster;
    ArrayList<User> users;
//    private List <User> users;
    private static Set<ResearchPaper> researchPapers;	
    private Vector<News> news;
    
    private static Vector<String> strategicGoals;
	private static Set<ResearchJournal> journals;
	private static Vector<Researcher> researchers;

    public Database() {
    	
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
	public static Set<ResearchJournal> getResearchJournal() {
		return journals;
	}
	public static Vector<Researcher> getResearcher() {
		return researchers;
	}
	public static void setResearchJournal(Set<ResearchJournal> researchJournal) {
		Database.journals = researchJournal;
	}
	public static void setResearcher(Vector<Researcher> researchers) {
		Database.researchers = researchers;
		
	}
	public static Researcher getResearcher(int id) {
		return (Researcher) researchers.stream().filter(n->n.getId().equals(id));
	}
	public static void addResearchPaper(ResearchPaper newPaper) {
		researchPapers.add(newPaper);
	}
	public static ResearchPaper getResearchPapers(String choice) {
		return (ResearchPaper) researchPapers.stream()
						     .filter(n->n.getTitle().equals(choice));
	}
	
	
}
