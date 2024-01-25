import java.io.Serializable;

import teacher.Teacher;

/**
 * The Lesson class represents a specific instance of a course session
 * and includes information such as the course, teacher, location, time, and day.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-12-25
 */
public class Lesson implements Serializable {

    // Unique identifier for serialization
    private static final long serialVersionUID = 1L;

    // Counter to generate unique lesson IDs
    private static int lessonIdCounter = 0;

    // Properties of the Lesson class
    private int lessonId;       // Unique identifier for the lesson
    private Course course;      // The course associated with the lesson
    private String lessonName;  // The name of the lesson (usually the course name)
    private Teacher teacher;    // The teacher conducting the lesson
    private LessonType lessonType;  // The type of the lesson (e.g., Lecture, Lab)
    private String location;    // The location where the lesson takes place
    private String time;        // The time of the lesson
    private WeekDay day;        // The day of the week when the lesson occurs

    /**
     * Constructs a Lesson object with the specified parameters.
     *
     * @param course     The course associated with the lesson.
     * @param lessonType The type of the lesson (e.g., Lecture, Lab).
     * @param teacher    The teacher conducting the lesson.
     * @param location   The location where the lesson takes place.
     * @param time       The time of the lesson.
     * @param day        The day of the week when the lesson occurs.
     */
    public Lesson(Course course, LessonType lessonType, Teacher teacher, String location, String time, WeekDay day) {
        this.lessonId = generateLessonId();
        this.course = course;
        this.lessonName = course.getCourseName();
        this.lessonType = lessonType;
        this.teacher = teacher;
        this.location = location;
        this.time = time;
        this.day = day;
    }

    // Getter and setter methods...

    /**
     * Generates a unique lesson ID using a synchronized counter.
     *
     * @return The generated lesson ID.
     */
    private static synchronized int generateLessonId() {
        return ++lessonIdCounter;
    }

    /**
     * Returns a string representation of the Lesson object.
     *
     * @return A formatted string with details about the lesson.
     */
    @Override
    public String toString() {
    	return this.lessonName;
//        return String.format("%-8s %-20s %-4s %-12s %-10s",
      //          getTime(), getLessonName(), getLessonType(), getTeacher().getFirstName(), getLocation());
    }
}
