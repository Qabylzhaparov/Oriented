package student;

import java.io.Serializable;
import teacher.Teacher;


public class Lesson implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int lessonIdCounter = 0; // Static counter 
    private int lessonId;
    private Course course;
    private String lessonName;
    private Teacher teacher;
    private LessonType lessonType;
    private String location;
    private String time;
    private WeekDay day;

    public Lesson(Course course, LessonType lessonType, Teacher teacher, String location, String time, WeekDay day) {
        this.lessonId = generateLessonId();
        this.course = course;
        this.lessonName = course.getCourseName();
        this.lessonType = lessonType;
        this.teacher = teacher;
        this.location = location;
        this.time = time;
        this.day = day;
    }
    

    public int getLessonId() {
		return lessonId;
	}



	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	public String getLessonName() {
		return lessonName;
	}



	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}



	public Teacher getTeacher() {
		return teacher;
	}



	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}



	public LessonType getLessonType() {
		return lessonType;
	}



	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public WeekDay getDay() {
		return day;
	}

	public void setDay(WeekDay day) {
		this.day = day;
	}



	public String toString() {
        return String.format("%-8s %-20s %-4s %-12s %-10s",
                getTime(), getLessonName(), getLessonType(), getTeacher().getFirstName(), getLocation());
    }

    private static synchronized int generateLessonId() {
        return ++lessonIdCounter; // 
    }
}