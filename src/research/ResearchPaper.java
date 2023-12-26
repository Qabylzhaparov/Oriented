package research;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

import fromUser.Database;

/**
 * The ResearchPaper class represents a research paper in the system.
 * It contains information about the paper, such as title, author, citations, annotation, keywords, section, content,
 * date, pages, ISBN, DOI, and feedback.
 */
public class ResearchPaper implements Serializable {
    private static final long serialVersionUID = 1L;

    private Scanner in = new Scanner(System.in);

    private String title;
    private Researcher author;
    private Integer citations;
    private String annotation;
    private Vector<String> keywords;
    private String section;
    private String content;
    private Date date;
    private Integer pages;
    private String isbn;
    private String doi;

    private transient Vector<String> feedbacks;

    /**
     * Default constructor for ResearchPaper.
     */
    public ResearchPaper() {
    }

    /**
     * Constructor for creating a ResearchPaper with specified attributes.
     *
     * @param title       The title of the paper.
     * @param author      The author of the paper.
     * @param annotation  The annotation of the paper.
     * @param keywords    The keywords associated with the paper.
     * @param section     The section to which the paper belongs.
     * @param content     The content of the paper.
     * @param pages       The number of pages in the paper.
     * @param isbn        The ISBN of the paper.
     * @param doi         The DOI of the paper.
     */
    public ResearchPaper(String title, Researcher author, String annotation, Vector<String> keywords, String section,
                         String content, Integer pages, String isbn, String doi) {
        this.title = title;
        this.author = author;
        this.citations = 0;
        this.annotation = annotation;
        this.keywords = keywords;
        this.section = section;
        this.content = content;
        this.date = new Date();
        this.pages = pages;
        this.isbn = isbn;
        this.doi = doi;
        this.feedbacks = new Vector<>();
    }

    /**
     * Gets the title of the paper.
     *
     * @return The title of the paper.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the paper.
     *
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the paper.
     *
     * @return The author of the paper.
     */
    public String getAuthor() {
        return author.getName();
    }

    /**
     * Gets the number of citations for the paper.
     *
     * @return The number of citations.
     */
    public Integer getCitations() {
        return this.citations;
    }

    /**
     * Sets the number of citations for the paper.
     *
     * @param citations The number of citations to set.
     */
    public void setCitations(Integer citations) {
        this.citations = citations;
    }

    /**
     * Gets the annotation of the paper.
     *
     * @return The annotation of the paper.
     */
    public String getAnnotation() {
        return this.annotation;
    }

    /**
     * Sets the annotation of the paper.
     *
     * @param annotation The annotation to set.
     */
    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    /**
     * Gets the keywords associated with the paper.
     *
     * @return The keywords associated with the paper.
     */
    public Vector<String> getKeywords() {
        return this.keywords;
    }

