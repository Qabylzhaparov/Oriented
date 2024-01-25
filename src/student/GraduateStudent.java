package student;

import java.util.Date;

import fromUser.UserType;
import manager.SchoolType;

/**
 * Represents a graduate student in an educational institution.
 */
public class GraduateStudent extends Student {

    private GraduateStudentType educationDegree;
    private String thesisTitle;
    private String degreeField;

    /**
     * Constructs a new GraduateStudent object with the specified parameters.
     *
     * @param userType      The user type of the graduate student.
     * @param ID            The ID of the graduate student.
     * @param firstName     The first name of the graduate student.
     * @param lastName      The last name of the graduate student.
     * @param email         The email of the graduate student.
     * @param password      The password of the graduate student.
     * @param phoneNumber   The phone number of the graduate student.
     * @param dateOfBirth   The date of birth of the graduate student.
     * @param gender        The gender of the graduate student.
     * @param yearOfStudy   The year of study of the graduate student.
     * @param school        The school type associated with the graduate student.
     */
    public GraduateStudent(UserType userType, String ID, String firstName, String lastName, String email,
            String password, int phoneNumber, Date dateOfBirth, String gender, Integer yearOfStudy, SchoolType school) {
        super(userType, ID, firstName, lastName, email, password, phoneNumber, dateOfBirth, gender, yearOfStudy, school);
    }

    /**
     * Gets the education degree of the graduate student.
     *
     * @return The education degree.
     */
    public GraduateStudentType getEducationDegree() {
        return educationDegree;
    }

    /**
     * Sets the education degree of the graduate student.
     *
     * @param educationDegree The education degree to set.
     */
    public void setEducationDegree(GraduateStudentType educationDegree) {
        this.educationDegree = educationDegree;
    }

    /**
     * Gets the thesis title of the graduate student.
     *
     * @return The thesis title.
     */
    public String getThesisTitle() {
        return thesisTitle;
    }

    /**
     * Sets the thesis title of the graduate student.
     *
     * @param thesisTitle The thesis title to set.
     */
    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    /**
     * Gets the degree field of the graduate student.
     *
     * @return The degree field.
     */
    public String getDegreeField() {
        return degreeField;
    }

    /**
     * Sets the degree field of the graduate student.
     *
     * @param degreeField The degree field to set.
     */
    public void setDegreeField(String degreeField) {
        this.degreeField = degreeField;
    }

    /**
     * Defends the thesis of the graduate student.
     */
    void defendThesis() {
        System.out.println("Thesis defended successfully.");
    }

    /**
     * Attends an international conference.
     */
    void attendConference() {
        System.out.println("Attending international conference.");
    }
}
