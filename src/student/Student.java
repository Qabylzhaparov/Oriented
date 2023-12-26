package student;

import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fromUser.*;
import manager.*;
import teacher.*;

public class Student extends User {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7598735898218537507L;

	/**
	 * 
	 */
//	private static final long serialVersionUID = 414135957949168179L;
// Это старый UID 
	public Student(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email,
			String Password, int PhoneNumber) {
		super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber);
		// TODO Auto-generated constructor stub
	}

	public Student(String email, String password, UserType userType) {
		// Админға керек /Нурик
		this.email = email;
		this.password = password;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	private Date dateOfBirth;
    
    private List<Mark> marks;
    
    private Integer sumOfCredits;
    
    private List<Course> courses;
    
    private String gender;
    
    private Integer yearOfStudy;
    
    private SchoolType school;
    
    private Teacher advisor;
    
    private List<Schedule> schedules;

    public String getID() {
        
    	return this.ID;
    }
    
    
    public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public List<Mark> getMarks() {
		return marks;
	}



	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}



	public Integer getSumOfCredits() {
		return sumOfCredits;
	}



	public void setSumOfCredits(Integer sumOfCredits) {
		this.sumOfCredits = sumOfCredits;
	}



	public List<Course> getCourses() {
		return courses;
	}



	public void setCourse(Course course) {
		this.courses.add(course);
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public Integer getYearOfStudy() {
		return yearOfStudy;
	}



	public void setYearOfStudy(Integer yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}



	public SchoolType getSchool() {
		return school;
	}



	public void setSchool(SchoolType school) {
		this.school = school;
	}



	public Teacher getAdvisor() {
		return advisor;
	}



	public void setAdvisor(Teacher advisor) {
		this.advisor = advisor;
	}



	public List<Schedule> getSchedules() {
		return schedules;
	}



	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}



	public void setID(String iD) {
		ID = iD;
	}



	void putAttendance() {
        System.out.println("Attendance recorded.");
    }

    void registrationForDisciplines(List<Course> courses) {
        System.out.println("Registered for the following disciplines:");
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
    }

    void viewMarks() {
        System.out.println("Marks for the current courses:");
        for (Mark mark : marks) {
            System.out.println("Course: " + mark.course.getCourseName + ", Mark: " + mark.mark);
        }
    }

    void viewTeachers() {
        System.out.println("Current teachers:");
        System.out.println("Advisor: " + advisor.name);
        for (Schedule schedule : schedules) {
            System.out.println("Teacher for " + schedule.lesson.lessonName + ": " + schedule.teacher.name);
        }
    }

    void viewCourse() {
        System.out.println("Current course: " + course.courseName);
    }

    void viewTranscript() {
        System.out.println("Transcript for the current courses:");
        for (Mark mark : marks) {
            System.out.println("Course: " + mark.course.courseName + ", Mark: " + mark.mark);
        }
    }

    void rateTeachers() {
        System.out.println("Teachers available for rating:");
        System.out.println("Advisor: " + advisor.name);
        for (Schedule schedule : schedules) {
            System.out.println("Teacher for " + schedule.lesson.lessonName + ": " + schedule.teacher.name);
        }
        System.out.println("Teachers rated.");
    }

    void writeComments(String comments) {
        System.out.println("Comments added: " + comments);
    }

	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMenu() {
		// TODO Auto-generated method stub
		
	}
    
    
}
