package student;

import java.sql.Array;
import java.util.*;
// Are you here?
public class Transcript {
    private Map<Course, Mark> marksForCourses ;
    private String Code;
    private TraditionalGrade TraditionalGrade;
    private Semester Semester;
    
    public Transcript() {
    	
    }
    public Transcript(String Code, TraditionalGrade TraditionalGrade, Semester Semester) {
    	this.Code = Code;
    	this.TraditionalGrade = TraditionalGrade;
    	this.Semester = Semester;
    	marksForCourses = new HashMap<>();
    }
    public Map<Course, Mark> getCourseMarkMap () {
        return marksForCourses;
    }
    public void setCourseMarkMap (Map<Course, Mark> Course ) {
        this.Course  = Course ;
    }
    public ArrayList<Mark> getMark() {
        return this.Mark;
    }

    public void setMark(ArrayList<Mark> Mark) {
        this.Mark = Mark;
    }
 
    public String getCode() {
        return this.Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public TraditionalGrade getTraditionalGrade() {
        return this.TraditionalGrade;
    }

    public void setTraditionalGrade(TraditionalGrade TraditionalGrade) {
        this.TraditionalGrade = TraditionalGrade;
    }

    public Semester getSemester() {
        return this.Semester;
    }
    public void setSemester(Semester Semester) {
        this.Semester = Semester;
    }
    

    //                          Operations                                  
    
    
}
