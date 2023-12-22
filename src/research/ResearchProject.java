package research;
import java.io.IOException;
import java.util.*;

import fromUser.Database;

public class ResearchProject {
    Scanner in = new Scanner(System.in);
	
    private String title;
    private boolean isFinished = false;
    private Vector<String> objectives;
    private Vector<Researcher> participants;
    private String section;
    private Map<String, Boolean> stages;
    private Date startDate;
    private Date endDate;
    private String review;
    
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
    
    public Map<String, Boolean> getStages() {
        return this.stages;
    }
    
    public void setStages(Vector<String> stages) {
        Map<String, Boolean> map = new HashMap<>();
        for(String stage : stages) {
            map.put(stage, false);
        }
        this.stages = map;
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
            if (i % 50 == 0) {
                result.append("\n");
            }
        }
        return result.toString();    
    }
    
    public void setReview(String review) {
        this.review = review;
    }
    

    // Operations 
    

    
    public boolean isFinished() {
        return isFinished;
    }
    
    

    
    
    
    
    
    
    
    

    private void save() throws IOException{
    	Database.write();
    }
    
    private void exit() {
    	System.out.println("Session ended.");
    	try {
    		save();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    
    public boolean runRProject(ResearchProject project) throws IOException{
    	try {
    		System.out.println("Welcome!");
    		menu: while(true) {
    			System.out.println("What do you want to do?\n 1) View project  2) Add researcher  3) Publish project  4) Exit RPaperMenu  5) Exit");
    			int choice = in.nextInt();
    			if(choice==1) {
    				viewProject();
    				System.out.println("1) Return back");
    				choice = in.nextInt();
    				continue menu;
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
    				return true;
    			}
    			if(choice==5) {
    				exit();
    				break menu;
    			}
    		}
    	} catch(Exception e) {
			System.out.println("Something went wrong... \n Saving session...");
			e.printStackTrace();
			save();
		}
    	return false;
    }

    private void viewProject() {
        System.out.println("Project Title: " + this.title);
        System.out.println("Section: " + this.section);
        System.out.println("Start Date: " + this.startDate);
        System.out.println("End Date: " + this.endDate);
        System.out.println("Project Objectives:");
        for (String objective : this.objectives) {
            System.out.println("- " + objective);
        }
        System.out.println("Participants:");
        for (Researcher participant : this.participants) {
            System.out.println("- " + participant.getName() + " " + participant.getSurname());
        }
        System.out.println("Project Stages:");
        for (Map.Entry<String, Boolean> entry : this.stages.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + (entry.getValue() ? "Completed" : "Not Completed"));
        }
        System.out.println("Review: " + getReview());
        System.out.println("Status: " + (this.isFinished ? "Finished" : "Not Finished"));
    }

    public void addResearcher() {
    	System.out.println("Choose researcher: ");
    	for(Researcher r: Database.getResearcher()) {
    		System.out.println(r.getId() + "  " + r.getName() + "  " + r.getSurname());
    	}
    	int choice = in.nextInt();
    	Researcher r = Database.getResearcher(choice);
    	participants.add(r);
    	System.out.println("Researcher " + r.getId() + " added!");
    }
    
    public void submitProject() {
        System.out.println("Enter Research Paper details:");

        System.out.print("Title: ");
        String paperTitle = in.nextLine();

        System.out.print("Annotation: ");
        String paperAnnotation = in.nextLine();

        System.out.print("Keywords (comma-separated): ");
        String[] keywordsArray = in.nextLine().split(",");
        Vector<String> paperKeywords = new Vector<>(Arrays.asList(keywordsArray));

        System.out.print("Section: ");
        String paperSection = in.nextLine();

        System.out.print("Content: ");
        String paperContent = in.nextLine();

        System.out.print("Number of Pages: ");
        int paperPages = in.nextInt();
        in.nextLine(); // consume the newline character

        System.out.print("ISBN: ");
        String paperISBN = in.nextLine();

        System.out.print("DOI: ");
        String paperDOI = in.nextLine();

        ResearchPaper newPaper = new ResearchPaper(paperTitle, paperAnnotation, paperKeywords, paperSection,
                paperContent, paperPages, paperISBN, paperDOI);

        Database.addResearchPaper(newPaper);

        this.isFinished = true;
    }

}
