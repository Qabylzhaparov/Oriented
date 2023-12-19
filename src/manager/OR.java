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
    
    public OR(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email, String Password,
			int PhoneNumber, double salary, Date hireDate) {
		super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber, salary, hireDate);
		// TODO Auto-generated constructor stub
        this.listOfRequestOR = new ArrayList<>();
        this.coursesAvailable = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();		
	}

    public void viewORders() {
        for (Request request : listOfRequestOR) {
            System.out.println(request);
        }
    }

    public void addCourses(List<Course> courses) {
        coursesAvailable.addAll(courses);
    }

    public void removeCourses(List<Course> courses) {
        coursesAvailable.removeAll(courses);
    }

    
    
    assignCtoS
    choose S
    Student s =
    if credits > 30
        error
    else assignCtoS()
    
    
    
    public void assignCoursesToStudent(Student student, Course courses) {
        if 
        student.addCourse(course);
    }
    
    public void assignCourseToTeacher(Course course, Teacher teacher) {
        course.addInstructor(teacher);
    }
   
    public void setRegistrationPeriod(Date startDate, Date endDate) {
        this.registrationPeriodStartDate = startDate;
        this.registrationPeriodEndDate = endDate;
        System.out.println("Registration period set from " + startDate + " to " + endDate);
    }

    
    public void closeRegistration() {
    	registeration = false;
    }

    
    public void openRegistration() {
    	registration = true;
    }


    
    
    
   
}