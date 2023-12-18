package manager;


import java.util.Date;
import java.util.List;

import research.Researcher;

public class News extends Manager{         /// uberi extends i izmeni constructor
	private String headline;
	private String topic;
    private Date publicationDate;
    private List<String> content;
    private List<String> pinned;
    private List<String> comments;
    private List<Researcher> topCitedResearchers;
    private Category category;
    
    public News(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email, String Password,
			int PhoneNumber, double salary, Date hireDate) {
		super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber, salary, hireDate);
		// TODO Auto-generated constructor stub
	}

    public void generateTopCitedNews(Category category) {
        if (category == Category.SCIENCE) {
            
            System.out.println("Top Cited News generated for the Science category.");
        } else {
            System.out.println("Top Cited News generation is not supported for this category.");
        }
    }

    public boolean isAnnouncement() {       
        
        return false;
    }

    public void generateAnnouncement() {
       
        System.out.println("Announcement generated.");
    }

    public void viewOnlyResearch() {
        
        System.out.println("Viewing only research news.");
    }

    public void prioritizeAsTopCited() {
        
        System.out.println("News prioritized as the 1st place in top cited.");
    }
}