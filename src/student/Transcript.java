package student;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Transcript implements Serializable {

    // Unique identifier for serialization
    private static final long serialVersionUID = 1L;

    // Mapping of courses to marks
    private Map<Course, Mark> marksForCourses;

    /**
     * Constructs a new Transcript object with an empty mapping of courses to marks.
     */
    public Transcript() {
        marksForCourses = new HashMap<>();
    }

    /**
     * Gets the mapping of courses to marks in the transcript.
     *
     * @return The mapping of courses to marks.
     */
    public Map<Course, Mark> getMarksForCourses() {
        return marksForCourses;
    }

    /**
     * Sets the mapping of courses to marks in the transcript.
     *
     * @param marksForCourses The mapping of courses to marks to set.
     */
    protected void setMarksForCourses(Map<Course, Mark> marksForCourses) {
        this.marksForCourses = marksForCourses;
    }

    /**
     * Returns a string representation of the transcript, including course names and corresponding marks.
     *
     * @return A string representation of the transcript.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Transcript:\n");
        for (Entry<Course, Mark> entry : marksForCourses.entrySet()) {
            sb.append(entry.getKey().getCourseName())
              .append(" - Mark: ")
              .append(entry.getValue().getMarkType())
              .append("\n");
        }
        return sb.toString();
    }
}