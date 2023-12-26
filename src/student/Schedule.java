package student;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * The Schedule class represents the academic schedule for a specific term, including courses and lessons.
 * It provides methods for updating lessons and printing the schedule.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-12-25
 */
public class Schedule implements Serializable {

    // Unique identifier for serialization
    private static final long serialVersionUID = 1L;

    // Properties of the Schedule class
    private Integer academicYear;   // The academic year associated with the schedule
    private String term;            // The term (e.g., Fall, Spring, Summer)
    private List<Course> courses;   // List of courses in the schedule
    private List<Lesson> lessons;   // List of lessons in the schedule
    private Set<WeekDay> weekdays;  // Set of weekdays included in the schedule

    /**
     * Gets the academic year associated with the schedule.
     *
     * @return The academic year.
     */
    public Integer getAcademicYear() {
        return academicYear;
    }

    /**
     * Sets the academic year associated with the schedule.
     *
     * @param academicYear The academic year to set.
     */
    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    /**
     * Gets the term (e.g., Fall, Spring, Summer).
     *
     * @return The term.
     */
    public String getTerm() {
        return term;
    }

    /**
     * Sets the term (e.g., Fall, Spring, Summer).
     *
     * @param term The term to set.
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * Gets the list of courses in the schedule.
     *
     * @return The list of courses.
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the list of courses in the schedule.
     *
     * @param courses The list of courses to set.
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Gets the list of lessons in the schedule.
     *
     * @return The list of lessons.
     */
    public List<Lesson> getLessons() {
        return lessons;
    }

    /**
     * Sets the list of lessons in the schedule.
     *
     * @param lessons The list of lessons to set.
     */
    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    /**
     * Gets the set of weekdays included in the schedule.
     *
     * @return The set of weekdays.
     */
    public Set<WeekDay> getWeekdays() {
        return weekdays;
    }

    /**
     * Sets the set of weekdays included in the schedule.
     *
     * @param weekdays The set of weekdays to set.
     */
    public void setWeekdays(Set<WeekDay> weekdays) {
        this.weekdays = weekdays;
    }

    /**
     * Updates a lesson in the schedule with a new lesson.
     *
     * @param oldLesson The old lesson to be replaced.
     * @param newLesson The new lesson to replace the old lesson.
     */
    public void updateLesson(Lesson oldLesson, Lesson newLesson) {
        int index = lessons.indexOf(oldLesson);
        if (index != -1) {
            lessons.set(index, newLesson);
        }
    }

    /**
     * Prints the academic schedule, organized by weekdays and time slots.
     */
    public void printSchedule() {
        List<WeekDay> sortedWeekdays = lessons.stream()
                .map(Lesson::getDay)
                .collect(Collectors.toSet())
                .stream()
                .sorted(Comparator.comparingInt(WeekDay::ordinal))
                .collect(Collectors.toList());

        sortedWeekdays.forEach(day -> {
            System.out.println(" ".repeat(24) + day);
            lessons.stream()
                    .filter(lesson -> lesson.getDay().equals(day))
                    .sorted(Comparator.comparing(Lesson::getTime))
                    .forEach(System.out::println);
        });
    }
}
