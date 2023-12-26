package research;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import student.*;
import teacher.*;
import fromEmployee.*;
import fromUser.Database;
import fromUser.User;
import fromUser.UserInterface;
import fromUser.UserType;

public class Researcher extends User implements UserInterface{
	private static final long serialVersionUID = 1L;
	private String name;
    private String surname;
    private String researchArea;
    private ArrayList<Integer> citations;
    private Integer yearsOfExperience;
    private Set<Researcher> collaborators;
    private Set<ResearchProject> projects;
    private Vector<ResearchPaper> papers;
    private UserInterface user;
	
	
	private transient Scanner in;
    private void initScanner() {
        this.in = new Scanner(System.in);
    }
    public Researcher() {
    	
    }

    public Researcher(User user) {
        if (user instanceof Student || user instanceof Teacher || user instanceof Employee) {
            this.user = user;
            projects = new HashSet<>();
            papers = new Vector<ResearchPaper>();
        } else {
            throw new IllegalArgumentException("Researcher can only be a Student or a Teacher");
        }
    }
    
    public Researcher(String email, String password, UserType userType) {
    	this.email =email;
    	this.password = password;
    	this.userType = userType;
		// TODO Auto-generated constructor stub
	}


    private Vector<String> feedback;
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return this.surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getID() {
        return user.getID();
    }
    
    public String getResearchArea() {
        return this.researchArea;
    }
    
    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }
    
    public ArrayList<Integer> getCitations() {
        return this.citations;
    }
    
    public void setCitations(ArrayList<Integer> citations) {
        this.citations = citations;
    }
    
    public Integer getYearsOfExperience() {
        return this.yearsOfExperience;
    }
    
    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    
    public Set<Researcher> getCollaborators() {
        return this.collaborators;
    }
    
    public void setCollaborators(Set<Researcher> collaborators) {
        this.collaborators = collaborators;
    }
    
    public Set<ResearchProject> getProjects() {
        return this.projects;
    }
    
    public void setProjects(Set<ResearchProject> projects) {
        this.projects = projects;
    }

    public Vector<ResearchPaper> getPapers() {
        return this.papers;
    }
    
    public void setPapers(Vector<ResearchPaper> papers) {
        this.papers = papers;
    }

    public Vector<String> getFeedback() {
        return this.feedback;
    }
    

    // Operations                                  
    
//    public int calculateHIndex() {
//        //TODO
//        return 0;
//    }
    public int calculateHIndex() {
    	List<Integer> sortedCitations = citations.stream()
    			.sorted(Comparator.reverseOrder())
    			.collect(Collectors.toList());
    	
    	int hIndex = IntStream.range(0, sortedCitations.size())
    			.filter(i -> sortedCitations.get(i) <= i + 1)
    			.findFirst()
    			.orElse(0);
    	
    	return hIndex;
    }
    
    public boolean submitPaper(ResearchPaper paper) {
        //TODO
        return false;
    }
    

    
    public boolean proposeResearchProject() {
        //TODO
        return false;
    }
    
    public void printPapers(Comparator<ResearchPaper> comparator) {
        getPapers().stream().
                    sorted(comparator).
                    forEach(paper->System.out.println(paper.getTitle() + "-" + paper.getAuthor()));
    }
    
