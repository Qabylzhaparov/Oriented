package student;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import fromUser.Database;
import fromUser.User;
import fromUser.UserType;
import manager.SchoolType;
import teacher.Teacher;

public class Student extends User implements Serializable {

    // Unique identifier for serialization
    private static final long serialVersionUID = 1L;

    // Properties of the Student class
    private Date dateOfBirth;          // The date of birth of the student
    private List<Mark> marks;          // List of marks for the student
    private Integer sumOfCredits;      // Sum of credits for the student
    private List<Course> courses;       // List of courses enrolled by the student
    private String gender;             // Gender of the student
    private Integer yearOfStudy;       // Year of study for the student
    private SchoolType school;         // School type associated with the student
    private Teacher advisor;           // Advisor assigned to the student
    private List<Schedule> schedules;   // List of schedules for the student
    private transient Scanner in;      // Transient Scanner for input operations

    /**
     * Initializes the transient Scanner for input operations.
     */
    private void initScanner() {
        this.in = new Scanner(System.in);
    }

    /**
     * Constructor for creating a Student object with specified attributes.
     *
     * @param userType   The type of user (Student).
     * @param iD         The unique ID of the student.
     * @param firstName  The first name of the student.
     * @param lastName   The last name of the student.
     * @param email      The email address of the student.
     * @param password   The password for the student's account.
     * @param phoneNumber The phone number of the student.
     * @param dateOfBirth The date of birth of the student.
     * @param gender      The gender of the student.
     * @param yearOfStudy The year of study for the student.
     * @param school      The school type associated with the student.
     */
    public Student(UserType userType, String iD, String firstName, String lastName,
                   String email, String password, int phoneNumber,
                   Date dateOfBirth, String gender, Integer yearOfStudy, SchoolType school) {
        super(userType, iD, firstName, lastName, email, password, phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.yearOfStudy = yearOfStudy;
        this.school = school;
    }

    /**
     * Gets the date of birth of the student.
     *
     * @return The date of birth.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the student.
     *
     * @param dateOfBirth The date of birth to set.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the list of marks for the student.
     *
     * @return The list of marks.
     */
    public List<Mark> getMarks() {
        return marks;
    }

    /**
     * Sets the list of marks for the student.
     *
     * @param marks The list of marks to set.
     */
    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    /**
     * Gets the sum of credits for the student.
     *
     * @return The sum of credits.
     */
    public Integer getSumOfCredits() {
        return sumOfCredits;
    }

    /**
     * Sets the sum of credits for the student.
     *
     * @param sumOfCredits The sum of credits to set.
     */
    public void setSumOfCredits(Integer sumOfCredits) {
        this.sumOfCredits = sumOfCredits;
    }

    /**
     * Gets the list of courses enrolled by the student.
     *
     * @return The list of courses.
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the list of courses enrolled by the student.
     *
     * @param courses The list of courses to set.
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Gets the gender of the student.
     *
     * @return The gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the student.
     *
     * @param gender The gender to set.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the year of study for the student.
     *
     * @return The year of study.
     */
    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    /**
     * Sets the year of study for the student.
     *
     * @param yearOfStudy The year of study to set.
     */
    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    /**
     * Gets the school type associated with the student.
     *
     * @return The school type.
     */
    public SchoolType getSchool() {
        return school;
    }

    /**
     * Sets the school type associated with the student.
     *
     * @param school The school type to set.
     */
    public void setSchool(SchoolType school) {
        this.school = school;
    }

    /**
     * Gets the advisor assigned to the student.
     *
     * @return The advisor.
     */
    public Teacher getAdvisor() {
        return advisor;
    }

    /**
     * Sets the advisor assigned to the student.
     *
     * @param advisor The advisor to set.
     */
    public void setAdvisor(Teacher advisor) {
        this.advisor = advisor;
    }

    /**
     * Gets the list of schedules for the student.
     *
     * @return The list of schedules.
     */
    public List<Schedule> getSchedules() {
        return schedules;
    }

    /**
     * Sets the list of schedules for the student.
     *
     * @param schedules The list of schedules to set.
     */
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    /**
     * Views and registers for courses through the command-line interface.
     */
    public void viewAndRegisterCoursesCLI() {
        // Implementation of the method...
    }

    /**
     * Registers the student for a specific course.
     *
     * @param course The course to register for.
     */
    public void registerForCourse(Course course) {
        courses.add(course);
    }

    /**
     * Views the courses enrolled by the student through the command-line interface.
     */
    public void viewCoursesCLI() {
        // Implementation of the method...
    }

    /**
     * Views information about the teacher for a selected course through the command-line interface.
     */
    public void viewTeacherInformation() {
        // Implementation of the method...
    }

    /**
     * Views the marks of the student through the command-line interface.
     */
    public void viewMarks() {
        // Implementation of the method...
    }

    /**
     * Views the transcript of the student through the command-line interface.
     */
    public void viewTranscript() {
        // Implementation of the method...
    }

    /**
     * Saves the current state of the database.
     *
     * @throws IOException If an I/O error occurs while saving.
     */
    private void save() throws IOException {
        Database.write();
    }

    /**
     * Exits the student's session.
     */
    private void exit() {
        System.out.println("Bye bye");
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the menu for the student.
     */
 

    
	@Override
    public void displayMenu() {
		System.out.println("--------Student's menu----------------");
		System.out.println("====================================");
		System.out.println("*	1) View Students             *");
		System.out.println("*	2) View Teachers             *");
		System.out.println("*	3) View and Manage Requests  *");
		System.out.println("*	4) Add News                  *");
		System.out.println("*	5) Remove News               *");
		System.out.println("*	6) Exit                      *");
		System.out.println("====================================");
    }
	/**
     * Runs the student's session.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void run() throws IOException {
		try {
			initScanner();
			menu : while(true){
				displayMenu();
				int choice = in.nextInt();
				if(choice==1){
					viewStudents: while(true){
						
						Database.write();
						System.out.println("\n 1) Add new user \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue viewStudents;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if(choice==2){
					viewTeachers: while(true){
						;
						Database.write();
						System.out.println("\n 1) Remove user \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue viewTeachers;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if(choice==3){
					viewRequests: while(true){
						
						Database.write();
						System.out.println("\n 1) Update user \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue viewRequests;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if(choice==4){
					addNews: while(true){
					
						Database.write();
						System.out.println("\n 1) Show a users list \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue addNews;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if(choice==5){
					removeNews: while(true){
					
						Database.write();
						System.out.println("\n 1) Show a users list \\n 2) Return back \\n 3) Exit");
						choice = in.nextInt();
						if(choice==1) continue removeNews;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
			
				else if (choice==6){
						exit();
						break menu;
					}
				}
			} catch (Exception e) {
				System.out.println("Something bad happened... \n Saving resources...");
				e.printStackTrace();
				save();
			}
		finally {
			if(in != null) in.close();
	        // Close the Scanner
	      
	    }
	}

 
}
