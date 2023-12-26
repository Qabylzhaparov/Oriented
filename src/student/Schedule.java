package student;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer academicYear;
    private String term;
    private List<Course> courses;
    private List<Lesson> lessons;
    private Set<WeekDay> weekdays;
    
    
    public Integer getAcademicYear() {
		return academicYear;
	}


	public void setAcademicYear(Integer academicYear) {
		this.academicYear = academicYear;
	}


	public String getTerm() {
		return term;
	}


	public void setTerm(String term) {
		this.term = term;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public List<Lesson> getLessons() {
		return lessons;
	}


	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}


	public Set<WeekDay> getWeekdays() {
		return weekdays;
	}


	public void setWeekdays(Set<WeekDay> weekdays) {
		this.weekdays = weekdays;
	}


	public void updateLesson(Lesson oldLesson, Lesson newLesson) {
        int index = lessons.indexOf(oldLesson);
        if (index != -1) {
            lessons.set(index, newLesson);
        }
    }
    
    public void printSchedule() {
        List<WeekDay> weekdays = lessons.stream().map(n->n.getDay()).collect(Collectors.toSet()).
                                         stream().sorted(Comparator.comparingInt(WeekDay::ordinal)).
                                         collect(Collectors.toList());
    	weekdays.stream()
                .sorted().forEach(day -> {
					            System.out.println(" ".repeat(24) + day);
					            lessons.stream()
					                    .filter(lesson -> lesson.getDay().equals(day))
					                    .sorted(Comparator.comparing(Lesson::getTime))
					                    .forEach(System.out::println);
        });
    }
}
