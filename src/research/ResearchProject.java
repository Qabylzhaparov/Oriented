package research;
import java.io.IOException;
import java.io.EOFException;
import java.io.Serializable;
import java.util.*;


public class ResearchProject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    protected transient Scanner in = new Scanner(System.in);
	
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
    
    public ResearchProject() {
    	
    }
    
    public ResearchProject(String title, Vector<String> objectives, String section,
			Vector<String> stages, Date endDate) {
		super();
		this.title = title;
		this.objectives = objectives;
		this.section = section;
		this.stages = stages;
		this.startDate = new Date();
		this.endDate = endDate;
		this.review = "no review";
	}

	public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Vector<String> getObjectives() {
        return this.objectives;
    }
    
    public void setObjectives(Vector<String> objectives) {
        this.objectives = objectives;
    }
    
    public Vector<Researcher> getParticipants() {
        return this.participants;
    }
    
    public void setParticipants(Vector<Researcher> participants) {
        this.participants = participants;
    }
    
    public String getSection() {
        return this.section;
    }
    
    public void setSection(String section) {
        this.section = section;
    }
    
    public Vector<String> getStages() {
        return this.stages;
    }
    
    public void setStages(Vector<String> stages) {
       this.stages = stages;
    }
    
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public String getReview() {
    	StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.review.length(); i++) {
            result.append(review.charAt(i));
            if (i != 0 &&i % 50 == 0) {
                result.append("\n");
            }
        }
        return result.toString();    
    }
    
    public void setReview() {
    	System.out.print("Enter review: ");
    	String review = in.next();
        this.review = review;
    }
    

    // Operations 
    


    private void save() throws IOException{
    	ResearchDatabase.write();
    }
    
    private void exit() {
    	System.out.println("Session ended.");
    	try {
    		save();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void initScanner() {
    	this.in = new Scanner(System.in);
    }
    
    public boolean runRProject() throws IOException, EOFException{
    	try {
    		System.out.println("\nWelcome Research Project Menu!");
    		initScanner();
    		menu: while(true) {
    			System.out.println("What do you want to do?\n1) View projects  2) Add researcher  3) Publish project  4) Exit RPaperMenu");
    			int choice = in.nextInt();
    			if(choice==1) {
    				viewProject();
    				System.out.println("\n1) Enter review  2) Return back");
    				choice = in.nextInt();
    				if(choice==1) setReview();
    				if(choice==2) continue menu;
    			}
    			if(choice==2) {
    				addResearcher();
    				System.out.println("1) Return back");
    				choice = in.nextInt();
    				continue menu;
    			}
    			if(choice==3) {
    				submitProject();
    				System.out.println("1) Return back");
    				choice = in.nextInt();
    				continue menu;
    			}
    			if(choice==4) {
    				return false;
    			}
    		}
    	} catch(Exception e) {
			System.out.println("Something went wrong... \n Saving session...");
			e.printStackTrace();
			save();
		} finally {
			if(in!= null) in.close();
		}
    	return true;
    }


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
        for (String stage:stages) {
        	System.out.println("    - " + stage);
        }
        
        System.out.println("REVIEW: " + getReview());
    }

    public void addResearcher() {
    	if(!ResearchDatabase.INSTANCE.researchers.isEmpty()) {
    		System.out.println("Choose researcher: ");
        	for(Researcher r: ResearchDatabase.INSTANCE.researchers) {
        		System.out.println(r.getID() + "  " + r.getName() + "  " + r.getSurname());
        	}
        	String choice = in.next();
        	Researcher r = (Researcher) ResearchDatabase.INSTANCE.researchers.stream().
        									filter(n->n.getID().
        									equals(choice));
        	if(r!=null) {
        		participants.add(r);
        		System.out.println("Researcher " + r.getID() + " added!");        		
        	} else {
        		System.out.println("Not found such researcher");
        	}
    	} else {
    		System.out.println("There is no researchers");
    	}
    	
    }
    
    public void submitProject() {
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

        ResearchPaper newPaper = new ResearchPaper(paperTitle, paperAnnotation, paperKeywords, paperSection,
                paperContent, paperPages, paperISBN, paperDOI);

        System.out.println("\nResearch paper created!");
        ResearchDatabase.INSTANCE.papers.add(newPaper);

    }

	public void addResearcher(Researcher researcher) {
		participants.add(researcher);
	}


    
    

}
