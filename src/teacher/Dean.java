package teacher;

import java.io.IOException;
import java.util.Scanner;

import fromUser.Database;
import fromUser.Message;
import fromUser.MessageType;
import fromUser.UrgencyLevel;
import manager.SchoolType;

/**
 * The Dean class represents a dean in the educational system. 
 * It extends the Teacher class and implements the Heads interface.
 */
public class Dean extends Teacher implements Heads {
    Scanner in = new Scanner(System.in);
    private SchoolType deanOfSchool;

    /**
     * Default constructor for Dean.
     */
    public Dean() {
        super();
    }

    /**
     * Constructor for creating a Dean with a specified name.
     *
     * @param name The name of the dean.
     */
    public Dean(String name) {
        super(name);
    }

    /**
     * Constructor for creating a Dean with specified name and school type.
     *
     * @param name         The name of the dean.
     * @param deanOfSchool The school type the dean is associated with.
     */
    public Dean(String name, SchoolType deanOfSchool) {
        super(name);
        this.deanOfSchool = deanOfSchool;
    }

    /**
     * Gets the school type associated with the dean.
     *
     * @return The school type associated with the dean.
     */
    public SchoolType getDeanOfSchool() {
        return this.deanOfSchool;
    }

    /**
     * Sets the school type associated with the dean.
     *
     * @param deanOfSchool The school type to set.
     */
    public void setDeanOfSchool(SchoolType deanOfSchool) {
        this.deanOfSchool = deanOfSchool;
    }

    /**
     * Views complaints in the database and prints them.
     */
    public void viewComplaints() {
        Database.getComplaints().forEach(System.out::println);
    }

    /**
     * Signs a complaint by creating a message and setting it to a medium urgency level.
     */
    @Override
    public void signToRequest() {
        System.out.println("Choose complaint id: ");
        int id = in.nextInt();
        Message m = new Message("Your complaint with id - " + id + " is signed by dean " + getLastName(),
                this, Database.getReceiverId(id), MessageType.Message, UrgencyLevel.MED);
    }

    /**
     * Saves the current state of the database.
     *
     * @throws IOException If an I/O error occurs.
     */
    private void save() throws IOException {
        Database.write();
    }

    /**
     * Exits the Dean menu and saves the session.
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
     * Runs the Dean menu, allowing the dean to view complaints, sign to a request, or exit.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void run() throws IOException {
        try {
            System.out.println("Welcome!");
            menu:
            while (true) {
                System.out.println("What do you want to do?\n1) View complaints  2) Sign to request  3) Exit");
                int choice = in.nextInt();
                view:
                if (choice == 1) {
                    while (true) {
                        this.viewComplaints();
                        System.out.println("\n1) Sign to request  2) Exit");
                        choice = in.nextInt();
                        if (choice == 1) {
                            choice = 2;
                            break view;
                        }
                        if (choice == 2) {
                            exit();
                            break menu;
                        }
                    }
                }
                if (choice == 2) {
                    request:
                    while (true) {
                        this.signToRequest();
                        System.out.println("\n1) Sign to another request  2) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue request;
                        if (choice == 2) {
                            exit();
                            break menu;
                        }
                    }
                }
                if (choice == 3) {
                    exit();
                    break menu;
                }
            }

        } catch (Exception e) {
            System.out.println("Something went wrong...\nSaving session...");
            e.printStackTrace();
            save();
        }
    }
}
