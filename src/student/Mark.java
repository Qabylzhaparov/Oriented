package student;

import java.io.Serializable;
import java.util.Map;
/**
 * The Mark class represents the assessment and grading information for a specific course.
 * It includes details such as first and second attestation scores, final exam score, GPA, mark type, and points distribution.
 *

 */
public class Mark implements Serializable {

    // Unique identifier for serialization
    private static final long serialVersionUID = 1L;

    // Properties of the Mark class
    private Course course;             // The course associated with the mark
    private Double firstAttestation;  // Score for the first attestation
    private Double secondAttestation; // Score for the second attestation
    private Double finalExam;          // Score for the final exam
    private Double GPA;                // Grade Point Average
    private MarkType markType;         // Type of the mark (e.g., Pass/Fail, Letter Grade)
    private Map<Double, String> points; // Points distribution for the course

    /**
     * Gets the course associated with the mark.
     *
     * @return The Course object.
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Sets the course associated with the mark.
     *
     * @param course The Course object to set.
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * Gets the score for the first attestation.
     *
     * @return The score for the first attestation.
     */
    public Double getFirstAttestation() {
        return firstAttestation;
    }

    /**
     * Sets the score for the first attestation.
     *
     * @param firstAttestation The score to set for the first attestation.
     */
    public void setFirstAttestation(Double firstAttestation) {
        this.firstAttestation = firstAttestation;
    }

    /**
     * Gets the score for the second attestation.
     *
     * @return The score for the second attestation.
     */
    public Double getSecondAttestation() {
        return secondAttestation;
    }

    /**
     * Sets the score for the second attestation.
     *
     * @param secondAttestation The score to set for the second attestation.
     */
    public void setSecondAttestation(Double secondAttestation) {
        this.secondAttestation = secondAttestation;
    }

    /**
     * Gets the score for the final exam.
     *
     * @return The score for the final exam.
     */
    public Double getFinalExam() {
        return finalExam;
    }

    /**
     * Sets the score for the final exam.
     *
     * @param finalExam The score to set for the final exam.
     */
    public void setFinalExam(Double finalExam) {
        this.finalExam = finalExam;
    }

    /**
     * Gets the Grade Point Average (GPA).
     *
     * @return The GPA.
     */
    public Double getGPA() {
        return GPA;
    }

    /**
     * Sets the Grade Point Average (GPA).
     *
     * @param GPA The GPA to set.
     */
    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    /**
     * Gets the type of the mark (e.g., Pass/Fail, Letter Grade).
     *
     * @return The MarkType object.
     */
    public MarkType getMarkType() {
        return markType;
    }

    /**
     * Sets the type of the mark (e.g., Pass/Fail, Letter Grade).
     *
     * @param markType The MarkType object to set.
     */
    public void setMarkType(MarkType markType) {
        this.markType = markType;
    }

    /**
     * Gets the points distribution for the course.
     *
     * @return A map containing points and corresponding descriptions.
     */
    public Map<Double, String> getPoints() {
        return points;
    }

    /**
     * Sets the points distribution for the course.
     *
     * @param points A map containing points and corresponding descriptions.
     */
    public void setPoints(Map<Double, String> points) {
        this.points = points;
    }

    /**
     * Returns a string representation of the Mark object.
     *
     * @return A formatted string with details about the mark.
     */
    @Override
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
