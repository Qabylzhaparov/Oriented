package student;


import java.util.List;
import java.util.Scanner;

import fromUser.Database;
import manager.SchoolType;
import teacher.Teacher;

public class Course {
	Scanner in = new Scanner(System.in);
	private static int courseId;
	    
    private String courseName;
    
    private CourseType courseType;
    
    private SchoolType school;
        
    private Integer credits;
    
    private List<Course> prerequisites;
        
    private List<Teacher> instructors;
  
    {
    	courseId++;
    }
    
    public Course() {
    	courseName = null;
    }
    
    public Course(String name) {
    	this.courseName = name;
    }
    
    public Course(String name, Integer credits) {
    	this.courseName = name;
    	this.credits = credits;
    }

    public int getCourseId() {
		return courseId;
	}

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public SchoolType getSchool() {
        return school;
    }

    public void setSchool(SchoolType school) {
        this.school = school;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public List<Teacher> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Teacher> instructors) {
        this.instructors = instructors;
    }

    public void addInstructor(Teacher teacher) {
    	instructors.add(teacher);
    }
    
    public static void viewCourseInfo(List<Course> courses) {
    	System.out.println("Choose course: ");
		for(Course c: courses) {
			System.out.println(c.getCourseId() + ". " + c.getCourseName());
		}
		System.out.println(Database.getCourseAtID(in.nextInt()-1).toString());
    }
}

    

