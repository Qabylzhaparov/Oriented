package student;

import java.io.Serializable;
import java.util.Map;

public class Mark implements Serializable {
    private static final long serialVersionUID = 1L;

    private Course course;
    private Double firstAttestation;
    private Double secondAttestation;
    private Double finalExam;
    private Double GPA;
    private MarkType markType;
    private Map<Double, String> points;
    
    
   
    public Course getCourse() {
		return course;
	}




	public void setCourse(Course course) {
		this.course = course;
	}




	public Double getFirstAttestation() {
		return firstAttestation;
	}




	public void setFirstAttestation(Double firstAttestation) {
		this.firstAttestation = firstAttestation;
	}




	public Double getSecondAttestation() {
		return secondAttestation;
	}




	public void setSecondAttestation(Double secondAttestation) {
		this.secondAttestation = secondAttestation;
	}




	public Double getFinalExam() {
		return finalExam;
	}




	public void setFinalExam(Double finalExam) {
		this.finalExam = finalExam;
	}




	public Double getGPA() {
		return GPA;
	}




	public void setGPA(Double gPA) {
		GPA = gPA;
	}




	public MarkType getMarkType() {
		return markType;
	}




	public void setMarkType(MarkType markType) {
		this.markType = markType;
	}




	public Map<Double, String> getPoints() {
		return points;
	}




	public void setPoints(Map<Double, String> points) {
		this.points = points;
	}




	public String toString() {
        return "Mark{" +
               "course=" + course.getCourseName() +
               ", firstAttestation=" + firstAttestation +
               ", secondAttestation=" + secondAttestation +
               ", finalExam=" + finalExam +
               ", GPA=" + GPA +
               ", markType=" + markType +
               '}';
    }





}
