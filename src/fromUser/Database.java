package fromUser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import fromEmployee.TechSupportSpecialist;
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
	private static final long serialVersionUID = -6402617175782597825L;
	/**
	 * 
	 */
//	private static final long serialVersionUID = 6210088069147397395L; old
	private static Vector<Message> Messages = new Vector<>();
	private static Map<Integer, Course> allcourses = new HashMap<>();
	private static Vector<Student> allstudents = new Vector<>();
	private Vector<GraduateStudent> AllstudentMaster = new Vector<>();
	private static Set<ResearchPaper> researchPapers = new HashSet<>();
	private Vector<News> news = new Vector<>();
    private static Vector<String> strategicGoals;
	private static Set<ResearchJournal> journals;
	private static Vector<Researcher> researchers = new Vector<Researcher>();
	private Vector<News> news = new Vector<>();

	private static ArrayList<TechSupportSpecialist> orders = new ArrayList<>();
	
	
    public static Database INSTANCE;
    private static ArrayList<User> users;

    private Database() {
        this.users = new ArrayList<>();
    }

    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUserList() {
        return users;
    }

    
    public static void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Database"))) {
            oos.writeObject(users);
            System.out.println("Database written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
    public static void read() {
    	File file = new File("Database");
    	if (file.exists()) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
        	users = (ArrayList<User>) ois.readObject();
            System.out.println("Database read successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }else {
        users = new ArrayList<>();
    }}

 

//    public List<User> getUserList() {
//    	return this.users.stream().filter(u->u instanceof User).map(u->(User)u).collect(Collectors.toList());
//    	}
//	public static int nextId() {
//		// TODO Auto-generated method stub
//		return  INSTANCE.users.size()+1;
//	}
	
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

    public static void addResearchProject(ResearchProject researchProject) {
    	
    }
	public static Set<ResearchPaper> getResearchPapers() {
		return researchPapers;
	}
	
	public static void addMessage(Message m) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<TechSupportSpecialist> getOrders() {
		return orders;
	}

	public static void setOrders(ArrayList<TechSupportSpecialist> orders) {
		Database.orders = orders;
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
		return (Researcher) researchers.stream().filter(n->n.getID().equals(id));
	}
	public static void addResearchPaper(ResearchPaper newPaper) {
		researchPapers.add(newPaper);
	}
	public static ResearchPaper getResearchPapers(String choice) {
		return (ResearchPaper) researchPapers.stream()
						     .filter(n->n.getTitle().equals(choice));
	}

	
	
	
}
