package research;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import fromUser.Admin;
import fromUser.Database;
import fromUser.User;
import student.Student;
import teacher.Teacher;

public class ResearchPaper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Scanner in = new Scanner(System.in);

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

    public ResearchPaper() {
    	
    }
    
    public ResearchPaper(String title, Researcher author, String annotation, Vector<String> keywords, String section, String content,
			Integer pages, String isbn, String doi) {
		super();
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
		this.feedbacks = new Vector<String>();
	}

	public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
    	return author.getName();
    }

    public Integer getCitations() {
        return this.citations;
    }

    public void setCitations(Integer citations) {
        this.citations = citations;
    }

    public String getAnnotation() {
        return this.annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Vector<String> getKeywords() {
        return this.keywords;
    }

    public void setKeywords(Vector<String> keywords) {
        this.keywords = keywords;
    }

    public String getSection() {
        return this.section;
    }

    public void setSection(String section) {
        this.section = section;
    }

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

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getISBN() {
        return this.isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getDOI() {
        return this.doi;
    }

    public void setDOI(String doi) {
        this.doi = doi;
    }

    public Vector<String> getFeedbacks() {
        return this.feedbacks;
    }
    
	public void setResearcher(Vector<Researcher> researcher) {
		Database.setResearcher(researcher);
	}
	
	public Set<Researcher> getResearcher() {
//		return Database.getResearcher().stream().
//                filter(n->n.getPapers().contains(this))
//                .collect(Collectors.toSet());
		return null;}

	public Set<ResearchJournal> getResearchJournal() {
		return Database.getResearchJournal().stream().
				 filter(n->n.getPublishedPapers().contains(this))
				 .collect(Collectors.toSet());
	}

	public void setResearchJournal(Set<ResearchJournal> researchJournal) {
		Database.setResearchJournal(researchJournal);
	}
	
	
    
    // Operations

    public void getCitation() {
    	System.out.println("Choose format: 1) Plain text  2) Bibtex");
    	int choice = in.nextInt();
        if (choice==1) {
        	citations++;
            System.out.println(getAuthor() + ", " + getTitle() + ", " + getSection() + ", " + getDate().getYear());;
        } else if (choice==2) {
            citations++;
        	System.out.println("@article{author = {" + getAuthor() + "}, title = {" + getTitle() + "}, section = {" + 
                               getSection() +"}, year = {" + getDate().getYear() + "}}");
        }    
    }

    public void searchRelatedPapers() {
        ResearchDatabase.getResearchPapers().stream().
        		filter(paper -> paper.getKeywords().stream().anyMatch(this.keywords::contains))
        		.map(n->n.getTitle())
                .forEach(System.out::println);;
    }

    public void writeFeedback() {
    	System.out.println("Enter feedback: ");
    	String fb = in.next();
        this.feedbacks.add(fb);
        System.out.println("Feedback added!");
    }

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
	
    
    
    
    
	private void save() throws IOException {
		Database.write();
	}
	private void exit() {
		System.out.println("Bye bye");
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean runRPaper() throws IOException {
		try {
			System.out.println("Welcome to Research Paper Menu!");
			menu: while(true) {
				System.out.println("What do you want to do?\n1) Read this paper  2) Get citation  3) Search related papers  4) Write feedback  5) Exit RPaperMenu");
				int choice = in.nextInt();
				read: if(choice==1) {
					readPaper(this);
					System.out.println("\n1) Get citation  2) Search related papers  4) Write feedback  5) Return back");
					choice = in.nextInt();
					if(choice==1) {
						choice = 2;
						break read;
					}
				}
				if(choice==2) {
					getCitation();
					System.out.println("\nReturning back...\n\n");
					continue menu;
				}if(choice==3) {
					searchRelatedPapers();
					System.out.println("\nReturning back...\n\n");
					continue menu;
				}if(choice==4) {
					writeFeedback();
					System.out.println("\nReturning back...\n\n");
					continue menu;
				}if(choice==5) {
					return false;
				}
			}
		} catch(Exception e) {
			System.out.println("Something went wrong... \n Saving session...");
			e.printStackTrace();
			save();
		}
		return true;
	}
	
	
	
}