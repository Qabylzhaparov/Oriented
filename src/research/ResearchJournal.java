package research;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import fromUser.Database;
import fromUser.User;

public class ResearchJournal {
	Scanner in = new Scanner(System.in);
	public ResearchJournal() {}
	
	public ResearchJournal(String journalName) {
		this.journalName = journalName;
	}
	
	public ResearchJournal(String journalName, String journalSection) {
		this.journalName = journalName;
		this.journalSection = journalSection;
	}
    
    private String journalName;
    private Vector<Researcher> editors;
    private String journalSection;
    private Vector<ResearchPaper> publishedPapers;
    private Set<Researcher> subscribers;
    private Vector<ResearchPaper> researchPapers;
    private Double journalRateSum = 0.0;
    private Integer journalRateCounter = 0;
    
    public String getJournalName() {
        return this.journalName;
    }
    
    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }
    
    public Vector<Researcher> getEditors() {
        return this.editors;
    }
    
    public void setEditors(Vector<Researcher> editors) {
        this.editors = editors;
    }
    
    public String getJournalSection() {
        return this.journalSection;
    }
    
    public void setJournalSection(String journalSection) {
        this.journalSection = journalSection;
    }
    
    public Double getJournalRate() {
        return journalRateSum / journalRateCounter;
    }
    
    public Vector<ResearchPaper> getPublishedPapers() {
        return this.publishedPapers;
    }
    
    public void setPublishedPapers(Vector<ResearchPaper> publishedPapers) {
        this.publishedPapers = publishedPapers;
    }
    
    public Set<Researcher> getSubscribers() {
        return this.subscribers;
    }
    
    public void setSubscribers(Set<Researcher> subscribers) {
        this.subscribers = subscribers;
    }
    

    // Operations                                  
    
    public void submitPaper(Researcher res) {
        if(editors.contains(res)) {
        	System.out.println("Choose Research Paper title: ");
        	Database.getResearchPapers().stream().
							        	map(n->n.getTitle()).
							        	forEach(System.out::println);
        	String choice = in.nextLine();
        	ResearchPaper paper = Database.getResearchPapers(choice);
        	if(paper!=null) {
        		researchPapers.add(paper);
            	System.out.println("Research paper added!");
        	} else {
        		System.out.println("Research paper not found!");
        	}
        	
        } else {
        	System.out.println("You are not editor!");
        }
    }
    
    public void rateJournal1to10() {
    	System.out.println("Rate from 1 to 10: ");
    	int rate = in.nextInt();
    	if(rate > 0 && rate <= 10) {
            this.journalRateCounter++;
            this.journalRateSum += rate;
            System.out.println("Thanks for rating!");
    	}else {
    		System.out.println("Wrong rate type!");
    	}
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
	
	public boolean runRPaper(ResearchJournal j, Researcher r) throws IOException {
		try {
			System.out.println("Welcome to Research Paper Menu!");
			menu: while(true) {
				System.out.println("What do you want to do?\n1) View Journal  2) Subscribe/Unsubscribe  3) Rate  4) Submit paper  5) Exit Journal Menu  6)Exit");
				int choice = in.nextInt();
				if(choice==1) {
					viewInfo(j);
				}
				if(choice==2) {
					un_subscribe(r);
				}
				if(choice==3) {
					rateJournal1to10();
				}
				if(choice==4) {
					submitPaper(r);
				}
				if(choice==5) {
					return true;
				}
				if(choice==6) {
					exit(); break menu;
				}
				
			}
		} catch(Exception e) {
			System.out.println("Something went wrong... \n Saving session...");
			e.printStackTrace();
			save();
		}
		return false;
	}

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
	                paper.getAuthor().stream().map(Researcher::getName).collect(Collectors.joining(", ")));
	    }
	}
	
	public void un_subscribe(Researcher researcher) {
	    if (this.subscribers.contains(researcher)) {
	        this.subscribers.remove(researcher);
	        System.out.println("Unsubscribed from the journal.");
	    } else {
	        this.subscribers.add(researcher);
	        System.out.println("Subscribed to the journal.");
	    }
	}
    

}
