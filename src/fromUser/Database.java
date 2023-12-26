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
import manager.Manager;
import manager.News;
import research.ResearchJournal;
import research.ResearchPaper;
import research.ResearchProject;
import research.Researcher;
import student.*;
import teacher.Teacher;
import fromUser.*;

/**
 * the main storage of our system. Here we save and read data */
public class Database implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6402617175782597825L;
	/**
	 * 
	 */

	//	private static final long serialVersionUID = 6210088069147397395L; old
	
	   static Vector<Researcher> researchers = new Vector<Researcher>();
	    static Set<ResearchProject> projects = new HashSet<ResearchProject>();
	    static Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
	    static Set<ResearchJournal> journals = new HashSet<ResearchJournal>();

	
	private static Vector<Message> Messages = new Vector<>();
	private static Map<Integer, Course> allcourses = new HashMap<>();
	private static Vector<Student> allstudents = new Vector<>();
	private Vector<GraduateStudent> AllstudentMaster = new Vector<>();
	private static Set<ResearchPaper> researchPapers = new HashSet<>();
    private static Vector<String> strategicGoals;

    
    private List<Course> courses = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Manager> requests = new ArrayList<>();
    private List<News> news = new ArrayList<>();
    
	private static ArrayList<TechSupportSpecialist> orders = new ArrayList<>();
	
	// Singleton instance of the Database
    public static Database INSTANCE;
    private static ArrayList<User> users;

    private Database() {
        this.users = new ArrayList<>();
    }
    /**
     * Retrieves the singleton instance of the Database.
     *
     * @return The singleton instance of the Database.
     */
    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }
    /**
     * Adds a user to the system.
     *
     * @param user The user to be added.
     */
    public void addUser(User user) {
        users.add(user);
    }
    /**
     * Retrieves the list of users in the system.
     *
     * @return The list of users in the system.
     */
    public ArrayList<User> getUserList() {
        return users;
    }

    /**
     * Writes the user data to a file
     */   
    public static void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Database12"))) {
            oos.writeObject(users);
            System.out.println("Database written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
    /**
     * Reads user data from a file for system initialization.
     */
    public static void read() {
    	File file = new File("Database12");
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
    /**
     * Retrieves the list of messages in the system.
     *
     * @return The list of messages in the system.
     */
    public Vector <Message> getMessages() {
        return this.Messages;
    }
    /**
     * Sets the list of messages in the system.
     *
     * @param messages The list of messages to set.
     */
    public void setMessages(Vector <Message> Messages) {
        this.Messages = Messages;
    }
    /**
     * Sets the map of all courses in the system.
     *
     * @param allCourses The map of all courses to set.
     */
    public Map<Integer, Course> getAllcourses() {
        return this.allcourses;
    }
    public void setAllcourses(Map<Integer, Course> Allcourses) {
        this.allcourses = allcourses;
    }
    /**
     * Retrieves the list of all students in the system.
     *
     * @return The list of all students in the system.
     */
    
    public static Vector<Student> getAllstudents() {
        return allstudents;
    }
    /**
     * Sets the list of all students in the system.
     *
     * @param allStudents The list of all students to set.
     */
    public void setAllstudents(Vector<Student> Allstudents) {
        this.allstudents = Allstudents;
    }
    /**
     * Retrieves the list of all graduate students (master's level) in the system.
     *
     * @return The list of all graduate students (master's level) in the system.
     */
    public Vector<GraduateStudent> getAllstudentMaster() {
        return this.AllstudentMaster;
    }
    /**
     * Sets the list of all graduate students (master's level) in the system.
     *
     * @param allStudentMaster The list of all graduate students to set.
     */
    public void setAllstudentMaster(Vector<GraduateStudent> AllstudentMaster) {
        this.AllstudentMaster = AllstudentMaster;
    }
    /**
     * Adds a research project to the system.
     *
     * @param researchProject The research project to add.
     */
    public static void addResearchProject(ResearchProject researchProject) {
    	
    }
	public void updateStudent(Student student) {
        if (students.containsKey(student.getID())) {
            students.put(student.getID(), student);
        }
    }

    /**
     * Adds a message to the system.
     *
     * @param message The message to add.
     */
	public static void addMessage(Message m) {
		// TODO Auto-generated method stub
		
	}
	 /**
     * Retrieves the list of orders from the system.
     *
     * @return The list of orders in the system.
     */
	public ArrayList<TechSupportSpecialist> getOrders() {
		return orders;
	}
	/**
     * Sets the list of orders in the system.
     *
     * @param orders The list of orders to set.
     */
	public static void setOrders(ArrayList<TechSupportSpecialist> orders) {
		Database.orders = orders;
	}
    /**
     * Retrieves the list of complaints in the system.
     *
     * @return The list of complaints in the system.
     */

	public static Vector<Message> getComplaints() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
     * Retrieves a course from the system based on its ID.
     *
     * @param choice The ID of the course to retrieve.
     * @return The course with the specified ID.
     */
	public static Course getCourseAtID(Integer choice) {
		return allcourses.get(choice-1);
	}
	/**
     * Retrieves the list of students in the system.
     *
     * @return The list of students in the system.
     */
	public static Vector<Student> getStudents() {
		return allstudents;
	}
	/**
     * Retrieves a student from the system based on their ID.
     *
     * @param schoice The ID of the student to retrieve.
     * @return The student with the specified ID.
     */
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
	 /**
     * Adds a strategic goal to the system.
     *
     * @param goal The strategic goal to add.
     */
	public static void addStrategicGoal(String goal) {
		strategicGoals.add(goal);
	}
	/**
     * Removes a strategic goal from the system.
     *
     * @param goal The strategic goal to remove.
     */
	public static void removeStrategicGoal(String goal) {
		if(strategicGoals.contains(goal)) {
			strategicGoals.remove(goal);
	        System.out.println("Strategic goal '" + goal + "' removed");
		} else System.out.println("No such goal");
	}
	 /**
     * Retrieves the set of research journals in the system.
     *
     * @return The set of research journals in the system.
     */
	public static Set<ResearchJournal> getResearchJournal() {
		return journals;
	}

	public static void setResearchJournal(Set<ResearchJournal> researchJournal) {
		Database.journals = researchJournal;
	}
	public static void setResearcher(Vector<Researcher> researchers) {
		Database.researchers = researchers;
		
	}
	/**
     * Retrieves a researcher from the system based on their ID.
     *
     * @param choice The ID of the researcher to retrieve.
     * @return The researcher with the specified ID.
     */
	public static Researcher getResearcher(int id) {
		return (Researcher) researchers.stream().filter(n->n.getID().equals(id));
	}


	
	
	
	
	public static void addResearcher(Researcher researcher) {
        researchers.add(researcher);
    }
//

//
    public static void addResearchPaper(ResearchPaper paper) {
        papers.add(paper);
    }

    public static Vector<Researcher> getResearchers() {
        return researchers;
    }
//
    public static Set<ResearchProject> getResearchProjects(Researcher r) {
        return projects.stream().
        		filter(n->n.getParticipants().
        		contains(r)).collect(Collectors.toSet());
    }
//
    public static Vector<ResearchPaper> getResearchPapers(String choice) {
        return papers;
    }
//
	  public static Set<ResearchJournal> getResearchJournals() {
          return journals;
      }

	  public static Researcher getResearcher(String choice) {
		    try {
		        if (researchers != null && !researchers.isEmpty()) {
		            for (Researcher r : researchers) {
		                if (r.getID().equals(choice)) {
		                    return r;
		                }
		            }
		        } else {
		            System.out.println("Error: The 'researchers' collection is null or empty.");
		        }
		    } catch (Exception e) {
		        System.out.println("Error while searching for a researcher: " + e.getMessage());
		        e.printStackTrace();
		    }
		    return null;
		}

	public Object getNews() {
		// TODO Auto-generated method stub
		return null;
	}
	public Transcript getTranscriptForStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
