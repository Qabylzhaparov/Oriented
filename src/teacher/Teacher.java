package teacher;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import fromEmployee.Employee;
import fromUser.Database;
import fromUser.Message;
import fromUser.MessageType;
import fromUser.UrgencyLevel;
import fromUser.UserType;
import manager.SchoolType;
import student.Course;
import student.Student;

/**
 * The Teacher class represents a teacher in the educational system with various functionalities.
 */
public class Teacher extends Employee {

    private static final long serialVersionUID = 1014100442159559502L;

    private Scanner in = new Scanner(System.in);
    private List<Course> courses;
    private SchoolType section;
    private List<Teacher> interns;

    /**
     * Constructs a Teacher object with the specified email, password, and user type.
     * 
     * @param email      The email of the teacher.
     * @param password   The password of the teacher.
     * @param userType   The user type of the teacher.
     */
    public Teacher(String email, String password, UserType userType) {
        super(email, password, userType);
    }

    /**
     * Default constructor for the Teacher class.
     */
    public Teacher() {
        // Default constructor
    }

    /**
     * Constructs a Teacher object with the specified name.
     * 
     * @param name   The name of the teacher.
     */
    public Teacher(String name) {
        super(name);
    }

    /**
     * Gets the list of courses the teacher is associated with.
     * 
     * @return The list of courses.
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the list of courses for the teacher.
     * 
     * @param courses   The list of courses to set.
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Gets the section (school type) the teacher is associated with.
     * 
     * @return The school type.
     */
    public SchoolType getSection() {
        return section;
    }

    /**
     * Sets the section (school type) for the teacher.
     * 
     * @param section   The school type to set.
     */
    public void setSection(SchoolType section) {
        this.section = section;
    }

    /**
     * Gets the list of interns under the teacher.
     * 
     * @return The list of interns.
     */
    public List<Teacher> getInterns() {
        return interns;
    }

    /**
     * Sets the list of interns for the teacher.
     * 
     * @param interns   The list of interns to set.
     */
    public void setInterns(List<Teacher> interns) {
        this.interns = interns;
    }

    /**
     * Displays information about a selected student.
     */
    public void viewStudentInfo() {
        System.out.println("Choose student: ");
        for (Student s : Database.getAllstudents()) {
            System.out.println(s.getID() + "  " + s.getFirstName() + " " + s.getLastName());
        }
        String schoice = in.nextLine();
        Student currentStudent = Database.getStudentbyID(schoice);
        System.out.println(currentStudent.toString());
    }

    /**
     * Records a mark for a selected student.
     * 
     * @param student   The student to record the mark for.
     */
    public void putMark(Student student) {
        System.out.println("How many points: ");
        Integer point = in.nextInt();
        System.out.println("For what: ");
        String comment = in.nextLine();
        student.getMarks().putpoint(point, comment);
    }

    /**
     * Displays information about a selected course.
     * 
     * @param course   The course to display information for.
     */
    public void viewCourse(Course course) {
        System.out.println(course.toString());
    }

    /**
     * Sends a complaint message.
     */
    public void sendComplaints() {
        System.out.println("Type complaint:");
        String complaint = in.nextLine();
        System.out.println("Choose Urgency Level: 1) LOW  2) MED  3) HIGH");
        UrgencyLevel urgencyLevel = null;
        try {
            urgencyLevel = UrgencyLevel.fromString(in.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        Message m = new Message(complaint, this, MessageType.Complaint, urgencyLevel);
        Database.addMessage(m);
    }

    /**
     * Sends an order message.
     */
    public void sendOrder() {
        System.out.println("Type order: ");
        String order = in.nextLine();
        super.sendOrder(order);
    }

    /**
     * Saves the current state of the system to the database.
     * 
     * @throws IOException If an I/O error occurs.
     */
    private void save() throws IOException {
        Database.write();
    }

    /**
     * Exits the current session.
     */
    private void exit() {
        System.out.println("Session ended.");
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the main menu for the Teacher, allowing them to perform various tasks.
     * 
     * @throws IOException If an I/O error occurs.
     */
    public void run() throws IOException {
        try {
            System.out.println("Welcome!");
            menu: while (true) {
                System.out.println("What do you want to do?\n 1) Put marks  2) View Course  3) ViewStudentInfo  4) Send complaint  5) Send order  6) Exit");
                int choice = in.nextInt();
                if (choice == 1) {
                    putmark: while (true) {
                        System.out.println("Choose course: ");
                        for (Course c : courses) {
                            System.out.println(c.getCourseId() + ". " + c.getCourseName());
                        }
                        choice = in.nextInt();
                        Course currentCourse = Database.getCourseAtID(choice);
                        student: while (true) {
                            System.out.println("Choose student: ");
                            for (Student s : Database.getStudents()) {
                                if (s.getCourses().contains(currentCourse)) {
                                    System.out.println(s.getID() + ". " + s.getFirstName() + " " + s.getLastName());
                                }
                            }
                            String schoice = in.nextLine();
                            Student currentStudent = Database.getStudentbyID(schoice);
                            mark: while (true) {
                                this.putMark(currentStudent);
                                System.out.println("\n1) Put more mark  2) Change student  3) Change course  4) Return back  5) Exit");
                                choice = in.nextInt();
                                if (choice == 1) continue mark;
                                if (choice == 2) continue student;
                                if (choice == 3) continue putmark;
                                if (choice == 4) continue menu;
                                if (choice == 5) {
                                    exit();
                                    break menu;
                                }
                                break;
                            }
                        }
                    }
                } else if (choice == 2) {
                    course: while (true) {
                        Course.viewCourseInfo(courses);
                        System.out.println("\n1) Choose another course  2) Return back  3) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue course;
                        if (choice == 2) continue menu;
                        if (choice == 3) {
                            exit();
                            break menu;
                        }
                        break;
                    }
                } else if (choice == 3) {
                    student: while (true) {
                        this.viewStudentInfo();
                        System.out.println("\n1) Choose another student  2) Return back  3) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue student;
                        if (choice == 2) continue menu;
                        if (choice == 3) {
                            exit();
                            break menu;
                        }
                        break;
                    }
                } else if (choice == 4) {
                    complaint: while (true) {
                        this.sendComplaints();
                        System.out.println("\nDone\n1) Send another complaint  2) Return back  3) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue complaint;
                        if (choice == 2) continue menu;
                        if (choice == 3) {
                            exit();
                            break menu;
                        }
                        break;
                    }
                } else if (choice == 5) {
                    order: while (true) {
                        this.sendOrder();
                        System.out.println("\nDone\n1) Send another order  2) Return back  3) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue order;
                        if (choice == 2) continue menu;
                        if (choice == 3) {
                            exit();
                            break menu;
                        }
                        break;
                    }
                } else if (choice == 6) {
                    exit();
                    break menu;
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong...\n Saving session...");
            e.printStackTrace();
            save();
        }
    }

    @Override
    public void sendMessage() {
        // TODO Auto-generated method stub
    }

    @Override
    public void displayMenu() {
        // TODO Auto-generated method stub
    }
}
