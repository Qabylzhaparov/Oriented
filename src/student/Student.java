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

/**
 * The Student class represents a student in an educational institution. It extends the User class
 * and includes additional attributes such as date of birth, marks, courses, gender, year of study,
 * school type, advisor, and schedules.
 *

 */
public class Student extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    // Instance variables
    private Date dateOfBirth;
    private List<Mark> marks;
    private Integer sumOfCredits;
    private List<Course> courses;
    private String gender;
    private Integer yearOfStudy;
    private SchoolType school;
    private Teacher advisor;
    private List<Schedule> schedules;
    private transient Scanner in;  // transient keyword indicates that this field should not be serialized

    /**
     * Initializes the Scanner for user input.
     */
    private void initScanner() {
        this.in = new Scanner(System.in);
    }

    /**
     * Parameterized constructor for the Student class.
     *
     * @param email    The email address of the student.
     * @param password The password for the student's account.
     * @param userType The type of user, in this case, UserType.STUDENT.
     */
    public Student(String email, String password, UserType userType) {
        super(email, password, userType);
    }

    /**
     * Getter for the date of birth.
     *
     * @return The date of birth of the student.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Setter for the date of birth.
     *
     * @param dateOfBirth The date of birth to set.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Getter for the list of marks.
     *
     * @return The list of marks for the student.
     */
    public List<Mark> getMarks() {
        return marks;
    }

    /**
     * Setter for the list of marks.
     *
     * @param marks The list of marks to set.
     */
    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    /**
     * Getter for the sum of credits.
     *
     * @return The sum of credits for the student.
     */
    public Integer getSumOfCredits() {
        return sumOfCredits;
    }

    /**
     * Setter for the sum of credits.
     *
     * @param sumOfCredits The sum of credits to set.
     */
    public void setSumOfCredits(Integer sumOfCredits) {
        this.sumOfCredits = sumOfCredits;
    }

    /**
     * Getter for the list of enrolled courses.
     *
     * @return The list of courses the student is enrolled in.
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Setter for the list of enrolled courses.
     *
     * @param courses The list of courses to set.
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Getter for the gender.
     *
     * @return The gender of the student.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Setter for the gender.
     *
     * @param gender The gender to set.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Getter for the year of study.
     *
     * @return The year of study for the student.
     */
    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    /**
     * Setter for the year of study.
     *
     * @param yearOfStudy The year of study to set.
     */
    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    /**
     * Getter for the school type.
     *
     * @return The school type of the student.
     */
    public SchoolType getSchool() {
        return school;
    }

    /**
     * Setter for the school type.
     *
     * @param school The school type to set.
     */
    public void setSchool(SchoolType school) {
        this.school = school;
    }

    /**
     * Getter for the advisor.
     *
     * @return The advisor for the student.
     */
    public Teacher getAdvisor() {
        return advisor;
    }

    /**
     * Setter for the advisor.
     *
     * @param advisor The advisor to set.
     */
    public void setAdvisor(Teacher advisor) {
        this.advisor = advisor;
    }

    /**
     * Getter for the list of schedules.
     *
     * @return The list of schedules for the student.
     */
    public List<Schedule> getSchedules() {
        return schedules;
    }

    /**
     * Setter for the list of schedules.
     *
     * @param schedules The list of schedules to set.
     */
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    /**
     * Parameterized constructor for creating a student with additional attributes.
     *
     * @param userType    The type of user, in this case, UserType.STUDENT.
     * @param iD          The identification number of the student.
     * @param firstName   The first name of the student.
     * @param lastName    The last name of the student.
     * @param email       The email address of the student.
     * @param password    The password for the student's account.
     * @param phoneNumber The phone number of the student.
     * @param dateOfBirth The date of birth of the student.
     * @param gender      The gender of the student.
     * @param yearOfStudy The year of study for the student.
     * @param school      The school type of the student.
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
     * Displays a list of available courses based on the selected school type
     * and allows the student to register for a course.
     */
    
    public void viewAndRegisterCoursesCLI() {
        System.out.println("Select your school type:");
        for (SchoolType type : SchoolType.values()) {
            System.out.println(type);
        }
        SchoolType selectedSchoolType = SchoolType.valueOf(in.nextLine().toUpperCase());

        System.out.println("Available courses for " + selectedSchoolType + ":");   //по выбранному типу факультета выходят предназначенные только этому факультету курсы
        List<Course> availableCourses = Database.getInstance().getAllcourses()
                                     .values().stream()
                                     .filter(course -> course.getSchool().equals(selectedSchoolType))
                                     .collect(Collectors.toList());

        availableCourses.forEach(course -> System.out.println(course.getCourseId() + ": " + course.getCourseName()));

        System.out.println("Enter the ID of the course to register:");
        int courseId = in.nextInt();
        Course selectedCourse = Database.getInstance().getCourseAtID(courseId); //с класса бд (нужно в бд добавить мэпы)

        if (selectedCourse != null) {
            registerForCourse(selectedCourse);
            System.out.println("Registered for course: " + selectedCourse.getCourseName());
        } else {
            System.out.println("Course not found.");
        }
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
     * Displays a list of courses that the student is currently enrolled in.
     */
    
    public void viewCoursesCLI() {
        System.out.println("Courses you are enrolled in:");
        courses.forEach(course -> System.out.println(course.toString()));
    }
    
    /**
     * Displays information about the teacher for a selected course.
     */
    
    public void viewTeacherInformation() {
        System.out.println("Select a course to view its teacher:");
        for (Course course : courses) {
            System.out.println(course.getCourseId() + ": " + course.getCourseName());
        }
        int courseId = in.nextInt();
        Course selectedCourse = courses.stream()
            .filter(course -> course.getCourseId() == courseId)
            .findFirst()
            .orElse(null);
        
        if (selectedCourse != null) {
            selectedCourse.getInstructors().forEach(teacher -> 
                System.out.println("Teacher for " + selectedCourse.getCourseName() + ": " + teacher.getFirstName()));
        } else {
            System.out.println("Course not found.");
        }
    }
    
    /**
    * Displays the marks of the student for each enrolled course.
    */
    
    public void viewMarks() {
        System.out.println("Your marks:");
        marks.forEach(mark -> 
            System.out.println("Course: " + mark.getCourse().getCourseName() + ", Mark: " + mark.getMarkType()));
    }
    
    /**
     * Displays the transcript of the student, including all courses and marks.
     */
    
    public void viewTranscript() {
        Transcript transcript = Database.getInstance().getTranscriptForStudent(this); 
        System.out.println(transcript.toString());
    }
    
    /**
     * Saves the state of the Database to a file.
     *
     * @throws IOException If an I/O error occurs.
     */
    
    private void save() throws IOException {
		Database.write();
	}
    
    /**
     * Exits the program and saves the state before closing.
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
     * Displays the menu options for the student.
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
     * Runs the main logic of the student program, handling user interactions.
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

 

