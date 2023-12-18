package research;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import fromUser.*;
import student.*;
import teacher.*;
import fromEmployee.*;

public class Researcher implements UserInterface{
    private UserInterface user;

    public Researcher(UserInterface user) {
        if (user instanceof Student || user instanceof Teacher || user instanceof Employee) {
            this.user = user;
        } else {
            throw new IllegalArgumentException("Researcher can only be a Student or a Teacher");
        }
    }

    private String name;
    private String surname;
    private String id;
    private String researchArea;
    private ArrayList<Integer> citations;
    private Integer yearsOfExperience;
    private Set<Researcher> collaborators;
    private Set<ResearchProject> projects;
    private Vector<ResearchPaper> papers;
    private Vector<ResearchProject> currentProjects;
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
    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
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
    
    public Vector<ResearchProject> getCurrentProjects() {
        return this.currentProjects;
    }
    
    public void setCurrentProjects(Vector<ResearchProject> currentProjects) {
        this.currentProjects = currentProjects;
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
}
