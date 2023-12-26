package research;

import java.io.IOException;
import java.io.EOFException;
import java.io.Serializable;
import java.util.*;

/**
 * The ResearchProject class represents a research project in the system.
 * It implements the Serializable interface to support serialization.
 */
public class ResearchProject implements Serializable {
    private static final long serialVersionUID = 1L;

    Scanner in = new Scanner(System.in);

    private String title;
    private Vector<String> objectives;
    private Vector<Researcher> participants;
    private String section;
    private Vector<String> stages;
    private Date startDate;
    private Date endDate;
    private String review;

    {
        participants = new Vector<>();
    }

    /**
     * Default constructor for ResearchProject.
     */
    public ResearchProject() {

    }

    /**
     * Parameterized constructor for creating a ResearchProject with specified details.
     *
     * @param title      The title of the research project.
     * @param objectives The objectives of the research project.
     * @param section    The section of the research project.
     * @param stages     The stages of the research project.
     * @param endDate    The end date of the research project.
     */
    public ResearchProject(String title, Vector<String> objectives, String section,
                            Vector<String> stages, Date endDate) {
        this.title = title;
        this.objectives = objectives;
        this.section = section;
        this.stages = stages;
        this.startDate = new Date();
        this.endDate = endDate;
        this.review = "no review";
    }

    /**
     * Gets the title of the research project.
     *
     * @return The title of the research project.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the research project.
     *
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the objectives of the research project.
     *
     * @return The objectives of the research project.
     */
    public Vector<String> getObjectives() {
        return this.objectives;
    }

    /**
     * Sets the objectives of the research project.
     *
     * @param objectives The objectives to set.
     */
    public void setObjectives(Vector<String> objectives) {
        this.objectives = objectives;
    }

    /**
     * Gets the participants of the research project.
     *
     * @return The participants of the research project.
     */
    public Vector<Researcher> getParticipants() {
        return this.participants;
    }

    /**
     * Sets the participants of the research project.
     *
     * @param participants The participants to set.
     */
    public void setParticipants(Vector<Researcher> participants) {
        this.participants = participants;
    }

    /**
     * Gets the section of the research project.
     *
     * @return The section of the research project.
     */
    public String getSection() {
        return this.section;
    }

    /**
     * Sets the section of the research project.
     *
     * @param section The section to set.
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * Gets the stages of the research project.
     *
     * @return The stages of the research project.
     */
    public Vector<String> getStages() {
        return this.stages;
    }

    /**
     * Sets the stages of the research project.
     *
     * @param stages The stages to set.
     */
    public void setStages(Vector<String> stages) {
        this.stages = stages;
    }

