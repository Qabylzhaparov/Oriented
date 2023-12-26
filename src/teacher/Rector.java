package teacher;

import java.io.IOException;

import fromUser.Database;
import fromUser.Message;
import fromUser.MessageType;
import fromUser.UrgencyLevel;

/**
 * The Rector class represents the head of a university, with the ability to handle strategic goals and sign requests.
 */
public class Rector extends Teacher implements Heads {

    private static Rector rector;

    private Rector() {
        // Private constructor to enforce singleton pattern
    }

    /**
     * Gets the instance of the Rector class, ensuring a singleton pattern.
     *
     * @return The singleton instance of the Rector class.
     */
    public static Rector getInstance() {
        if (rector == null) {
            rector = new Rector();
        }
        return rector;
    }

    /**
     * Adds a strategic goal to the database.
     */
    public void addStrategicGoal() {
        System.out.println("Enter strategic goal: ");
        String goal = in.nextLine();
        Database.addStrategicGoal(goal);
    }

    /**
     * Removes a strategic goal from the database.
     */
    public void removeStrategicGoal() {
        System.out.println("Enter removing strategic goal: ");
        String goal = in.nextLine();
        Database.removeStrategicGoal(goal);
    }

    /**
     * Views the complaints in the database.
     */
    public void viewComplaints() {
        Database.getComplaints().forEach(System.out::println);
    }

    @Override
    public void signToRequest() {
        System.out.println("Choose complaint id: ");
        int id = in.nextInt();
        Message m = new Message("Your complaint with id - " + id + " is signed by rector " + getLastName(),
                this, Database.getReceiverId(id), MessageType.Message, UrgencyLevel.MED);
    }

    private void save() throws IOException {
        Database.write();
    }

    private void exit() {
        System.out.println("Bye bye");
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the main menu for the Rector, allowing them to perform various tasks.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void run() throws IOException {
        try {
            System.out.println("Welcome!");
            menu: while (true) {
                System.out.println("What do you want to do?\n1) View Complaints  2) Sign to Request  3) Add Strategic Goal  4) Remove Strategic Goal  5) Exit");
                int choice = in.nextInt();
                view: if (choice == 1) {
                    while (true) {
                        this.viewComplaints();
                        System.out.println("\n1) Sign to Request  2) Exit");
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
                    request: while (true) {
                        this.signToRequest();
                        System.out.println("\n1) Sign to Another Request  2) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue request;
                        if (choice == 2) {
                            exit();
                            break menu;
                        }
                    }
                }
                if (choice == 3) {
                    add: while (true) {
                        this.addStrategicGoal();
                        System.out.println("\n1) Add Another Goal  2) Return Back  3) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue add;
                        if (choice == 2) continue menu;
                        if (choice == 3) {
                            exit();
                            break menu;
                        }
                    }
                }
                if (choice == 4) {
                    remove: while (true) {
                        this.removeStrategicGoal();
                        System.out.println("\n1) Remove Another Goal  2) Return Back  3) Exit");
                        choice = in.nextInt();
                        if (choice == 1) continue remove;
                        if (choice == 2) continue menu;
                        if (choice == 3) {
                            exit();
                            break menu;
                        }
                    }
                }
                if (choice == 5) {
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
