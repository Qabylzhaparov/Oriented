package student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fromUser.Database;
import manager.SchoolType;
import teacher.Teacher;

/**
 * The class representing a course offered in an educational institution.
 */
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int courseIdCounter = 1;
    private int courseId;
    private String courseName;
    private CourseType courseType;
    private SchoolType school;
    private Integer credits;
    private List<Course> prerequisites = new ArrayList<>();
    private List<Teacher> instructors = new ArrayList<>();

    /**
     * Default constructor for the Course class.
     * Initializes the course ID.
     */
    public Course() {
        this.courseId = courseIdCounter++;
    }

    /**
     * Parameterized constructor for the Course class.
     *
     * @param name    The name of the course.
     * @param credits The number of credits for the course.
     */
    public Course(String name, Integer credits) {
        this();
        this.courseName = name;
        this.credits = credits;
    }

    /**
     * Gets the ID of the course.
     *
     * @return The course ID.
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Sets the ID of the course.
     *
     * @param courseId The course ID to set.
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the name of the course.
     *
     * @return The course name.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of the course.
     *
     * @param courseName The course name to set.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the type of the course.
     *
     * @return The course type.
     */
    public CourseType getCourseType() {
        return courseType;
    }

    /**
     * Sets the type of the course.
     *
     * @param courseType The course type to set.
     */
    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    /**
     * Gets the school type associated with the course.
     *
     * @return The school type.
     */
    public SchoolType getSchool() {
        return school;
    }

    /**
     * Sets the school type associated with the course.
     *
     * @param school The school type to set.
     */
    public void setSchool(SchoolType school) {
        this.school = school;
    }

    /**
     * Gets the number of credits for the course.
     *
     * @return The number of credits.
     */
    public Integer getCredits() {
        return credits;
    }

    /**
     * Sets the number of credits for the course.
     *
     * @param credits The number of credits to set.
     */
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    /**
     * Gets the list of prerequisites for the course.
     *
     * @return The list of prerequisites.
     */
    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    /**
     * Sets the list of prerequisites for the course.
     *
     * @param prerequisites The list of prerequisites to set.
     */
    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    /**
     * Gets the list of instructors for the course.
     *
     * @return The list of instructors.
     */
    public List<Teacher> getInstructors() {
        return instructors;
    }

    /**
     * Sets the list of instructors for the course.
     *
     * @param instructors The list of instructors to set.
     */
    public void setInstructors(List<Teacher> instructors) {
        this.instructors = instructors;
    }

    /**
     * Adds an instructor to the list of instructors for the course.
     *
     * @param teacher The instructor to add.
     */
    public void addInstructor(Teacher teacher) {
        instructors.add(teacher);
    }

    /**
     * Removes an instructor from the list of instructors for the course.
     *
     * @param teacher The instructor to remove.
     */
    public void removeInstructor(Teacher teacher) {
        instructors.remove(teacher);
    }

    /**
     * Displays information about a specific course.
     *
     * @param courses The list of courses to choose from.
     */
    public static void viewCourseInfo(List<Course> courses) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose course: ");
        for (Course c : courses) {
            System.out.println(c.getCourseId() + ". " + c.getCourseName());
        }
        int courseId = scanner.nextInt();
        Course selectedCourse = Database.getCourseAtID(courseId - 1);

        if (selectedCourse != null) {
            System.out.println(selectedCourse);
        } else {
            System.out.println("Course not found.");
        }
    }

    /**
     * Checks if two courses are equal based on their IDs.
     *
     * @param obj The object to compare.
     * @return True if the courses are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return courseId == course.courseId;
    }

    /**
     * Generates a hash code for the course based on its ID.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(courseId);
    }

    /**
     * Generates a string representation of the course.
     *
     * @return A formatted string representation of the course.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Course{");
        sb.append("courseId=").append(courseId);
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", courseType=").append(courseType);
        sb.append(", school=").append(school);
        sb.append(", credits=").append(credits);
        sb.append(", prerequisites=").append(prerequisites);
        sb.append(", instructors=").append(instructors);
        sb.append('}');
        return sb.toString();
    }
}
