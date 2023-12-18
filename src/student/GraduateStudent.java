package student;

public class GraduateStudent extends Student {

    private String iD;

    private GraduateStudentType  educationDegree;

    private String thesisTitle;

    private String degreeField;

    public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public GraduateStudentType getEducationDegree() {
		return educationDegree;
	}

	public void setEducationDegree(GraduateStudentType educationDegree) {
		this.educationDegree = educationDegree;
	}

	public String getThesisTitle() {
		return thesisTitle;
	}

	public void setThesisTitle(String thesisTitle) {
		this.thesisTitle = thesisTitle;
	}

	public String getDegreeField() {
		return degreeField;
	}

	public void setDegreeField(String degreeField) {
		this.degreeField = degreeField;
	}

	void defendThesis() {
        System.out.println("Thesis defended successfully.");
    }

    void attendConference() {
        System.out.println("Attending international conference.");
    }                        
    
    
}