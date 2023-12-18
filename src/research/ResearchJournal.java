package research;
import java.util.*;

import fromUser.User;

public class ResearchJournal {
	
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
    private Set<User> subscribers;
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
    
    public Set<User> getSubscribers() {
        return this.subscribers;
    }
    
    public void setSubscribers(Set<User> subscribers) {
        this.subscribers = subscribers;
    }
    

    // Operations                                  
    
    public void submitPaper(ResearchPaper paper) {
        this.researchPapers.add(paper);
    }
    
    public void rateJournal1to10(Integer rate) {
        this.journalRateCounter++;
        this.journalRateSum += rate;
    }
    
    public void subscribe(User user) {
        this.subscribers.add(user);
    }
    
    public void unsubscribe(User user) {
        this.subscribers.remove(user);
    }
}
