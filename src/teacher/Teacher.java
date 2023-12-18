package teacher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fromEmployee.Employee;
import manager.SchoolName;
import student.Course;
import student.Schedule;

public class Teacher extends Employee {
    
	public Teacher(fromUser.UserType UserType, String ID, String FirstName, String LastName, String Email,
			String Password, int PhoneNumber, double salary, Date hireDate) {
		super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber, salary, hireDate);
		// TODO Auto-generated constructor stub
	}

	private List<Course> courses;
    
	private SchoolName section;
    
    private List<Teacher> interns;
    
    private List<Schedule> schedule;
    

    public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public SchoolName getSection() {
		return section;
	}

	public void setSection(SchoolName section) {
		this.section = section;
	}

	public List<Teacher> getInterns() {
		return interns;
	}

	public void setInterns(List<Teacher> interns) {
		this.interns = interns;
	}

	public List<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}

	public void viewStudentInfo() {
        System.out.println("Viewing student information...");
    }

    public void putMark(Student student, Mark mark) {
        System.out.println("Putting mark for student " + student.getName() +
                " in course " + mark.getCourse().courseName);
    }

    public void viewCourse() {
        System.out.println("Viewing courses...");
    }

    public void manageCourse(Course course) {
        System.out.println("Managing course: " + course.courseName);
    }

    public void sendComplaints(String complaint) {
        System.out.println("Sending complaints: " + complaint);
    }

    public void sendOrder(String order) {
        System.out.println("Sending order: " + order);
    }

    public void checkAttendance(Course course) {
        System.out.println("Checking attendance for course: " + course.courseName);
    }
}  