//    private void save() throws IOException{
//    	ResearchDatabase.write();
//    }
//    
//    private void exit() {
//    	try {
//    		save();
//    	} catch(IOException e) {
//    		e.printStackTrace();
//    	}
//    	System.out.println("Session ended.");
//
//    }
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
	public void displayMenu() {
		System.out.println("--------Researcher's menu----------------");
		System.out.println("====================================");
		System.out.println("*	1) Open paper menu            *");
		System.out.println("*	2) Open project menu            *");
		System.out.println("*	3) Open Journal menu            *");
		System.out.println("*	4) New Research Project   *");
		System.out.println("*	5) Exit             *");
		System.out.println("*	6) Exit                    *");
		System.out.println("====================================");		
		
	}
    public void run() throws IOException {
    	try{
			initScanner();
    		System.out.println("1) Enter user mode  2) Enter researcher mode");
    		int choice = in.nextInt();
    		if(choice==1) user.run();
    		if(choice==2) Researcherrun();
    	}catch(Exception e) {
    		System.out.println("Something went wrong... \n Saving session...");
			e.printStackTrace();
			save();
    	}
    }
    
    public void Researcherrun() throws IOException{
    	try {
			initScanner();
    		System.out.println("Welcome!");
    		menu: while(true) {
    			displayMenu();
    			int choice = in.nextInt();
    			if(choice==1) {
    				if(!ResearchDatabase.getResearchPapers().isEmpty()) {
    					System.out.println("Enter Research paper title: ");
    					papers.stream().map(n->n.getTitle()).forEach(System.out::println);  
    					String schoice = in.next();
        				ResearchPaper p = (ResearchPaper) papers.stream().
        						              filter(n->n.getTitle().
        						              equals(schoice)).
        						              findFirst().
        						              orElse(null);;
        				  if (p != null) {
       			              while (p.runRPaper()) {}
        				  } else {
        				      System.out.println("Not found!");
        				  }      			
    				} else {
    					System.out.println("No papers yet");
    				}
    				}
    			if(choice==2) {
    				if (!ResearchDatabase.getResearchProjects(this).isEmpty()) {
    			        System.out.println("Enter Research project title: ");
    			        projects.stream().map(n -> n.getTitle()).forEach(System.out::println);
    			        String schoice = in.next();
    			        ResearchProject p = projects.stream()
    			                .filter(n -> n.getTitle().equals(schoice))
    			                .findFirst()
    			                .orElse(null);

    			        if (p != null) {
    			            while (p.runRProject(this)) {
    			            }
    			        } else {
    			            System.out.println("Not found!");
    			        }
    			    } else {
    			        System.out.println("No projects yet");
    			    }
    			}    			
    			if(choice==3) {
    				if (!ResearchDatabase.getResearchJournals().isEmpty()) {
    			        System.out.println("Enter Research journal name: ");
    			        ResearchDatabase.getResearchJournals().stream()
    			                .map(n -> n.getJournalName())
    			                .forEach(System.out::println);

    			        String schoice = in.next();
    			        ResearchJournal j = ResearchDatabase.getResearchJournals().stream()
    			                .filter(n -> n.getJournalName().equals(schoice))
    			                .findFirst()
    			                .orElse(null);

    			        if (j != null) {
    			            while (j.runRJournal(this)) {
    			            }
    			        } else {
    			            System.out.println("Not found!");
    			        }
    			    } else {
    			        System.out.println("No research journals yet");
    			    }
    			}
    			if(choice==4) {
    				newProject();
    				System.out.println("\n\nReturning back...\n");
					continue menu;
    			}
    			if(choice==5) {
    				exit();
    				break menu;
    			}
    				
    		}
    	} catch(Exception e) {
    		System.out.println("Something went wrong...\n Saving session...");
    		e.printStackTrace();
    		save();
    	}
    
    
    }
    
    private void newProject() {
        try {
			initScanner();
            System.out.println("\nEnter new project details:");

            System.out.print("Title: ");
            String projectTitle = in.next();

            System.out.print("Section: ");
            String projectSection = in.nextLine();

            System.out.print("Objectives (comma-separated): ");
            String[] objectivesArray = in.nextLine().split(", ");
            Vector<String> projectObjectives = new Vector<>(Arrays.asList(objectivesArray));

            System.out.print("Enter project stages (comma-separated): ");
            String[] stagesArray = in.nextLine().split(", ");
            Vector<String> projectStages = new Vector<>(Arrays.asList(stagesArray));
           
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.print("End Date (format: yyyy-MM-dd): ");
            String endDateString = in.nextLine();
            Date projectEndDate = dateFormat.parse(endDateString);

            ResearchProject newProject = new ResearchProject(projectTitle, projectObjectives, projectSection, projectStages, projectEndDate);
            newProject.addResearcher(this);
            
            ResearchDatabase.addResearchProject(newProject);
            projects.add(newProject);
            System.out.println("New project created successfully!");
        } catch (Exception e) {
            System.out.println("Error creating new project.");
            e.printStackTrace();
        }
    }

	public void addPaper(ResearchPaper p) {
		papers.add(p);
	}

    
    
    
    
}