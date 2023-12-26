package research;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

import fromUser.Database;
import fromUser.User;


public class ResearchDatabase implements Serializable {
    private static final long serialVersionUID = 1L;

    Vector<Researcher> researchers = new Vector<Researcher>();
    Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
    Set<ResearchJournal> journals = new HashSet<ResearchJournal>();
    Set<ResearchProject> projects = new HashSet<>();

    protected transient Scanner in;

    public static ResearchDatabase INSTANCE;


    static {
		if(new File("data5").exists()) {
			try {
				INSTANCE = read();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else INSTANCE = new ResearchDatabase();
	}
    
    private ResearchDatabase() { 
    }
    
    public static ResearchDatabase read() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("data5");
        ObjectInputStream oin = new ObjectInputStream(fis);
        ResearchDatabase instance = (ResearchDatabase) oin.readObject();
        instance.initScanner(); 
        return instance;
    }


	private void initScanner() {
        this.in = new Scanner(System.in);		
	}

	public static void write()throws IOException{
		FileOutputStream fos = new FileOutputStream("data5");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(INSTANCE);
		oos.close();
	}
    // Методы для добавления элементов в базу данных

//    public static void addResearcher(Researcher researcher) {
//        researchers.add(researcher);
//    }
//
//    public static void addResearchProject(ResearchProject project) {
//        projects.add(project);
//    }
//
//    public static void addResearchPaper(ResearchPaper paper) {
//        papers.add(paper);
//    }
//
//    public static void addResearchJournal(ResearchJournal journal) {
//        journals.add(journal);
//    }
//
//    // Методы для получения элементов из базы данных
//
//    public static Vector<Researcher> getResearchers() {
//        return researchers;
//    }
//
//    public static Set<ResearchProject> getResearchProjects(Researcher r) {
//        if(!projects.isEmpty()) {
//        	return projects.stream().
//        			filter(n->n.getParticipants().
//        					contains(r)).collect(Collectors.toSet());        	
//        } else {
//        	return new HashSet<>();
//        }
//    }
//
//    public static Vector<ResearchPaper> getResearchPapers() {
//        return papers;
//    }
//
//	  public static Set<ResearchJournal> getResearchJournals() {
//          return journals;
//      }

//	  public static Researcher getResearcher(String choice) {
//		    try {
//		        if (researchers != null && !researchers.isEmpty()) {
//		            for (Researcher r : researchers) {
//		                if (r.getID().equals(choice)) {
//		                    return r;
//		                }
//		            }
//		        } else {
//		            System.out.println("Error: The 'researchers' collection is null or empty.");
//		        }
//		    } catch (Exception e) {
//		        System.out.println("Error while searching for a researcher: " + e.getMessage());
//		        e.printStackTrace();
//		    }
//		    return null;
//		}

}
