package research;
import java.util.*;
import java.util.stream.Collectors;

import fromUser.Database;

public class ResearchPaper {
    private String title;
    private Vector<Researcher> author;
    private Integer citations;
    private String annotation;
    private Vector<String> keywords;
    private String section;
    private String content;
    private Date date;
    private Integer pages;
    private String isbn;
    private String doi;

    private Set<Researcher> researcher;
    private Set<ResearchJournal> researchJournal;
    private Vector<String> feedbacks;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Vector<Researcher> getAuthor() {
        return this.author;
    }

    public void setAuthor(Vector<Researcher> author) {
        this.author = author;
    }

    public Integer getCitations() {
        return this.citations;
    }

    public void setCitations(Integer citations) {
        this.citations = citations;
    }

    public String getAnnotation() {
        return this.annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Vector<String> getKeywords() {
        return this.keywords;
    }

    public void setKeywords(Vector<String> keywords) {
        this.keywords = keywords;
    }

    public String getSection() {
        return this.section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getISBN() {
        return this.isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getDOI() {
        return this.doi;
    }

    public void setDOI(String doi) {
        this.doi = doi;
    }

    public Vector<String> getFeedbacks() {
        return this.feedbacks;
    }

	public Set<Researcher> getResearcher() {
		return researcher;
	}

	public void setResearcher(Set<Researcher> researcher) {
		this.researcher = researcher;
	}
    
	public Set<ResearchJournal> getResearchJournal() {
		return researchJournal;
	}

	public void setResearchJournal(Set<ResearchJournal> researchJournal) {
		this.researchJournal = researchJournal;
	}
	
	
    
    // Operations

    public String getCitation(FormatType format) {
        if (format.equals(FormatType.PLAIN_TEXT)) {
        	citations++;
            return getAuthor() + ", " + getTitle() + ", " + getSection() + ", " + getDate().getYear();
        } else if (format.equals(FormatType.BIBTEX)) {
            citations++;
        	return "@article{author = {" + getAuthor() + "}, title = {" + getTitle() + "}, section = {" + 
                               getSection() +"}, year = {" + getDate().getYear() + "}}";
        } else {
            return "";
        }
    }

    public Set<ResearchPaper> searchRelatedPapers() {
        return Database.getResearchPapers().stream().
        		filter(paper -> paper.getKeywords().stream().anyMatch(this.keywords::contains))
                .collect(Collectors.toSet());
    }


    public void writeFeedback(String feedback) {
        this.feedbacks.add(feedback);
    }

}

//    public Set<ResearchPaper> searchRelatedPapers() {
//        Set<ResearchPaper> relatedPapers = new HashSet<ResearchPaper>();
//        for(ResearchPaper paper : Database.getResearchPapers()) {
//            for(String keyword : this.keywords) {
//                if(paper.contains(keyword)) {
//                    relatedPapers.add(paper);
//                }
//            }
//        }
//        return relatedPapers;
//    }