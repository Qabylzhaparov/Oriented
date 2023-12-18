package student;

import java.sql.Array;
import java.util.ArrayList;

public class Transcript {
    private ArrayList<Course> Course ;
    private ArrayList<Mark> Mark;
    private String Code;
    private TraditionalGrade TraditionalGrade;
    private Semester Semester;
    
    public Transcript() {
    	
    }
    public Transcript(String Code, TraditionalGrade TraditionalGrade, Semester Semester) {
    	this.Code = Code;
    	this.TraditionalGrade = TraditionalGrade;
    	this.Semester = Semester;
    	Course = new ArrayList<>();
    	Mark = new ArrayList<>();
    }
    public ArrayList<student.Course> getCourse () {
        return this.Course ;
    }
    public void setCourse (ArrayList<Course> Course ) {
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
