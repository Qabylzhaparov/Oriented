package research;
import java.util.*;

import fromUser.Database;

public class ResearchProject {
    
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
        return this.review;
    }
    
    public void setReview(String review) {
        this.review = review;
    }
    

    // Operations 
    
    public void addResearcher(Researcher researcher) {
        participants.add(researcher);
    }
    
    public boolean isFinished() {
        return isFinished;
    }
    
    public boolean defineStage(String stage) {
        if(!stages.containsKey(stage)) {
            return false;
        }
        stages.replace(stage, true);
        return true;
    }
    
    private boolean isStagesCompleted() {
        for(Boolean stage : stages.values()) {
            if(!stage) {
                return false;
            }
        }
        return true;
    }
    
    public boolean submitProject() {
        if(isStagesCompleted()) {
            this.isFinished = true;            
        }
        return isFinished;
    }
    
    public boolean publishResults() {
        if(isFinished) {
            Database.addResearchProject(this);            
        }
        return isFinished;
    }
}
