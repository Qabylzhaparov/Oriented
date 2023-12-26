package research;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import fromUser.Database;

/**
 * The ResearchJournal class represents a research journal in the system.
 * It contains information about the journal, such as its name, editors, section, published papers,
 * subscribers, and average rating.
 */
public class ResearchJournal implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient Scanner in;

    private String journalName;
    private Vector<Researcher> editors = new Vector<Researcher>();
    private String journalSection;
    private Vector<ResearchPaper> publishedPapers = new Vector<ResearchPaper>();
    private Set<Researcher> subscribers = new HashSet<>();
    private Double journalRateSum = 0.0;
    private Integer journalRateCounter = 0;

    /**
     * Default constructor for ResearchJournal.
     */
    public ResearchJournal() {
    }

    /**
     * Constructor for creating a ResearchJournal with a specified name.
     *
     * @param journalName The name of the journal.
     */
    public ResearchJournal(String journalName) {
        this.journalName = journalName;
    }

    /**
     * Constructor for creating a ResearchJournal with a specified name and section.
     *
     * @param journalName   The name of the journal.
     * @param journalSection The section of the journal.
     */
    public ResearchJournal(String journalName, String journalSection) {
        this.journalName = journalName;
        this.journalSection = journalSection;
    }

    /**
     * Gets the name of the journal.
     *
     * @return The name of the journal.
     */
    public String getJournalName() {
        return this.journalName;
    }

    /**
     * Sets the name of the journal.
     *
     * @param journalName The name to set.
     */
    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    /**
     * Gets the editors of the journal.
     *
     * @return The editors of the journal.
     */
    public Vector<Researcher> getEditors() {
        return this.editors;
    }

    /**
     * Sets the editors of the journal.
     *
     * @param editors The editors to set.
     */
    public void setEditors(Vector<Researcher> editors) {
        this.editors = editors;
    }

    /**
     * Adds an editor to the journal.
     *
     * @param researcher The researcher to add as an editor.
     */
    public void addEditor(Researcher researcher) {
        this.editors.add(researcher);
    }

    /**
     * Gets the section of the journal.
     *
     * @return The section of the journal.
     */
    public String getJournalSection() {
        return this.journalSection;
    }

    /**
     * Sets the section of the journal.
     *
     * @param journalSection The section to set.
     */
    public void setJournalSection(String journalSection) {
        this.journalSection = journalSection;
    }

    /**
     * Gets the average rating of the journal.
     *
     * @return The average rating of the journal.
     */
    public Double getJournalRate() {
        return journalRateSum / journalRateCounter;
    }

    /**
     * Gets the published papers in the journal.
     *
     * @return The published papers in the journal.
     */
    public Vector<ResearchPaper> getPublishedPapers() {
        return this.publishedPapers;
    }

    /**
     * Sets the published papers in the journal.
     *
     * @param publishedPapers The published papers to set.
     */
    public void setPublishedPapers(Vector<ResearchPaper> publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    /**
     * Gets the subscribers of the journal.
     *
     * @return The subscribers of the journal.
     */
    public Set<Researcher> getSubscribers() {
        return this.subscribers;
    }

    /**
     * Sets the subscribers of the journal.
     *
     * @param subscribers The subscribers to set.
     */
    public void setSubscribers(Set<Researcher> subscribers) {
        this.subscribers = subscribers;
    }

    /**
     * Initializes the Scanner for user input.
     */
    private void initScanner() {
        this.in = new Scanner(System.in);
    }

    /**
     * Saves the current state of the journal to the database.
     *
     * @throws IOException If an I/O error occurs during saving.
     */
    private void save() throws IOException {
        Database.write();
    }

    /**
     * Exits the journal mode, saving the session before exiting.
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
     * Displays the options for the researcher's menu.
     */
    public void displayMenu() {
        System.out.println("--------Journal Menu-----------");
        System.out.println("===============================");
        System.out.println("*	1) View Journal             *");
        System.out.println("*	2) Subscribe/Unsubscribe    *");
        System.out.println("*	3) Rate                     *");
        System.out.println("*	4) Exit Journal Menu        *");
        System.out.println("===============================");
    }

    /**
     * Runs the researcher's menu and handles user input.
     *
     * @param r The researcher using the journal menu.
     * @throws IOException If an I/O error occurs during the operation.
     */
    public boolean runRJournal(Researcher r) throws IOException {
        try {
            initScanner();
            System.out.println("Welcome to the Research Journal Menu!");
            menu: while (true) {
                displayMenu();
                int choice = in.nextInt();
                if (choice == 1) {
                    viewInfo(this);
                }
                if (choice == 2) {
                    un_subscribe(r);
                }
                if (choice == 3) {
                    rateJournal1to10();
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
     * Displays information about the research journal.
     *
     * @param journal The research journal to display information about.
     */
    public void viewInfo(ResearchJournal journal) {
        System.out.println("Journal Name: " + journal.getJournalName());
        System.out.println("Journal Section: " + journal.getJournalSection());
        System.out.println("Editors:");
        for (Researcher editor : journal.getEditors()) {
            System.out.println("- " + editor.getName() + " " + editor.getSurname());
        }
        System.out.println("Average Journal Rating: " + journal.getJournalRate());

        System.out.println("Published Papers:");
        for (ResearchPaper paper : journal.getPublishedPapers()) {
            System.out.println("- Title: " + paper.getTitle() + ", Authors: " +
                    paper.getAuthor());
        }
    }

    /**
     * Allows a researcher to subscribe or unsubscribe from the journal.
     *
     * @param researcher The researcher subscribing or unsubscribing.
     */
    public void un_subscribe(Researcher researcher) {
        if (this.subscribers.contains(researcher)) {
            this.subscribers.remove(researcher);
            System.out.println("Unsubscribed from the journal.");
        } else {
            this.subscribers.add(researcher);
            System.out.println("Subscribed to the journal.");
        }
    }

    /**
     * Allows a researcher to rate the journal on a scale of 1 to 10.
     */
    public void rateJournal1to10() {
        System.out.println("Rate from 1 to 10: ");
        int rate = in.nextInt();
        if (rate > 0 && rate <= 10) {
            this.journalRateCounter++;
            this.journalRateSum += rate;
            System.out.println("Thanks for rating!");
        } else {
            System.out.println("Wrong rate type!");
        }
    }
}
