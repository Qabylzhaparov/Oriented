package student;

import java.util.Date;

import fromUser.Language;
import teacher.Teacher;

public class Lesson {
	private static Integer lessonId = 0;
	
	private Course course;
	
    private String lessonName;

    private Teacher teacher;

    private LessonType lessonType;
    
    private String location;
    
    private String time;
        
    private WeekDay day;
    
    {
    	lessonId++;
    }
    
    public Lesson() {
    	
    }
    
   

	public Lesson(Course course, LessonType lessontype, Teacher teacher, String location, String time, WeekDay day) {
		super();
		this.setCourse(course);
		this.lessonName = course.getCourseName();
		this.lessonType = lessontype;
		this.teacher = teacher;
		this.location = location;
		this.time = time;
		this.day = day;
	}

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		Lesson.lessonId = lessonId;
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

}    
