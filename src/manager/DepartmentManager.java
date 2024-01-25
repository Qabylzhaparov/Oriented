package manager;
    
import java.util.*;

import student.Course;
import teacher.Teacher;


/**
 * The DepartmentManager class represents a manager responsible for overseeing a department in the educational institution management system.
 * It includes information about faculty members, department type, and inherits functionalities from the Manager class.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-12-25
 */
public class DepartmentManager extends Manager {

    // Set of faculty members associated with the department
    private Set<Teacher> facultyMembers;

    // The type of the department
    private DepartmentType departmentType;

    /**
     * Constructs a new DepartmentManager object with the specified parameters.
     *
     * @param UserType      The type of the user (e.g., ADMIN, MANAGER).
     * @param ID            The unique identifier of the user.
     * @param FirstName     The first name of the user.
     * @param LastName      The last name of the user.
     * @param Email         The email address of the user.
     * @param Password      The password of the user.
     * @param PhoneNumber   The phone number of the user.
     * @param salary        The salary of the department manager.
     * @param hireDate      The hire date of the department manager.
     */
    public DepartmentManager(UserType UserType, String ID, String FirstName, String LastName, String Email,
                             String Password, int PhoneNumber, double salary, Date hireDate) {
        super(UserType, ID, FirstName, LastName, Email, Password, PhoneNumber, salary, hireDate);
        this.facultyMembers = new HashSet<>();
    }

    /**
     * Gets the set of faculty members associated with the department.
     *
     * @return The set of faculty members.
     */
    public Set<Teacher> getFacultyMembers() {
        return this.facultyMembers;
    }

    /**
     * Sets the set of faculty members associated with the department.
     *
     * @param facultyMembers The set of faculty members to be set.
     */
    public void setFacultyMembers(Set<Teacher> facultyMembers) {
        this.facultyMembers = facultyMembers;
    }

    /**
     * Gets the type of the department.
     *
     * @return The type of the department.
     */
    public DepartmentType getDepartmentType() {
        return this.departmentType;
    }

    /**
     * Sets the type of the department.
     *
     * @param departmentType The type of the department to be set.
     */
    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }
}
