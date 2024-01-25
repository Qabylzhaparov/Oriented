package manager;

import java.io.IOException;
import java.util.*;
import fromEmployee.Employee;

import student.Student;
import teacher.Teacher;
import student.Course;

import fromUser.Database;
import fromUser.Message;
import fromUser.MessageType;
import fromUser.UserType;

/**
 * The Manager class represents a manager in the educational institution management system. It extends the Employee class
 * and provides functionality for viewing students, teachers, requests, and managing news.

 */
public class Manager extends Employee {

    // Scanner for user input
    private transient Scanner in;

    /**
     * Initializes the Scanner for user input.
     */
    private void initScanner() {
        this.in = new Scanner(System.in);
    }

    /**
     * Constructs a new Manager object with the specified email, password, and user type.
     *
     * @param email    The email of the manager.
     * @param password The password of the manager.
     * @param userType The user type of the manager.
     */
    public Manager(String email, String password, UserType userType) {
        super(email, password, userType);
    }

    /**
     * Constructs a new Manager object with the specified user type, ID, first name, last name, email, password,
     * and phone number.
     *
     * @param userType    The user type of the manager.
     * @param ID          The ID of the manager.
     * @param firstName   The first name of the manager.
     * @param lastName    The last name of the manager.
     * @param email       The email of the manager.
     * @param password    The password of the manager.
     * @param phoneNumber The phone number of the manager.
     */
    public Manager(UserType userType, String ID, String firstName, String lastName, String email, String password,
                   int phoneNumber) {
        super(userType, ID, firstName, lastName, email, password, phoneNumber);
    }

    /**
     * Constructs a new Manager object.
     */
    public Manager() {
    }

    /**
     * Displays a menu for managing students, teachers, requests, and news. Handles user input to navigate through the menu.
     *
     * @throws IOException If an error occurs during input or output operations.
     */
    public void run() throws IOException {
        try {
            initScanner();
            menu:
            while (true) {
                displayMenu();
                int choice = in.nextInt();
                if (choice == 1) {
                    viewStudents:
                    while (true) {
                        viewStudents();
                        Database.write();
                        System.out.println("\n 1) Add new user \n 2) Return back \n 3) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue viewStudents;
                        if (choice == 2) continue menu;
                        if (choice == 3) {
                            exit();
                            break menu;
                        }
                        break;
                    }
                } else if (choice == 2) {
                    viewTeachers:
                    while (true) {
                        viewTeachers();
                        Database.write();
                        System.out.println("\n 1) Remove user \n 2) Return back \n 3) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue viewTeachers;
                        if (choice == 2) continue menu;
                        if (choice == 3) {
                            exit();
                            break menu;
                        }
                        break;
                    }
                } else if (choice == 3) {
                    viewRequests:
                    while (true) {
                        viewRequests();
                        Database.write();
                        System.out.println("\n 1) Update user \n 2) Return back \n 3) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue viewRequests;
                        if (choice == 2) continue menu;
                        if (choice == 3) {
                            exit();
                            break menu;
                        }
                        break;
                    }
                } else if (choice == 4) {
                    addNews:
                    while (true) {
                        addNews();
                        Database.write();
                        System.out.println("\n 1) Show a users list \n 2) Return back \n 3) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue addNews;
                        if (choice == 2) continue menu;
                        if (choice == 3) {
                            exit();
                            break menu;
                        }
                        break;
                    }
                } else if (choice == 5) {
                    removeNews:
                    while (true) {
                        removeNews();
                        Database.write();
                        System.out.println("\n 1) Show a users list \n 2) Return back \n 3) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue removeNews;
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
            System.out.println("Something bad happened... \n Saving resources...");
            e.printStackTrace();
            save();
        } finally {
            if (in != null) in.close();
            // Close the Scanner
        }
    }

    /**
     * Displays the manager's menu options.
     */
    @Override
    public void displayMenu() {
        System.out.println("--------Manager's menu----------------");
        System.out.println("====================================");
        System.out.println("*	1) View Students             *");
        System.out.println("*	2) View Teachers             *");
        System.out.println("*	3) View and Manage Requests  *");
        System.out.println("*	4) Add News                  *");
        System.out.println("*	5) Remove News               *");
        System.out.println("*	6) Exit                      *");
        System.out.println("====================================");
    }

    /**
     * Displays a list of students.
     */
    public void viewStudents() {
        // Implement logic to display students
    }

    /**
     * Displays a list of teachers.
     */
    public void viewTeachers() {
        // Implement logic to display teachers
    }

    /**
     * Displays a list of requests.
     */
    public void viewRequests() {
        // Implement logic to display and manage requests
    }

    /**
     * Adds news to the system.
     */
    private void addNews() {
        try {
            System.out.println("Choose category: \n1) Research \n2) Study");
            int catChoice = in.nextInt();
            in.nextLine();
//            Category category = Category.get(catChoice - 1);

            System.out.println("Enter headline:");
            String headline = in.nextLine();

            System.out.println("Enter topic:");
            String topic = in.nextLine();

            // Implement logic to add news

            System.out.println("News added successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while adding news: " + e.getMessage());
        }
    }

    /**
     * Removes news from the system.
     */
    private void removeNews() {
        try {
            System.out.println("Enter the ID of the news to remove:");
            int id = in.nextInt();
            // Implement logic to remove news
            Database.write();
            System.out.println("News removed successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while removing news: " + e.getMessage());
        }
    }

    /**
     * Saves data to the database.
     *
     * @throws IOException If an error occurs during input or output operations.
     */
    private void save() throws IOException {
        Database.write();
    }

    /**
     * Exits the program.
     */
    private void exit() {
        System.out.println("Bye bye");
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a message (not implemented in the Manager class).
     */
    @Override
    public void sendMessage() {
        // TODO Auto-generated method stub
    }

    /**
     * Sends an order (not implemented in the Manager class).
     */
    @Override
    public void sendOrder() {
        // TODO Auto-generated method stub
    }
}
