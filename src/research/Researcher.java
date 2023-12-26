package research;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import student.*;
import teacher.*;
import fromEmployee.*;
import fromUser.Database;
import fromUser.User;
import fromUser.UserInterface;
import fromUser.UserType;

/**
 * The Researcher class represents a user with researcher privileges in the system.
 * It extends the User class and implements the UserInterface.
 */
public class Researcher extends User implements UserInterface {
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private String researchArea;
    private ArrayList<Integer> citations;
    private Integer yearsOfExperience;
    private Set<Researcher> collaborators;
    private Set<ResearchProject> projects;
    private Vector<ResearchPaper> papers;
    private UserInterface user;

    private transient Scanner in;

    /**
     * Initializes the Scanner for user input.
     */
    private void initScanner() {
        this.in = new Scanner(System.in);
    }

    /**
     * Default constructor for Researcher.
     */
    public Researcher() {

    }

    /**
     * Constructor for creating a Researcher based on an existing User.
     *
     * @param user The user object to be associated with the researcher.
     * @throws IllegalArgumentException If the user is not a Student or Teacher.
     */
    public Researcher(User user) throws IllegalArgumentException {
        if (user instanceof Student || user instanceof Teacher || user instanceof Employee) {
            this.user = user;
            projects = new HashSet<>();
            papers = new Vector<>();
        } else {
            throw new IllegalArgumentException("Researcher can only be a Student or a Teacher");
        }
    }

    /**
     * Constructor for creating a Researcher with specified email, password, and user type.
     *
     * @param email     The email of the researcher.
     * @param password  The password of the researcher.
     * @param userType  The type of the user (Student or Teacher).
     */
    public Researcher(String email, String password, UserType userType) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    private Vector<String> feedback;

    /**
     * Gets the researcher's name.
     *
     * @return The researcher's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the researcher's name.
     *
     * @param name The researcher's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the researcher's surname.
     *
     * @return The researcher's surname.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Sets the researcher's surname.
     *
     * @param surname The researcher's surname.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the researcher's ID.
     *
     * @return The researcher's ID.
     */
    public String getID() {
        return user.getID();
    }

    /**
     * Gets the researcher's research area.
     *
     * @return The researcher's research area.
     */
    public String getResearchArea() {
        return this.researchArea;
    }

    /**
     * Sets the researcher's research area.
     *
     * @param researchArea The researcher's research area.
     */
    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

    /**
     * Gets the list of citations associated with the researcher.
     *
     * @return The list of citations.
     */
    public ArrayList<Integer> getCitations() {
        return this.citations;
    }

    /**
     * Sets the list of citations associated with the researcher.
     *
     * @param citations The list of citations.
     */
    public void setCitations(ArrayList<Integer> citations) {
        this.citations = citations;
    }

    /**
     * Gets the years of experience of the researcher.
     *
     * @return The years of experience.
     */
    public Integer getYearsOfExperience() {
        return this.yearsOfExperience;
    }

    /**
     * Sets the years of experience of the researcher.
     *
     * @param yearsOfExperience The years of experience.
     */
    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * Gets the set of collaborators associated with the researcher.
     *
     * @return The set of collaborators.
     */
    public Set<Researcher> getCollaborators() {
        return this.collaborators;
    }

    /**
     * Sets the set of collaborators associated with the researcher.
     *
     * @param collaborators The set of collaborators.
     */
    public void setCollaborators(Set<Researcher> collaborators) {
        this.collaborators = collaborators;
    }

    /**
     * Gets the set of projects associated with the researcher.
     *
     * @return The set of projects.
     */
    public Set<ResearchProject> getProjects() {
        return this.projects;
    }

    /**
     * Sets the set of projects associated with the researcher.
     *
     * @param projects The set of projects.
     */
    public void setProjects(Set<ResearchProject> projects) {
        this.projects = projects;
    }

    /**
     * Gets the vector of papers associated with the researcher.
     *
     * @return The vector of papers.
     */
    public Vector<ResearchPaper> getPapers() {
        return this.papers;
    }

    /**
     * Sets the vector of papers associated with the researcher.
     *
     * @param papers The vector of papers.
     */
    public void setPapers(Vector<ResearchPaper> papers) {
        this.papers = papers;
    }

    /**
     * Gets the vector of feedback associated with the researcher.
     *
     * @return The vector of feedback.
     */
    public Vector<String> getFeedback() {
        return this.feedback;
    }

    // Operations

    /**
     * Calculates the H-index of the researcher based on citations.
     *
     * @return The calculated H-index.
     */
    public int calculateHIndex() {
        List<Integer> sortedCitations = citations.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int hIndex = IntStream.range(0, sortedCitations.size())
                .filter(i -> sortedCitations.get(i) <= i + 1)
                .findFirst()
                .orElse(0);

        return hIndex;
    }

    /**
     * Prints the list of papers sorted using the specified comparator.
     *
     * @param comparator The comparator to use for sorting.
     */
    public void printPapers(Comparator<ResearchPaper> comparator) {
        getPapers().stream()
                .sorted(comparator)
                .forEach(paper -> System.out.println(paper.getTitle() + "-" + paper.getAuthor()));
    }

    /**
     * Saves the current state of the researcher to the database.
     *
     * @throws IOException If an I/O error occurs during saving.
     */
    private void save() throws IOException {
        Database.write();
    }