    /**
     * Gets the start date of the research project.
     *
     * @return The start date of the research project.
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Sets the start date of the research project.
     *
     * @param startDate The start date to set.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date of the research project.
     *
     * @return The end date of the research project.
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * Sets the end date of the research project.
     *
     * @param endDate The end date to set.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the review of the research project.
     *
     * @return The review of the research project.
     */
    public String getReview() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.review.length(); i++) {
            result.append(review.charAt(i));
            if (i != 0 && i % 50 == 0) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * Sets the review of the research project.
     */
    public void setReview() {
        System.out.print("Enter review: ");
        String review = in.next();
        this.review = review;
    }

    /**
     * Saves the current state of the research project to the database.
     *
     * @throws IOException If an I/O error occurs during saving.
     */
    private void save() throws IOException {
        ResearchDatabase.write();
    }

    /**
     * Exits the research project menu, saving the session before exiting.
     */
    private void exit() {
        System.out.println("Session ended.");
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the research project menu and handles user input.
     *
     * @param r The associated researcher.
     * @return True if the operation is successful, false otherwise.
     * @throws IOException    If an I/O error occurs during the operation.
     * @throws EOFException   If an EOF error occurs during the operation.
     */
    public boolean runRProject(Researcher r) throws IOException, EOFException {
        try {
            System.out.println("\nWelcome Research Project Menu!");
            menu:
            while (true) {
                System.out.println("What do you want to do?\n1) View projects  2) Add researcher  3) Publish project  4) Exit RPaperMenu");
                int choice = in.nextInt();
                if (choice == 1) {
                    viewProject();
                    System.out.println("\n1) Enter review  2) Return back");
                    choice = in.nextInt();
                    if (choice == 1) setReview();
                    if (choice == 2) continue menu;
                }
                if (choice == 2) {
                    addResearcher();
                    System.out.println("1) Return back");
                    choice = in.nextInt();
                    continue menu;
                }
                if (choice == 3) {
                    submitProject(r);
                    System.out.println("1) Return back");
                    choice = in.nextInt();
                    continue menu;
                }
                if (choice == 4) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong... \n Saving session...");
            e.printStackTrace();
            save();
        }
        return true;
    }

    /**
     * Displays the details of the research project.
     */
    private void viewProject() {
        System.out.println("PROJECT TITLE: " + this.title);
        System.out.println("SECTION: " + this.section);
        System.out.println("START DATE: " + this.startDate);
        System.out.println("END DATE: " + this.endDate);
        System.out.println("OBJECTIVES:");
        for (String objective : this.objectives) {
            System.out.println("   - " + objective);
        }
        System.out.println("PARTICIPANTS:");
        for (Researcher participant : this.participants) {
            System.out.println("    - " + participant.getName() + " " + participant.getSurname());
        }
        System.out.println("STAGES:");
        for (String stage : stages) {
            System.out.println("    - " + stage);
        }

        System.out.println("REVIEW: " + getReview());
    }

    /**
     * Adds a researcher to the participants of the research project.
     */
    public void addResearcher() {
        if (!ResearchDatabase.getResearchers().isEmpty()) {
            System.out.println("Choose researcher: ");
            for (Researcher r : ResearchDatabase.getResearchers()) {
                System.out.println(r.getID() + "  " + r.getName() + "  " + r.getSurname());
            }
            String choice = in.next();
            Researcher r = ResearchDatabase.getResearcher(choice);
            if (r != null) {
                participants.add(r);
                System.out.println("Researcher " + r.getID() + " added!");
            } else {
                System.out.println("Not found such researcher");
            }
        } else {
            System.out.println("There is no researchers");
        }

    }

    /**
     * Submits the research project by creating a new research paper associated with it.
     *
     * @param r The associated researcher.
     */
    public void submitProject(Researcher r) {
        System.out.println("Enter Research Paper details:");

        System.out.print("Title: ");
        String paperTitle = in.next();

        System.out.print("Annotation: ");
        String paperAnnotation = in.next();

        System.out.print("Keywords (comma-separated): ");
        String[] keywordsArray = in.nextLine().split(",");
        Vector<String> paperKeywords = new Vector<>(Arrays.asList(keywordsArray));

        System.out.print("Section: ");
        String paperSection = in.next();

        System.out.print("Content: ");
        String paperContent = in.next();

        System.out.print("Number of Pages: ");
        int paperPages = in.nextInt();
        in.nextLine(); // consume the newline character

        System.out.print("ISBN: ");
        String paperISBN = in.next();

        System.out.print("DOI: ");
        String paperDOI = in.next();

        ResearchPaper newPaper = new ResearchPaper(paperTitle, r, paperAnnotation, paperKeywords, paperSection,
                paperContent, paperPages, paperISBN, paperDOI);

        System.out.println("\nResearch paper created!");
        ResearchDatabase.addResearchPaper(newPaper);
        r.addPaper(newPaper);

    }

    /**
     * Adds a researcher to the participants of the research project.
     *
     * @param researcher The researcher to add.
     */
    public void addResearcher(Researcher researcher) {
        participants.add(researcher);
    }
}
