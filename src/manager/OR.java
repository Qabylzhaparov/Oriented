package manager;

import java.util.*;
import student.*;
import teacher.Teacher;

/**
 * The OR (Operations Research) class represents an Operations Research manager in the educational institution management system.
 * It extends the Manager class and provides additional functionality related to student registration, course management,
 * teacher assignment, and order viewing.
 *

 */
public class OR extends Manager {

    // List of OR-specific requests
    private List<Request> listOfRequestOR;

    // List of available courses for registration
    private List<Course> coursesAvailable;

    // Start date of the registration period
    private Date registrationPeriodStartDate;

    // End date of the registration period
    private Date registrationPeriodEndDate;

    // List of registered students
    private List<Student> registeredStudents;

    // Flag indicating whether the registration is open
    private boolean isRegistrationOpen;

    /**
     * Constructs a new OR object with the specified user type, ID, first name, last name, email, password, phone number,
     * salary, and hire date.
     *
     * @param UserType    The user type of the OR manager.
     * @param ID          The ID of the OR manager.
     * @param FirstName   The first name of the OR manager.
     * @param LastName    The last name of the OR manager.
     * @param Email       The email of the OR manager.
     * @param Password    The password of the OR manager.
     * @param PhoneNumber The phone number of the OR manager.
     * @param salary      The salary of the OR manager.
     * @param hireDate    The hire date of the OR manager.
     */
    public OR(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email, String Password,
              int PhoneNumber, double salary, Date hireDate) {
        super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber, salary, hireDate);
        this.listOfRequestOR = new ArrayList<>();
        this.coursesAvailable = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.isRegistrationOpen = false;
    }

    /**
     * Displays the OR-specific orders.
     */
    public void viewOrders() {
        for (Request request : listOfRequestOR) {
            System.out.println(request);
        }
    }

    /**
     * Adds a course to the list of available courses for registration.
     *
     * @param course      The course to add.
     * @param schoolType  The school type associated with the course.
     * @param yearOfStudy The year of study associated with the course.
     */
    public void addCoursesForRegistration(Course course, SchoolType schoolType, Integer yearOfStudy) {
        course.setSchoolType(schoolType);
        course.setYearOfStudy(yearOfStudy);
        coursesAvailable.add(course);
    }

    /**
     * Removes a course from the list of available courses for registration.
     *
     * @param course The course to remove.
     */
    public void removeCourse(Course course) {
        coursesAvailable.remove(course);
    }

    /**
     * Approves a student's registration if the registration is open and the student details are complete.
     *
     * @param student The student to approve.
     */
    public void approveStudentRegistration(Student student) {
        if (isRegistrationOpen && student.getYearOfStudy() != null && student.getSchool() != null) {
            registeredStudents.add(student);
            System.out.println("Student registration approved: " + student);
        } else {
            System.out.println("Registration is closed or student details are incomplete.");
        }
    }

    /**
     * Assigns a course to a teacher by adding the teacher as an instructor for the course.
     *
     * @param course  The course to assign.
     * @param teacher The teacher to assign to the course.
     */
    public void assignCourseToTeacher(Course course, Teacher teacher) {
        course.addInstructor(teacher);
    }

    /**
     * Sets the registration period with the specified start and end dates.
     *
     * @param startDate The start date of the registration period.
     * @param endDate   The end date of the registration period.
     */
    public void setRegistrationPeriod(Date startDate, Date endDate) {
        this.registrationPeriodStartDate = startDate;
        this.registrationPeriodEndDate = endDate;
        System.out.println("Registration period set from " + startDate + " to " + endDate);
    }

    /**
     * Opens the student registration period.
     */
    public void openRegistration() {
        isRegistrationOpen = true;
    }

    /**
     * Closes the student registration period.
     */
    public void closeRegistration() {
        isRegistrationOpen = false;
    }
}