    /**
     * Exits the researcher mode, saving the session before exiting.
     */
    private void exit() {
        System.out.println("Bye bye");
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the researcher's menu options.
     */
    public void displayMenu() {
        System.out.println("--------Researcher's menu-----------");
        System.out.println("====================================");
        System.out.println("*	1) Open paper menu             *");
        System.out.println("*	2) Open project menu           *");
        System.out.println("*	3) Open Journal menu           *");
        System.out.println("*	4) New Research Project        *");
        System.out.println("*	5) Exit                        *");
        System.out.println("====================================");
    }

    /**
     * Runs the researcher's menu and handles user input.
     *
     * @throws IOException If an I/O error occurs during the operation.
     */
    public void run() throws IOException {
        try {
            initScanner();
            System.out.println("1) Enter user mode  2) Enter researcher mode");
            int choice = in.nextInt();
            if (choice == 1) user.run();
            if (choice == 2) Researcherrun();
        } catch (Exception e) {
            System.out.println("Something went wrong... \n Saving session...");
            e.printStackTrace();
            save();
        }
    }

    /**
     * Runs the researcher-specific functionality.
     *
     * @throws IOException If an I/O error occurs during the operation.
     */
    public void Researcherrun() throws IOException {
        try {
            initScanner();
            System.out.println("Welcome!");
            menu:
            while (true) {
                displayMenu();
                int choice = in.nextInt();
                if (choice == 1) {
                    if (!ResearchDatabase.getResearchPapers().isEmpty()) {
                        System.out.println("Enter Research paper title: ");
                        papers.stream().map(n -> n.getTitle()).forEach(System.out::println);
                        String schoice = in.next();
                        ResearchPaper p = (ResearchPaper) papers.stream()
                                .filter(n -> n.getTitle()
                                        .equals(schoice))
                                .findFirst()
                                .orElse(null);
                        ;
                        if (p != null) {
                            while (p.runRPaper()) {
                            }
                        } else {
                            System.out.println("Not found!");
                        }
                    } else {
                        System.out.println("No papers yet");
                    }
                }
                if (choice == 2) {
                    if (!ResearchDatabase.getResearchProjects(this).isEmpty()) {
                        System.out.println("Enter Research project title: ");
                        projects.stream().map(n -> n.getTitle()).forEach(System.out::println);
                        String schoice = in.next();
                        ResearchProject p = projects.stream()
                                .filter(n -> n.getTitle().equals(schoice))
                                .findFirst()
                                .orElse(null);

                        if (p != null) {
                            while (p.runRProject(this)) {
                            }
                        } else {
                            System.out.println("Not found!");
                        }
                    } else {
                        System.out.println("No projects yet");
                    }
                }
                if (choice == 3) {
                    if (!ResearchDatabase.getResearchJournals().isEmpty()) {
                        System.out.println("Enter Research journal name: ");
                        ResearchDatabase.getResearchJournals().stream()
                                .map(n -> n.getJournalName())
                                .forEach(System.out::println);

                        String schoice = in.next();
                        ResearchJournal j = ResearchDatabase.getResearchJournals().stream()
                                .filter(n -> n.getJournalName().equals(schoice))
                                .findFirst()
                                .orElse(null);

                        if (j != null) {
                            while (j.runRJournal(this)) {
                            }
                        } else {
                            System.out.println("Not found!");
                        }
                    } else {
                        System.out.println("No research journals yet");
                    }
                }
                if (choice == 4) {
                    newProject();
                    System.out.println("\n\nReturning back...\n");
                    continue menu;
                }
                if (choice == 5) {
                    exit();
                    break menu;
                }

            }
        } catch (Exception e) {
            System.out.println("Something went wrong...\n Saving session...");
            e.printStackTrace();
            save();
        }


    }
    /**
     * Creates a new research project with user input.
     */
    private void newProject() {
        try {
            initScanner();
            System.out.println("\nEnter new project details:");

            System.out.print("Title: ");
            String projectTitle = in.next();

            System.out.print("Section: ");
            String projectSection = in.nextLine();

            System.out.print("Objectives (comma-separated): ");
            String[] objectivesArray = in.nextLine().split(", ");
            Vector<String> projectObjectives = new Vector<>(Arrays.asList(objectivesArray));

            System.out.print("Enter project stages (comma-separated): ");
            String[] stagesArray = in.nextLine().split(", ");
            Vector<String> projectStages = new Vector<>(Arrays.asList(stagesArray));

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.print("End Date (format: yyyy-MM-dd): ");
            String endDateString = in.nextLine();
            Date projectEndDate = dateFormat.parse(endDateString);

            ResearchProject newProject = new ResearchProject(projectTitle, projectObjectives, projectSection, projectStages, projectEndDate);
            newProject.addResearcher(this);

            ResearchDatabase.addResearchProject(newProject);
            projects.add(newProject);
            System.out.println("New project created successfully!");
        } catch (Exception e) {
            System.out.println("Error creating new project.");
            e.printStackTrace();
        }
    }

    /**
     * Adds a research paper to the researcher's collection.
     *
     * @param p The research paper to add.
     */
    public void addPaper(ResearchPaper p) {
        papers.add(p);
    }
}
