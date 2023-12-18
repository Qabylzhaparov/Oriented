package student;


import java.util.List;

import manager.SchoolName;
import teacher.Teacher;

public class Course {
    private String courseCode;
    
    private String courseName;
    
    private CourseType courseType;
    
    private SchoolName school;
    
    private String duration;
    
    private Integer credits;
    
    private List<Course> prerequisites;
    
    private String status;
    
    private List<Teacher> instructors;
    
    private Integer capacity;
    
    private Integer studentsCount;
    
    private Schedule schedule;
    
    private List<WeekDay> weekDays;


    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
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

    public SchoolName getSchool() {
        return school;
    }

    public void setSchool(SchoolName school) {
        this.school = school;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Teacher> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Teacher> instructors) {
        this.instructors = instructors;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(Integer studentsCount) {
        this.studentsCount = studentsCount;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<WeekDay> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(List<WeekDay> weekDays) {
        this.weekDays = weekDays;
    }


    public String getEnrollmentStatus() {
        return status;
    }

    public void addStudent() {
        if (studentsCount < capacity) {
            studentsCount++;
            System.out.println("Student added to the course: " + courseName);
        } else {
            System.out.println("Course is at full capacity. Cannot add more students.");
        }
    }

    public void dropStudent() {
        if (studentsCount > 0) {
            studentsCount--;
            System.out.println("Student dropped from the course: " + courseName);
        } else {
            System.out.println("No students to drop from the course.");
        }
    }

    public int countCredits() {
        return credits;
    }

    public int countStudents() {
        return studentsCount;
        
    }
}

    

