package research;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;


public class ResearchDatabase implements Serializable {
    private static final long serialVersionUID = 1L;

    static Vector<Researcher> researchers = new Vector<Researcher>();
    static Set<ResearchProject> projects = new HashSet<ResearchProject>();
    static Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
    static Set<ResearchJournal> journals = new HashSet<ResearchJournal>();

    public static ResearchDatabase INSTANCE;

    static {
        try {
            read();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
            INSTANCE = new ResearchDatabase();
        }
    }

    private ResearchDatabase() {  }

    public static void read() throws IOException, ClassNotFoundException {
        File file = new File("data7");

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                INSTANCE = (ResearchDatabase) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw e; 
            }
        } else {
            System.out.println("The file 'data' does not exist.");
            ResearchDatabase.INSTANCE = new ResearchDatabase();
        }
    }

    public static void write() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data7"))) {
            oos.writeObject(INSTANCE);
        } catch (IOException e) {
            throw e; 
        }
    }
    // Методы для добавления элементов в базу данных

    public static void addResearcher(Researcher researcher) {
        researchers.add(researcher);
    }
//
    public static void addResearchProject(ResearchProject project) {
        projects.add(project);
    }
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
    public static Vector<ResearchPaper> getResearchPapers() {
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

	public static void addResearchJournal(ResearchJournal j) {
		journals.add(j);
	}

	public static ResearchPaper getResearchPapers(String choice) {
		return (ResearchPaper) papers.stream()
			     .filter(n->n.getTitle().equals(choice));
	}

}