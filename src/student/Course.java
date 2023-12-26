package student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fromUser.Database;
import manager.SchoolType;
import teacher.Teacher;


public class Course implements Serializable {
    
	private static final long serialVersionUID = 1L;
    private static int courseIdCounter = 1;  
    private String courseName;
    private CourseType courseType;
    private SchoolType school;
    private Integer credits;
    private List<Course> prerequisites = new ArrayList<>(); 
    private List<Teacher> instructors = new ArrayList<>();
	private int courseId;

    public Course() {
        this.courseId = courseIdCounter++;  
    }

    public Course(String name, Integer credits) {
        this();
        this.courseName = name;
        this.credits = credits;
    }
 

    public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
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

    public void removeInstructor(Teacher teacher) {
        instructors.remove(teacher);
    }
    
    

    public static void viewCourseInfo(List<Course> courses) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose course: ");
        for (Course c : courses) {
            System.out.println(c.getCourseId() + ". " + c.getCourseName());
        }
        int courseId = scanner.nextInt();
        Course selectedCourse = Database.getCourseAtID(courseId - 1); 

        if (selectedCourse != null) {
            System.out.println(selectedCourse);
        } else {
            System.out.println("Course not found.");
        }
    }

    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return courseId == course.courseId;
    }

    public int hashCode() {
        return Integer.hashCode(courseId);
    }

    
    public String toString() {
        StringBuilder sb = new StringBuilder("Course{");
        sb.append("courseId=").append(courseId);
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", courseType=").append(courseType);
        sb.append(", school=").append(school);
        sb.append(", credits=").append(credits);
        sb.append(", prerequisites=").append(prerequisites);
        sb.append(", instructors=").append(instructors);
        sb.append('}');
        return sb.toString();
    }
}

   