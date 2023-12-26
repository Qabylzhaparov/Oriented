package manager;

import java.util.*;
import student.*;
import teacher.Teacher;

public class OR extends Manager {
    private List<Request> listOfRequestOR;
    private List<Course> coursesAvailable;
    private Date registrationPeriodStartDate;
    private Date registrationPeriodEndDate;
    private List<Student> registeredStudents;
    private boolean isRegistrationOpen;

    public OR(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email, String Password,
              int PhoneNumber, double salary, Date hireDate) {
        super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber, salary, hireDate);
        this.listOfRequestOR = new ArrayList<>();
        this.coursesAvailable = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.isRegistrationOpen = false;
    }

    public void viewOrders() {
        for (Request request : listOfRequestOR) {
            System.out.println(request);
        }
    }

    public void addCoursesForRegistration(Course course, SchoolType schoolType, Integer yearOfStudy) {
        course.setSchoolType(schoolType);
        course.setYearOfStudy(yearOfStudy); 
        coursesAvailable.add(course);
    }

    public void removeCourse(Course course) {
        coursesAvailable.remove(course);
    }

    public void approveStudentRegistration(Student student) {
        if (isRegistrationOpen && student.getYearOfStudy() != null && student.getSchool() != null) {
            registeredStudents.add(student);
            System.out.println("Student registration approved: " + student);
        } else {
            System.out.println("Registration is closed or student details are incomplete.");
        }
    }

    public void assignCourseToTeacher(Course course, Teacher teacher) {
        course.addInstructor(teacher); 
    }

    public void setRegistrationPeriod(Date startDate, Date endDate) {
        this.registrationPeriodStartDate = startDate;
        this.registrationPeriodEndDate = endDate;
        System.out.println("Registration period set from " + startDate + " to " + endDate);
    }

    public void openRegistration() {
        isRegistrationOpen = true;
    }

    public void closeRegistration() {
        isRegistrationOpen = false;
    }

   
}
