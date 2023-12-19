package student;

import java.util.*;
import java.util.Map.Entry;

public class Transcript {
    private Map<Course, Mark> marksForCourses ;

    public Transcript() {
    	marksForCourses = new HashMap<>();
    }
     
    public Map<Course, Mark> getMarksForCourses() {
		return marksForCourses;
	}

	public void setMarksForCourses(Map<Course, Mark> marksForCourses) {
		this.marksForCourses = marksForCourses;
	}

    //                          Operations                                  
    
    public String toString() {
    	String t = "-".repeat(24);
    	for (Entry<Course, Mark> entry : marksForCourses.entrySet()) {
    		t += String.format(entry.getKey().getCourseName() + (20) + "s %d", entry.getKey(), entry.getValue()); 
    	}
    	t += "-".repeat(24);
    	
    	return t;
    }
    
}
