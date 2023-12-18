package student;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private Integer academicYear;

    private String term;

    private List<Course> courses;
    
    private List<Lesson> lessons ;

    private String journalSection;

    private Double journalRate;

    private List<ResearchPapers> publishedPapers;

    private List<User> subscribers;
    

	public Integer getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(Integer academicYear) {
		this.academicYear = academicYear;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	public String getJournalSection() {
		return journalSection;
	}

	public void setJournalSection(String journalSection) {
		this.journalSection = journalSection;
	}

	public Double getJournalRate() {
		return journalRate;
	}

	public void setJournalRate(Double journalRate) {
		this.journalRate = journalRate;
	}

	public List<ResearchPapers> getPublishedPapers() {
		return publishedPapers;
	}

	public void setPublishedPapers(List<ResearchPapers> publishedPapers) {
		this.publishedPapers = publishedPapers;
	}

	public List<User> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(List<User> subscribers) {
		this.subscribers = subscribers;
	}

	public void upDateLesson() {
        //TODO
    }
    
    /**
    * @generated
    */
    public void printSchedule() {
        //TODO
    }
