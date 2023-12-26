package student;

import java.util.Date;

import fromUser.UserType;
import manager.SchoolType;

public class GraduateStudent extends Student {

    public GraduateStudent(UserType userType, String iD, String firstName, String lastName, String email,
			String password, int phoneNumber, Date dateOfBirth, String gender, Integer yearOfStudy, SchoolType school) {
		super(userType, iD, firstName, lastName, email, password, phoneNumber, dateOfBirth, gender, yearOfStudy, school);
		// TODO Auto-generated constructor stub
	}

	private GraduateStudentType  educationDegree;

    private String thesisTitle;

    private String degreeField;

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