    /**
     * Sets the keywords associated with the paper.
     *
     * @param keywords The keywords to set.
     */
    public void setKeywords(Vector<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Gets the section to which the paper belongs.
     *
     * @return The section of the paper.
     */
    public String getSection() {
        return this.section;
    }

    /**
     * Sets the section to which the paper belongs.
     *
     * @param section The section to set.
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * Gets the content of the paper.
     *
     * @return The content of the paper.
     */
    public String getContent() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.content.length(); i++) {
            result.append(content.charAt(i));
            if (i > 49 && i % 50 == 0) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * Sets the content of the paper.
     *
     * @param content The content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the date of the paper.
     *
     * @return The date of the paper.
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Sets the date of the paper.
     *
     * @param date The date to set.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the number of pages in the paper.
     *
     * @return The number of pages.
     */
    public Integer getPages() {
        return this.pages;
    }

    /**
     * Sets the number of pages in the paper.
     *
     * @param pages The number of pages to set.
     */
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     * Gets the ISBN of the paper.
     *
     * @return The ISBN of the paper.
     */
    public String getISBN() {
        return this.isbn;
    }

    /**
     * Sets the ISBN of the paper.
     *
     * @param isbn The ISBN to set.
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the DOI of the paper.
     *
     * @return The DOI of the paper.
     */
    public String getDOI() {
        return this.doi;
    }

    /**
     * Sets the DOI of the paper.
     *
     * @param doi The DOI to set.
     */
    public void setDOI(String doi) {
        this.doi = doi;
    }

    /**
     * Gets the feedbacks received for the paper.
     *
     * @return The feedbacks received for the paper.
     */
    public Vector<String> getFeedbacks() {
        return this.feedbacks;
    }

    /**
     * Sets the feedbacks received for the paper.
     *
     * @param feedbacks The feedbacks to set.
     */
    public void setFeedbacks(Vector<String> feedbacks) {
        this.feedbacks = feedbacks;
    }

    /**
     * Sets the list of researchers associated with the paper.
     *
     * @param researcher The list of researchers to set.
     */
    public void setResearcher(Vector<Researcher> researcher) {
        Database.setResearcher(researcher);
    }

    /**
     * Gets the set of researchers associated with the paper.
     *
     * @return The set of researchers associated with the paper.
     */
    public Set<Researcher> getResearcher() {
        return ResearchDatabase.getResearchers().stream()
                .filter(n -> n.getPapers().contains(this))
                .collect(Collectors.toSet());
    }

    /**
     * Gets the set of research journals associated with the paper.
     *
     * @return The set of research journals associated with the paper.
     */
    public Set<ResearchJournal> getResearchJournal() {
        return ResearchDatabase.getResearchJournals().stream()
                .filter(n -> n.getPublishedPapers().contains(this))
                .collect(Collectors.toSet());
    }

    /**
     * Sets the set of research journals associated with the paper.
     *
     * @param researchJournal The set of research journals to set.
     */
    public void setResearchJournal(Set<ResearchJournal> researchJournal) {
        Database.setResearchJournal(researchJournal);
    }

    /**
     * Gets the citation information for the paper.
     */
    public void getCitation() {
        System.out.println("Choose format: 1) Plain text  2) Bibtex");
        int choice = in.nextInt();
        if (choice == 1) {
            citations++;
            System.out.println(getAuthor() + ", " + getTitle() + ", " + getSection() + ", " + getDate().getYear());
            ;
        } else if (choice == 2) {
            citations++;
            System.out.println("@article{author = {" + getAuthor() + "}, title = {" + getTitle() + "}, section = {" +
                    getSection() + "}, year = {" + getDate().getYear() + "}}");
        }
    }

    /**
     * Searches for related papers based on keywords and prints their titles.
     */
    public void searchRelatedPapers() {
        ResearchDatabase.getResearchPapers().stream()
                .filter(paper -> paper.getKeywords().stream().anyMatch(this.keywords::contains))
                .map(n -> n.getTitle())
                .forEach(System.out::println);
    }

    /**
     * Allows the user to write feedback for the paper.
     */
    public void writeFeedback() {
        System.out.println("Enter feedback: ");
        String fb = in.next();
        this.feedbacks.add(fb);
        System.out.println("Feedback added!");
    }

    /**
     * Reads and displays information about the paper.
     *
     * @param paper The paper to be read.
     */
    private void readPaper(ResearchPaper paper) {
        System.out.println("Title: " + paper.getTitle());
        System.out.println("Authors: " + paper.getAuthor());
        System.out.println("Section: " + paper.getSection());
        System.out.println("Date: " + paper.getDate());
        System.out.println("Pages: " + paper.getPages());
        System.out.println("Content: " + paper.getContent());
        System.out.println("Keywords: " + paper.getKeywords().stream().collect(Collectors.joining(", ")));
        System.out.println("ISBN: " + paper.getISBN());
        System.out.println("DOI: " + paper.getDOI());
    }

    /**
     * Saves the current state of the database.
     *
     * @throws IOException If an I/O error occurs.
     */
    private void save() throws IOException {
        Database.write();
    }

    /**
     * Exits the Research Paper menu and saves the session.
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
     * Runs the Research Paper menu for the user.
     *
     * @return True if the menu should continue running, false otherwise.
     * @throws IOException If an I/O error occurs.
     */
    public boolean runRPaper() throws IOException {
        try {
            System.out.println("Welcome to Research Paper Menu!");
            menu:
            while (true) {
                System.out.println("What do you want to do?\n1) Read this paper  2) Get citation  3) " +
                        "Search related papers  4) Write feedback  5) Exit RPaperMenu");
                int choice = in.nextInt();
                if (choice == 1) {
                    readPaper(this);
                    System.out.println("\n1) Get citation  2) Search related papers  " +
                            "4) Write feedback  5) Return back");
                    choice = in.nextInt();
                    if (choice == 1) {
                        choice = 2;
                        break menu;
                    }
                }
                if (choice == 2) {
                    getCitation();
                    System.out.println("\nReturning back...\n\n");
                    continue menu;
                }
                if (choice == 3) {
                    searchRelatedPapers();
                    System.out.println("\nReturning back...\n\n");
                    continue menu;
                }
                if (choice == 4) {
                    writeFeedback();
                    System.out.println("\nReturning back...\n\n");
                    continue menu;
                }
                if (choice == 5) {
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
}
