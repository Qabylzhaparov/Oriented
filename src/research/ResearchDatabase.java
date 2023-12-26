package research;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * The ResearchDatabase class represents the database for storing research-related entities.
 * It implements the Serializable interface to support serialization.
 */
public class ResearchDatabase implements Serializable {
    private static final long serialVersionUID = 1L;

    // Static collections to store researchers, projects, papers, and journals
    static Vector<Researcher> researchers = new Vector<Researcher>();
    static Set<ResearchProject> projects = new HashSet<ResearchProject>();
    static Vector<ResearchPaper> papers = new Vector<ResearchPaper>();
    static Set<ResearchJournal> journals = new HashSet<ResearchJournal>();

    // Singleton instance of the ResearchDatabase
    public static ResearchDatabase INSTANCE;

    // Static block to initialize the ResearchDatabase instance by deserialization or create a new instance
    static {
        try {
            read();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
            INSTANCE = new ResearchDatabase();
        }
    }

    // Private constructor to enforce the singleton pattern
    private ResearchDatabase() {
    }

    /**
     * Reads the serialized data from the file and initializes the ResearchDatabase instance.
     *
     * @throws IOException            If an I/O error occurs during reading.
     * @throws ClassNotFoundException If the class of the serialized object cannot be found.
     */
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

    /**
     * Writes the serialized data of the ResearchDatabase instance to the file.
     *
     * @throws IOException If an I/O error occurs during writing.
     */
    public static void write() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data7"))) {
            oos.writeObject(INSTANCE);
        } catch (IOException e) {
            throw e;
        }
    }

    // Methods for adding elements to the database

    /**
     * Adds a researcher to the database.
     *
     * @param researcher The researcher to add.
     */
    public static void addResearcher(Researcher researcher) {
        researchers.add(researcher);
    }

    /**
     * Adds a research project to the database.
     *
     * @param project The research project to add.
     */
    public static void addResearchProject(ResearchProject project) {
        projects.add(project);
    }

    /**
     * Adds a research paper to the database.
     *
     * @param paper The research paper to add.
     */
    public static void addResearchPaper(ResearchPaper paper) {
        papers.add(paper);
    }

    /**
     * Adds a research journal to the database.
     *
     * @param journal The research journal to add.
     */
    public static void addResearchJournal(ResearchJournal journal) {
        journals.add(journal);
    }

    // Methods for retrieving elements from the database

    /**
     * Gets the collection of researchers in the database.
     *
     * @return The collection of researchers.
     */
    public static Vector<Researcher> getResearchers() {
        return researchers;
    }

    /**
     * Gets the set of research projects associated with a researcher.
     *
     * @param r The researcher for whom to retrieve the research projects.
     * @return The set of research projects associated with the researcher.
     */
    public static Set<ResearchProject> getResearchProjects(Researcher r) {
        return projects.stream()
                .filter(n -> n.getParticipants()
                        .contains(r)).collect(Collectors.toSet());
    }

    /**
     * Gets the collection of research papers in the database.
     *
     * @return The collection of research papers.
     */
    public static Vector<ResearchPaper> getResearchPapers() {
        return papers;
    }

    /**
     * Gets the set of research journals in the database.
     *
     * @return The set of research journals.
     */
    public static Set<ResearchJournal> getResearchJournals() {
        return journals;
    }

    /**
     * Gets a researcher by their ID.
     *
     * @param choice The ID of the researcher to retrieve.
     * @return The researcher with the specified ID, or null if not found.
     */
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

    /**
     * Gets a research paper by its title.
     *
     * @param choice The title of the research paper to retrieve.
     * @return The research paper with the specified title, or null if not found.
     */
    public static ResearchPaper getResearchPapers(String choice) {
        return (ResearchPaper) papers.stream()
                .filter(n -> n.getTitle().equals(choice));
    }
}
