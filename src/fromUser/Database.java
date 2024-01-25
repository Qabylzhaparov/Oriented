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
    private static Vector<String> strategicGoals;
    private List<Course> courses = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Manager> requests = new ArrayList<>();
    private List<News> news = new ArrayList<>();
    
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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Database12"))) {
            oos.writeObject(users);
            System.out.println("Database written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
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
//	public static int getReceiverId(int id) {
//		for(Message m: Messages) {
//			if(m.getReceiverId()==id) {
//				return m.getReceiverId();
//			}
//		}
//		return -1;
//	}
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

	public static void setResearchJournal(Set<ResearchJournal> researchJournal) {
		Database.journals = researchJournal;
	}
	public static void setResearcher(Vector<Researcher> researchers) {
		Database.researchers = researchers;
		
	}
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
//
//    public static void addResearchJournal(ResearchJournal journal) {
//        journals.add(journal);
//    }
//
//    // Методы для получения элементов из базы данных
//
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

	
	
	
}
