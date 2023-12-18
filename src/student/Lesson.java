package student;

import java.util.Date;

import fromUser.Language;

public class Lesson {

    private String lessonName;

    private Teacher teacher;

    private LessonType lessonType;

    private Language language;
    
    private String location;
    
    private Date time;
    
    private Integer studentCount;
    
    private WeekDay Day;
    
    
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

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}

	public WeekDay getDay() {
		return Day;
	}

	public void setDay(WeekDay day) {
		Day = day;
	}

	void changeLocation(String newLocation) {
        this.location = newLocation;
    }

    void changeTime(Date newTime) {
        this.time = newTime;
    }

    void operation() {
        System.out.println("Lesson operation performed.");
    }
}    
