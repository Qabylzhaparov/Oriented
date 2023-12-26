package student;

import java.util.*;
import java.util.Map.Entry;
/**
 * The class representing a student's transcript that contains information about courses and their corresponding marks.
 */
public class Transcript {
    private Map<Course, Mark> marksForCourses ;

    public Transcript() {
    	marksForCourses = new HashMap<>();
    }
    /**
     * Gets the courses and marks in the transcript.
     *
     * @return The map of courses and marks.
     */
    public Map<Course, Mark> getMarksForCourses() {
		return marksForCourses;
	}
    /**
     * Sets the map of courses and marks in the transcript.
     *
     * @param marksForCourses The map of courses and marks to set.
     */
	public void setMarksForCourses(Map<Course, Mark> marksForCourses) {
		this.marksForCourses = marksForCourses;
	}

                                  
	 /**
     * Generates a string representation of the transcript.
     *
     * @return A formatted string representation of the transcript.
     */
    public String toString() {
    	String t = "-".repeat(24);
    	for (Entry<Course, Mark> entry : marksForCourses.entrySet()) {
    		t += String.format(entry.getKey().getCourseName() + (20) + "s %d", entry.getKey(), entry.getValue()); 
    	}
    	t += "-".repeat(24);
    	
    	return t;
    }
    
}
