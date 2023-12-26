package manager;


import java.util.Date;
import java.util.List;

import research.Researcher;

public class News extends Manager{         /// uberi extends i izmeni constructor
	private String headline;
	private String topic;
    private Date publicationDate;
    private List<String> comments;
    private Category category;
    
    
    
    news1 = headline -..., topic -...., date, 
    news2
    
    Vector<News> newslist 
    DB
    
    User viewnews
    
    ViewNews() {
    	viewResearNew()
    	viewStudyNew()
    }
    
    ViewREsearcherNEws(){
    	for resar
    }
    
    ViewStudyNews(){
    	for study
    }
    
    ViewNews()
    1. Assylzhan  announced paper
    2. Fuzzy get cited more than 50
    3.Sabak
    
    1. ViewTopCitedR    
    DB.getPAper
    for if cited > 10 syso
    
    2. Sort Researcher News by
    If category == rese
    	
    1. Alphabetically
    2. Date
    3. Cited
    
    1. Comparator c = new DateCompaarot();
    Sort(comparator c)
    
    
    
    public News(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email, String Password,
			int PhoneNumber, double salary, Date hireDate) {
		super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber, salary, hireDate);
		// TODO Auto-generated constructor stub
	}

    public News(String headline2, String topic2, Category category2) {
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
    
    public void addComment(String comment) {
    	comments.add(comment);
    }
    
    Login Manager
    1. ViewInfoAbout Student 2. Assign course   3.Managenews
    
    
    
    
    Login User
    1. ViewNews
    General    pinned top cited researchers 
                      
    
    
    
    
    
}